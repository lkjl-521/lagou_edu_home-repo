package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 21:25
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        return menuMapper.findSubMenuListByPid(pid);
    }

    @Override
    public PageInfo<Menu> findAllMenu(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Menu> allMenu = menuMapper.findAllMenu();
        PageInfo<Menu> pageInfo = new PageInfo<>(allMenu);
        return pageInfo;
    }

    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }

    @Override
    public void saveMenu(Menu menu) {
        Date date = new Date();
        menu.setCreatedTime(date);
        menu.setUpdatedTime(date);
        menu.setCreatedBy("system");
        menu.setUpdatedBy("system");
        if (menu.getParentId() == -1) {
            menu.setLevel(0);
        } else {
            menu.setLevel(1);
        }

        menuMapper.saveMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menu.setUpdatedTime(new Date());
        menu.setUpdatedBy("system");
        if (menu.getParentId() == -1) {
            menu.setLevel(0);
        } else {
            menu.setLevel(1);
        }

        menuMapper.updateMenu(menu);
    }

    @Override
    public ResponseResult deleteMenu(Integer menuId) {
        Integer countIds = menuMapper.findSubMenuId(menuId);
        if (countIds > 0) {
            return new ResponseResult(true, 400, "删除失败", null);
        }

        menuMapper.deleteMenuById(menuId);
        menuMapper.deleteMenuContextRole(menuId);
        return new ResponseResult(true, 200, "删除成功", null);
    }
}
