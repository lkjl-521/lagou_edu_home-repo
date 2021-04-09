package com.lagou.service;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 20:47
 */
public interface RoleService {
    /*
       查询所有角色&条件查询
    */
    public List<Role> findAllRole(Role role);

    /*
        根据角色id查询角色关联的菜单信息ID
     */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(RoleMenuVO roleMenuVO);

    /*
        根据id获取角色拥有的资源信息
     */
    public List<ResourceCategory> findResourceListByRoleId(Integer roleId);

    /*
        为角色分配资源信息
     */
    public void roleContextResource(RoleResourceVO roleResourceVO);


    /*
        添加角色信息
     */
    void saveRole(Role role);

    /*
        修改角色信息
     */
    void updateRole(Role role);

    /*
        删除角色
     */
    public void deleteRole(Integer roleId);
}
