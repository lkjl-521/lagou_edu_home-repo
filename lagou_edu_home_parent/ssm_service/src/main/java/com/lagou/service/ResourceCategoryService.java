package com.lagou.service;

import com.lagou.domain.ResourceCategory;

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
}
