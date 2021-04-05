package com.lagou.service.impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 11:30
 */
@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper psm;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        List<PromotionSpace> list = psm.findAllPromotionSpace();
        return list;
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        // 封装数据
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        // 调用dao
        psm.savePromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findPromotionSpaceById(int id) {
        return psm.findPromotionSpaceById(id);
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        promotionSpace.setUpdateTime(new Date());
        psm.updatePromotionSpace(promotionSpace);
    }
}
