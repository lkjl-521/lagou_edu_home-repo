package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 18:36
 */
public interface UserService {
    /*
        分页显示&多条件查询
     */
    public PageInfo findAllUserByPage(UserVO userVO);

    /*
       用户登录（根据用户名查询具体信息）
    */
    public User login(User user) throws Exception;

    /*
        根据用户id查询关联的角色信息  回显
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /*
        用户关联角色
     */
    public void userContextRole(UserVO userVO);

    /*
           获取用户权限，进行动态展示
     */
    public ResponseResult getUserPermissions(Integer userId);

    /*
        修改用户状态
     */
    void updateUserStatus(Integer id, String status);
}
