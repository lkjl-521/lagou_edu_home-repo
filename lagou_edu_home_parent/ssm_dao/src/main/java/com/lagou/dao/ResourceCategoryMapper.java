package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 11:36
 */
public interface ResourceCategoryMapper {

    /*
        查询所有资源分类
     */
    public List<ResourceCategory> findAllResourceCategory();

    /*
        新增资源分类信息
     */
    public void saveResourceCategory(ResourceCategory resourceCategory);

    /*
        修改资源分类信息
     */
    public void updateResourceCategory(ResourceCategory resourceCategory);

    /*
        根据id查询指定的资源分类信息是否关联资源信息
     */
    public int findResourceCategoryContainResource(Integer id);

    /*
        删除资源分类信息
     */
    public void deleteResourceCategory(Integer id);


}
