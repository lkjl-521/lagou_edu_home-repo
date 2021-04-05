package com.lagou.service.impl;

import com.lagou.dao.TestDao;
import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/3/31 - 14:47
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> findAllTest() {
        List<Test> tests = testDao.findAllTest();
        return tests;
    }
}
