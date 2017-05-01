package com.duol.shop.entity;

import java.util.Date;

/**
 * @author Duolaimon
 *         17-4-29 上午10:31
 */
@SuppressWarnings("unused")
public class Brand {
    private int brandID;        //品牌编号
    private int varietyID;      //商品种类编号
    private String brandname;   //品牌名字
    private long createTime;    //创建时间
    private long updateTime;    //更新时间

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getVarietyID() {
        return varietyID;
    }

    public void setVarietyID(int varietyID) {
        this.varietyID = varietyID;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public Date getCreateTime() {
        return new Date(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime.getTime();
    }

    public Date getUpdateTime() {
        return new Date(updateTime);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime.getTime();
    }
}
