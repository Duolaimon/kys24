package com.duol.shop.service.impl;

import com.duol.shop.controller.ShopController;
import com.duol.shop.dao.CommodityDao;
import com.duol.shop.entity.Commodity;
import com.duol.shop.dto.CommodityMainInfo;
import com.duol.shop.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Duolaimon
 *         17-4-29 上午11:00
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    /**
     * 所有商品的完整信息
     */
    private List<Commodity> commodityList;
    /**
     * 商城页面的商品部分信息
     */
    private List<CommodityMainInfo> commodityMainInfoList;

    private final CommodityDao commodityDao;

    @Autowired
    public CommodityServiceImpl(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
        commodityList = commodityDao.queryCommodityList();
        commodityMainInfoList = commodityList.stream().map(c ->
                new CommodityMainInfo(c.getCommodityID(), c.getCommodityBrand(),
                        c.getCommodityVariety(), c.getCommodityName(),
                        c.getCommodityPrice(), c.getCommodityPicture())
        ).collect(Collectors.toList());
    }

    /**
     * 获得所有商品的完整信息
     *
     * @return 所有商品完整信息
     */
    @Override
    public List<Commodity> getCommodityList() {
        logger.info("showProduceList : ...");
        return commodityList;
    }

    /**
     * 使用流运算处理{@link Commodity}列表,获得{@link CommodityMainInfo}列表
     *
     * @return 商城页面的商品展示信息
     */
    @Override
    public List<CommodityMainInfo> getCommodityInfoList() {
        return commodityMainInfoList;
    }

    /**
     * 使用流运算处理所有商城页面商品信息,获得指定品牌商品信息
     *
     * @param brandId 品牌id
     * @return 商城页面指定品牌商品展示信息
     */
    @Override
    public List<CommodityMainInfo> getCommodityInfoListByBrandId(int brandId) {
        return commodityMainInfoList.stream()
                .filter(c -> c.getCommodityBrand() == brandId)
                .collect(Collectors.toList());
    }

    /**
     * 使用流运算处理所有商城页面商品信息,获得指定种类商品信息
     *
     * @param varietyId 种类id
     * @return 商城页面指定种类商品展示信息
     */
    @Override
    public List<CommodityMainInfo> getCommodityInfoListByVarietyId(int varietyId) {
        return commodityMainInfoList.stream()
                .filter(c -> c.getCommodityVariety() == varietyId)
                .collect(Collectors.toList());
    }

    /**
     * 使用流运算处理所有商城页面商品信息,获得指定商品信息
     * @param commodityId   商品id
     * @return  商品展示页面商品信息
     */
    @Override
    public List<CommodityMainInfo> getCommodityInfoById(int commodityId) {
        return commodityMainInfoList.stream()
                .filter(c -> c.getCommodityID() == commodityId)
                .collect(Collectors.toList());
    }

    /**
     * 使用流运算处理所有商城页面商品信息，获得包含指定关键字的商品信息
     *
     * @param searchKey 指定关键字
     * @return 指定关键字的商品信息
     */
    public List<CommodityMainInfo> getCommodityMainInfoListBySearch(String searchKey) {
        return commodityMainInfoList.stream()
                .filter(c -> c.getCommodityName().contains(searchKey))
                .collect(Collectors.toList());
    }
}
