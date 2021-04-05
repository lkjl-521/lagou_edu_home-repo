package com.lagou.service;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/3/31 - 14:46
 */
public interface TestService {
    /*
          对test1表进行查询
     */
    List<Test> findAllTest();
}
