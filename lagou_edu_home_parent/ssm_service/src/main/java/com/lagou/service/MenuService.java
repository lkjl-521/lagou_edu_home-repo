package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 21:24
 */
public interface MenuService {
    /*
        查询所有父子菜单信息
     */
    public List<Menu> findSubMenuListByPid(int pid);

    /*
        查询所有菜单列表
     */
    public PageInfo<Menu> findAllMenu(Integer currentPage, Integer pageSize);

    /*
         根据id查询menu
    */
    public Menu findMenuById(Integer id);

    /*
        新增菜单
     */
    void saveMenu(Menu menu);

    /*
        修改菜单
     */
    void updateMenu(Menu menu);

    /*
        删除菜单
     */
    ResponseResult deleteMenu(Integer menuId);
}
