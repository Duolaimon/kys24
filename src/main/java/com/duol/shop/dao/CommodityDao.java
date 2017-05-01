package com.duol.shop.dao;

import com.duol.shop.entity.Commodity;

import java.util.List;

/**
 * @author Duolaimon
 *         17-4-29 上午10:32
 */
public interface CommodityDao {
    /**
     * 查找所有商品的所有信息
     * @return  商品信息列表
     */
    List<Commodity> queryCommodityList();

}
