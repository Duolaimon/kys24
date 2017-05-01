package com.duol.shop.controller;

import com.duol.shop.entity.Brand;
import com.duol.shop.entity.Commodity;
import com.duol.shop.dto.CommodityMainInfo;
import com.duol.shop.entity.Variety;
import com.duol.shop.service.BrandService;
import com.duol.shop.service.CommodityService;
import com.duol.shop.service.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品和商城展示
 *
 * @author Duolaimon
 *         17-4-28 下午8:25
 */
@RequestMapping("/shop")
@RestController
@SuppressWarnings("unused")
public class ShopController {
    /**
     * 用于处理商品的业务逻辑
     */
    private final CommodityService commodityService;
    /**
     * 用于处理品牌的业务逻辑
     */
    private final BrandService brandService;
    /**
     * 用于处理商品种类的业务逻辑
     */
    private final VarietyService varietyService;

    @Autowired
    public ShopController(CommodityService commodityService, BrandService brandService, VarietyService varietyService) {
        this.commodityService = commodityService;
        this.brandService = brandService;
        this.varietyService = varietyService;
    }

    /**
     * 反馈所有商品信息
     *
     * @return 所有商品所有信息列表
     */
    @RequestMapping(value = "/commoditiesInfo", method = RequestMethod.GET)
    public List<Commodity> showAllProducesInfo() {
        return commodityService.getCommodityList();
    }

    /**
     * 返回所有品牌信息
     *
     * @return 所有品牌的所有信息
     */
    @RequestMapping(value = "/brandsInfo", method = RequestMethod.GET)
    public List<Brand> getAllBrandInfo() {
        return brandService.getBrandList();
    }

    /**
     * 返回所有商品种类信息
     *
     * @return 所有商品种类所有信息
     */
    @RequestMapping(value = "/varietiesInfo", method = RequestMethod.GET)
    public List<Variety> getAllVarietyInfo() {
        return varietyService.getAllVarietyList();
    }

    /**
     * 展示商城页面商品
     *
     * @return 商城页面的商品部分信息
     */
    @RequestMapping(value = "/mainPageInfo", method = RequestMethod.GET)
    public List<CommodityMainInfo> showMainPageProducesInfo() {
        return commodityService.getCommodityInfoList();
    }

    /**
     * 展示指定品牌号的商品
     *
     * @param brandId 品牌id
     * @return 如果id存在,返回商城页面指定品牌id的商品部分信息
     *         否则返回空
     */
    @RequestMapping(value = "/{brandId}/mainPageByBrand", method = RequestMethod.GET)
    public List<CommodityMainInfo> showMainPageProducesInfoByBrandId(@PathVariable int brandId) {
        return commodityService.getCommodityInfoListByBrandId(brandId);
    }

    /**
     * 展示指定种类的商品
     * @param varietyId 种类id
     * @return  如果id存在,返回商城页面指定种类id的商品部分信息
     *          否则返回空
     */
    @RequestMapping(value = "/{varietyId}/mainPageByVariety",method = RequestMethod.GET)
    public List<CommodityMainInfo> showMainPageProducesInfoByVarietyId(@PathVariable int varietyId) {
        return commodityService.getCommodityInfoListByVarietyId(varietyId);
    }

    /**
     * 展示指定商品的商品页
     * @param commodityId   商品id
     * @return  如果id存在,返回商品展示单页的商品信息
     *          否则返回空
     */
    @RequestMapping(value = "/{commodityId}/producePage",method = RequestMethod.GET)
    public List<CommodityMainInfo> showProducePageByCommodityId(@PathVariable int commodityId) {
        return commodityService.getCommodityInfoById(commodityId);
    }

    /**
     * 根据接收的关键字查找相关商品
     * @param searchKey 商品关键字
     * @return  如果关键字存在,返回包含指定关键字的商品信息
     *          如果关键字为空,返回所有商品信息
     *          否则返回空
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public List<CommodityMainInfo> showMainPageBySearch(@RequestParam("searchKey") String searchKey) {
        return commodityService.getCommodityMainInfoListBySearch(searchKey);
    }

}
