package com.lagou.dao;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/3/31 - 14:09
 */
public interface TestDao {
    /*
        查询test表
     */
    public List<Test> findAllTest();
}
