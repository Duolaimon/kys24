package com.duol.shop.service.impl;

import com.duol.shop.controller.ShopController;
import com.duol.shop.dao.VarietyDao;
import com.duol.shop.entity.Variety;
import com.duol.shop.service.VarietyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Duolaimon
 *         17-4-29 下午3:39
 */
@Service
public class VarietyServiceImpl implements VarietyService {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    /**
     * 所有分类信息
     */
    private List<Variety> varietyList;

    private final VarietyDao varietyDao;
    @Autowired
    public VarietyServiceImpl(VarietyDao varietyDao) {
        this.varietyDao = varietyDao;
        varietyList = varietyDao.queryAllVariety();
    }

    @Override
    public List<Variety> getAllVarietyList() {
        return varietyList;
    }
}
