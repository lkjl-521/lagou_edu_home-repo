package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 10:32
 */
public interface ResourceService {
    /*
        资源分类和多条件查询
    */
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
