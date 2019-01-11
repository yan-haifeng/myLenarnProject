package com.zime.toup.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orderview {
    private Integer id;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer buyquantity;

    private BigDecimal totalprice;

    private String name;

    private String phone;

    private Date ordertime;

    private Integer goodsId;

    private Integer userId;

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

    public Integer getBuyquantity() {
        return buyquantity;
    }

    public void setBuyquantity(Integer buyquantity) {
        this.buyquantity = buyquantity;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public Orderview(Integer id, String goodsName, BigDecimal goodsPrice, Integer buyquantity, BigDecimal totalprice,
			String name, String phone, Date ordertime, Integer goodsId, Integer userId) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.buyquantity = buyquantity;
		this.totalprice = totalprice;
		this.name = name;
		this.phone = phone;
		this.ordertime = ordertime;
		this.goodsId = goodsId;
		this.userId = userId;
	}

	public Orderview() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Orderview [id=" + id + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", buyquantity="
				+ buyquantity + ", totalprice=" + totalprice + ", name=" + name + ", phone=" + phone + ", ordertime="
				+ ordertime + ", goodsId=" + goodsId + ", userId=" + userId + "]";
	}
}