package com.duol.shop.service.impl;

import com.duol.shop.controller.ShopController;
import com.duol.shop.dao.BrandDao;
import com.duol.shop.entity.Brand;
import com.duol.shop.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Duolaimon
 *         17-4-29 下午12:35
 */
@Service
public class BrandServiceImpl implements BrandService {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    /**
     * 所有品牌的信息
     */
    private List<Brand> brandList;
    @Autowired
    public BrandServiceImpl(BrandDao brandDao) {
        brandList = brandDao.queryBrandList();
    }

    @Override
    public List<Brand> getBrandList() {
        logger.info("getBrandList = {}",brandList);
        return brandList;
    }
}
