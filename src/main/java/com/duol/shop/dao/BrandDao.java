package com.duol.shop.dao;

import com.duol.shop.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Duolaimon
 *         17-4-29 上午10:32
 */
public interface BrandDao {
    /**
     * 查找所有品牌信息
     *
     * @return 品牌信息列表
     */
    List<Brand> queryBrandList();

    /**
     * 插入一条品牌
     *
     * @param brand 品牌信息
     */
    void insertBrand(Brand brand);

    /**
     * 更新品牌信息
     *
     * @param newBrand 品牌信息
     */
    void updateBrand(Brand newBrand);

    /**
     * 删除品牌信息
     *
     * @param brandId 品牌id
     */
    void deleteBrand(int brandId);

    /**
     * 更新品牌图片
     *
     * @param brandId      品牌id
     * @param brandPicture 品牌图片地址
     */
    void uploadPicture(@Param("brandId") int brandId, @Param("brandPicture") String brandPicture);
}
