package com.lagou.dao;

import com.lagou.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 20:43
 */
public interface RoleMapper {
    /*
        查询所有角色&条件查询
     */
    public List<Role> findAllRole(Role role);

    /*
        根据角色id查询角色关联的菜单信息ID
     */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /*
        根据roleId清空中间表的关联关系
     */
    public void deleteRoleContextMenu(Integer rid);
    public void deleteRoleContextResource(Integer rid);

    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation rmr);

    /*
        根据角色id查询角色关联的资源分类信息
     */
    public List<ResourceCategory> findResourceCategoryByRoleId(Integer roleId);

    /*
        根据角色id和资源分类id查询角色关联的资源信息
     */
    public List<Resource> findResourceList(@Param("roleId") Integer roleId, @Param("categoryId") Integer categoryId);

    /*
        为角色分配资源信息
     */
    public void roleContextResource(Role_resource_relation rrr);

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
