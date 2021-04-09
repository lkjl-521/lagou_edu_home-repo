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

    /*
        添加资源
     */
    void saveResource(Resource resource);

    /*
        修改资源
     */
    void updateResource(Resource resource);

    /*
        删除资源
     */
    void deleteResource(Integer id);
}
