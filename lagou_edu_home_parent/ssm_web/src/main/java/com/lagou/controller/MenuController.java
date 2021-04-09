package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
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
 * @date 2021/4/3 - 9:40
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /*
        查询所有菜单列表
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(Integer currentPage, Integer pageSize) {
        PageInfo<Menu> pageInfo = menuService.findAllMenu(currentPage, pageSize);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有菜单信息成功", pageInfo);
        return responseResult;
    }

    /*
        回显菜单信息
     */
    @RequestMapping("/findMenuById")
    public ResponseResult findMenuInfoById(Integer id) {

        Map<String, Object> map = new HashMap<>();
        List<Menu> menus = menuService.findSubMenuListByPid(-1);
        map.put("parentMenuList", menus);
        // 根据id的值判断当前是更新还是添加操作，判断id的值是否为-1
        if (id == -1) {
            // 添加操作
            map.put("menuInfo", null);
            return new ResponseResult(true, 200, "添加功能回显成功", map);
        } else {
            // 修改操作
            Menu menu = menuService.findMenuById(id);
            map.put("menuInfo", menu);
            return new ResponseResult(true, 200, "修改功能回显成功", map);
        }
    }

    /*
        添加或修改菜单信息
     */
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu) {
        if (menu.getId() == null) {
            // 新增
            menuService.saveMenu(menu);
            return new ResponseResult(true, 200, "新增成功", null);
        } else {
            // 修改
            menuService.updateMenu(menu);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }

    /*
        删除菜单
     */
    @RequestMapping("/deleteMenu")
    public ResponseResult deleteMenu(Integer menuId) {
        return menuService.deleteMenu(menuId);
    }
}
