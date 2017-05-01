package com.duol.shop.service;

import com.duol.shop.entity.Commodity;
import com.duol.shop.dto.CommodityMainInfo;

import java.util.List;
import java.util.Optional;

/**
 * @author Duolaimon
 *         17-4-29 上午10:44
 */
public interface CommodityService {
    List<Commodity> getCommodityList();

    List<CommodityMainInfo> getCommodityInfoList();

    List<CommodityMainInfo> getCommodityInfoListByBrandId(int brandId);

    List<CommodityMainInfo> getCommodityInfoListByVarietyId(int varietyId);

    List<CommodityMainInfo> getCommodityInfoById(int commodityId);

    List<CommodityMainInfo> getCommodityMainInfoListBySearch(String searchKey);
}
