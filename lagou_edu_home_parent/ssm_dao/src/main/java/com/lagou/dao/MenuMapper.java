package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 21:12
 */
public interface MenuMapper {
    /*
        查询所有父子菜单信息
     */
    public List<Menu> findSubMenuListByPid(int pid);

    /*
        查询所有菜单列表
     */
    public List<Menu> findAllMenu();

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
    void deleteMenuById(Integer id);

    /*
        根据id查询子菜单
     */
    Integer findSubMenuId(Integer id);

    /*
        删除角色菜单表的相关关系
     */
    void deleteMenuContextRole(Integer menuId);
}
