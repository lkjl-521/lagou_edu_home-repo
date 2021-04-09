package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 10:32
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO) {
        PageHelper.startPage(resourceVO.getCurrentPage(), resourceVO.getPageSize());

        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourceVO);

        PageInfo<Resource> resourcePageInfo = new PageInfo<>(allResourceByPage);

        return resourcePageInfo;
    }

    @Override
    public void saveResource(Resource resource) {
        Date date = new Date();
        resource.setCreatedTime(date);
        resource.setUpdatedTime(date);
        resource.setCreatedBy("system");
        resource.setUpdatedBy("system");

        resourceMapper.saveResource(resource);
    }

    @Override
    public void updateResource(Resource resource) {
        resource.setUpdatedBy("system");
        resource.setUpdatedTime(new Date());

        resourceMapper.updateResource(resource);
    }

    @Override
    public void deleteResource(Integer id) {
        resourceMapper.deleteResourceContextRole(id);
        resourceMapper.deleteResource(id);
    }
}
