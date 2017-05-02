package com.duol.shop.service;

import com.duol.shop.entity.Commodity;
import com.duol.shop.dto.CommodityMainInfo;
import org.springframework.web.multipart.MultipartFile;

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

    Commodity getCommodityInfoById(int commodityId);

    List<CommodityMainInfo> getCommodityMainInfoListBySearch(String searchKey);

    /*
     * 对商品的后台处理
     */
    void addCommodity(Commodity commodity);

    void setCommodity(Commodity commodity) throws Exception;

    Commodity removeCommodity(int commodityId) throws Exception;


    String storePicture(int commodityId, MultipartFile file);
}
