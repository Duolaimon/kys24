package com.duol.shop.service;

import com.duol.shop.entity.Brand;

import java.util.List;

/**
 * @author Duolaimon
 *         17-4-29 上午10:44
 */
public interface BrandService {
    List<Brand> getBrandList();

    void addBrand(Brand brand);

    void setBrand(Brand brand) throws Exception;

    Brand removeBrand(int brandId) throws Exception;
}
