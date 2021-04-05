package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.ResourceCategoryService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 20:48
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /*
        查询所有角色(条件)
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role) {
        List<Role> roles = roleService.findAllRole(role);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有角色成功", roles);
        return responseResult;
    }

    /*
        查询所有的父子菜单信息
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid() {
        // -1表示所有父级菜单
        List<Menu> list = menuService.findSubMenuListByPid(-1);
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList",list);

        return new ResponseResult(true, 200, "查询父子菜单成功",map);
    }

    /*
        根据角色id查询角色关联的菜单信息ID
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuById(Integer roleId) {
        List<Integer> list = roleService.findMenuByRoleId(roleId);
        return  new ResponseResult(true, 200, "查询角色关联的菜单信息成功", list);
    }

    /*
        为角色分配菜单
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVO roleMenuVO) {
        roleService.roleContextMenu(roleMenuVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", null);
        return responseResult;
    }

    /*
         获取当前角色拥有的资源信息
     */
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(Integer roleId) {
        List<ResourceCategory> list = roleService.findResourceListByRoleId(roleId);

        return new ResponseResult(true, 200, "获取角色资源信息成功", list);
    }

    /*
        为角色分配资源
     */
    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVO roleResourceVO) {
        roleService.roleContextResource(roleResourceVO);

        return new ResponseResult(true, 200, "响应成功", null);
    }


    /*
        删除角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer roleId) {
        roleService.deleteRole(roleId);

        return  new ResponseResult(true, 200, "删除角色成功", null);
    }
}
