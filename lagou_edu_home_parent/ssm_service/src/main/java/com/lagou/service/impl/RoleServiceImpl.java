package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 20:47
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    @Override
    public void roleContextMenu(RoleMenuVO roleMenuVO) {
        // 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVO.getRoleId());

        // 为角色分配菜单
        Date date = new Date();
        for (Integer integer : roleMenuVO.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(integer);
            role_menu_relation.setRoleId(roleMenuVO.getRoleId());
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedBy("system");
            roleMapper.roleContextMenu(role_menu_relation);
        }
    }

    @Override
    public List<ResourceCategory> findResourceListByRoleId(Integer roleId) {
        List<ResourceCategory> resourceCategoryList = roleMapper.findResourceCategoryByRoleId(roleId);
        for (ResourceCategory resourceCategory : resourceCategoryList) {
            List<Resource> resourceList = roleMapper.findResourceList(roleId, resourceCategory.getId());
            resourceCategory.setResourceList(resourceList);
        }
        return resourceCategoryList;
    }

    @Override
    public void roleContextResource(RoleResourceVO roleResourceVO) {
        // 清空中间表的关联关系
        roleMapper.deleteRoleContextResource(roleResourceVO.getRoleId());

        // 为角色分配菜单
        Date date = new Date();
        for (Integer integer : roleResourceVO.getResourceIdList()) {
            Role_resource_relation rrr = new Role_resource_relation();
            rrr.setResourceId(integer);
            rrr.setRoleId(roleResourceVO.getRoleId());
            rrr.setCreatedTime(date);
            rrr.setUpdatedTime(date);
            rrr.setCreatedBy("system");
            rrr.setUpdatedBy("system");
            roleMapper.roleContextResource(rrr);
        }
    }

    @Override
    public void saveRole(Role role) {
        Date date = new Date();
        role.setCreatedTime(date);
        role.setUpdatedTime(date);
        role.setCreatedBy("system");
        role.setUpdatedBy("system");

        roleMapper.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        role.setUpdatedBy("system");
        role.setUpdatedTime(new Date());

        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRole(Integer roleId) {
        // 清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleId);
        roleMapper.deleteRoleContextResource(roleId);
        // 删除角色
        roleMapper.deleteRole(roleId);
    }
}
