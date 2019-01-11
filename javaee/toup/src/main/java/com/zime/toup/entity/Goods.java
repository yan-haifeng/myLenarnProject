package com.zime.toup.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private String goodsCity;

    private String goodsSpecifications;

    private String goodsManufacturer;

    private Date goodsDate;

    private String goodsImgpath;

    private String goodsDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getGoodsCity() {
        return goodsCity;
    }

    public void setGoodsCity(String goodsCity) {
        this.goodsCity = goodsCity == null ? null : goodsCity.trim();
    }

    public String getGoodsSpecifications() {
        return goodsSpecifications;
    }

    public void setGoodsSpecifications(String goodsSpecifications) {
        this.goodsSpecifications = goodsSpecifications == null ? null : goodsSpecifications.trim();
    }

    public String getGoodsManufacturer() {
        return goodsManufacturer;
    }

    public void setGoodsManufacturer(String goodsManufacturer) {
        this.goodsManufacturer = goodsManufacturer == null ? null : goodsManufacturer.trim();
    }

    public Date getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(Date goodsDate) {
        this.goodsDate = goodsDate;
    }

    public String getGoodsImgpath() {
        return goodsImgpath;
    }

    public void setGoodsImgpath(String goodsImgpath) {
        this.goodsImgpath = goodsImgpath == null ? null : goodsImgpath.trim();
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe == null ? null : goodsDescribe.trim();
    }

	public Goods(Integer id, String goodsName, BigDecimal goodsPrice, Integer goodsStock, String goodsCity,
			String goodsSpecifications, String goodsManufacturer, Date goodsDate, String goodsImgpath,
			String goodsDescribe) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsStock = goodsStock;
		this.goodsCity = goodsCity;
		this.goodsSpecifications = goodsSpecifications;
		this.goodsManufacturer = goodsManufacturer;
		this.goodsDate = goodsDate;
		this.goodsImgpath = goodsImgpath;
		this.goodsDescribe = goodsDescribe;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsStock="
				+ goodsStock + ", goodsCity=" + goodsCity + ", goodsSpecifications=" + goodsSpecifications
				+ ", goodsManufacturer=" + goodsManufacturer + ", goodsDate=" + goodsDate + ", goodsImgpath="
				+ goodsImgpath + ", goodsDescribe=" + goodsDescribe + "]";
	}
    
    
}