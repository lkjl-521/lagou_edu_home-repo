package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 10:20
 */
public interface ResourceMapper {

    /*
        资源分类和多条件查询
    */
    public List<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
