package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 18:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVO userVO) {
        PageHelper.startPage(userVO.getCurrentPage(), userVO.getPageSize());

        List<User> users = userMapper.findAllUserByPage(userVO);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public User login(User user) throws Exception {
        User user1 = userMapper.login(user);
        if (user1 != null && Md5.verify(user.getPassword(), "lagou",user1.getPassword())) {
            return user1;
        } else {
            return null;
        }
    }

    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        return userMapper.findUserRelationRoleById(id);
    }

    @Override
    public void userContextRole(UserVO userVO) {
        // 根据id清空用户角色关系
        userMapper.deleteUserContextRole(userVO.getUserId());

        // 重新建立角色和用户的关系
        List<Integer> roleIdList = userVO.getRoleIdList();
        Date date = new Date();
        for (Integer integer : roleIdList) {
            User_Role_relation ur = new User_Role_relation();
            ur.setUserId(userVO.getUserId());
            ur.setRoleId(integer);
            ur.setCreatedTime(date);
            ur.setUpdatedTime(date);
            ur.setCreatedBy("system");
            ur.setUpdatedBy("system");

            userMapper.userContextRole(ur);
        }
    }

    @Override
    public ResponseResult getUserPermissions(Integer userId) {
        // 1. 获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(userId);
        // 2. 获取角色id保存到集合中
        List<Integer> roleIds = new ArrayList<>();
        for (Role role : roleList) {
            roleIds.add(role.getId());
        }
        // 3. 根据角色id查询父菜单
        List<Menu> parentMenus = userMapper.findParentMenuByRoleId(roleIds);
        // 4. 封装父菜单关联的子菜单
        for (Menu parentMenu : parentMenus) {
            parentMenu.setSubMenuList(userMapper.findSubMenuByPid(parentMenu.getId()));
        }
        // 5. 获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        // 6. 封住数据并返回
        Map<String, Object> map = new HashMap<>();
        map.put("menuList",parentMenus);
        map.put("resourceList",resourceList);

        return new ResponseResult(true, 200, "获取用户权限信息成功", map);
    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        user.setUpdateTime(new Date());

        userMapper.updateUserStatus(user);
    }
}
