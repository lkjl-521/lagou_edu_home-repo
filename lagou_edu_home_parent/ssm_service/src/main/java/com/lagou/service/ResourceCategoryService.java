package com.lagou.service;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 11:40
 */
public interface ResourceCategoryService {
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
        删除资源分类信息
     */
    public ResponseResult deleteResourceCategory(Integer id);
}
