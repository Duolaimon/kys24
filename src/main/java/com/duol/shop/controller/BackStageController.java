package com.duol.shop.controller;

import com.duol.shop.dto.BackStageResult;
import com.duol.shop.entity.Brand;
import com.duol.shop.entity.Commodity;
import com.duol.shop.entity.Variety;
import com.duol.shop.enums.ResultEnum;
import com.duol.shop.exception.ResultException;
import com.duol.shop.service.BrandService;
import com.duol.shop.service.CommodityService;
import com.duol.shop.service.VarietyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author Duolaimon
 *         17-5-1 下午7:04
 */
@RestController
@RequestMapping("/back")
@SuppressWarnings("unused")
public class BackStageController {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

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
    public BackStageController(CommodityService commodityService, BrandService brandService, VarietyService varietyService) {
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
     * 增加一条商品
     * @param commodity 商品信息
     * @return  操作结果
     */
    @RequestMapping(value = "/addCommodity",method = RequestMethod.POST)
    public BackStageResult<Commodity> addCommodity(@RequestBody Commodity commodity) {
        try {
            commodityService.addCommodity(commodity);
        } catch (DuplicateKeyException e) {
            logger.error(e.getMessage());
            return new BackStageResult<>(ResultEnum.DUPLICATE_INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new BackStageResult<>(ResultEnum.OTHERS_EXCEPTION, null);
        }
        commodity.setCreateTime(new Date());
        commodity.setUpdateTime(new Date());
        return new BackStageResult<>(ResultEnum.SUCCESS, commodity);
    }

    /**
     * 修改更新一条商品
     * @param commodity 商品信息
     * @return  操作结果
     */
    @RequestMapping(value = "/setCommodity",method = RequestMethod.PUT)
    public BackStageResult<Commodity> setCommodity(@RequestBody Commodity commodity) {
        try {
            commodityService.setCommodity(commodity);
        } catch (ResultException e) {
            logger.error(e.getMessage());
            return new BackStageResult<>(e, commodity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new BackStageResult<>(ResultEnum.OTHERS_EXCEPTION, null);
        }
        return new BackStageResult<>(ResultEnum.SUCCESS, commodity);
    }

    /**
     * 根据商品id删除商品
     * @param commodityId  商品id
     * @return  被删除的商品信息
     */
    @RequestMapping(value = "/removeCommodity/{commodityId}",method = RequestMethod.GET)
    public BackStageResult<Commodity> removeCommodity(@PathVariable int commodityId) {
        Commodity commodity;
        try {
            commodity = commodityService.removeCommodity(commodityId);
        } catch (ResultException e) {
            logger.error(e.getMessage());
            return new BackStageResult<>(e, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new BackStageResult<>(ResultEnum.OTHERS_EXCEPTION, null);
        }
        return new BackStageResult<>(ResultEnum.SUCCESS, commodity);
    }

    /**
     * 上传商品图片至指定路径
     * {@link com.duol.shop.service.StorageProperties}类设置了路径位置
     * @param file  上传的图片
     * @param commodityId   商品id
     * @return  商品图片上传结果
     */
    @PostMapping("/uploadPicture")
    public BackStageResult<String> uploadPicture(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("commodityId") int commodityId) {
        String picturePath;
        try {
            picturePath = commodityService.storePicture(commodityId,file);
        } catch (ResultException e) {
            return new BackStageResult<>(e, null);
        }
        return new BackStageResult<>(ResultEnum.SUCCESS, picturePath);
    }
}
