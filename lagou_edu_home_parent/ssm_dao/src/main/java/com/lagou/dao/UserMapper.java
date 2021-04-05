package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 18:24
 */
public interface UserMapper {
    /*
        分页显示&多条件查询
     */
    public List<User> findAllUserByPage(UserVO userVO);

    /*
        用户登录（根据用户名查询具体信息）
     */
    public User login(User user);

    /*
        根据用户id清空中间表
     */
    public void deleteUserContextRole(Integer id);

    /*
        分配角色
     */
    public void userContextRole(User_Role_relation ur);

    /*
        根据用户id查询关联的角色信息
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /*
        根据角色id查询角色拥有的顶级菜单
     */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /*
        根据pid查询子菜单信息
     */
    public List<Menu> findSubMenuByPid(Integer pid);

    /*
        获取用户拥有的资源信息
     */
    public List<Resource> findResourceByRoleId(List<Integer> ids);

}
