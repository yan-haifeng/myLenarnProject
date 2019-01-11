package com.zime.toup.entity;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer goodsId;

    private Integer userId;

    private Date ordertime;

    private Integer buyquantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getBuyquantity() {
        return buyquantity;
    }

    public void setBuyquantity(Integer buyquantity) {
        this.buyquantity = buyquantity;
    }

	public Order(Integer id, Integer goodsId, Integer userId, Date ordertime, Integer buyquantity) {
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.ordertime = ordertime;
		this.buyquantity = buyquantity;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", goodsId=" + goodsId + ", userId=" + userId + ", ordertime=" + ordertime
				+ ", buyquantity=" + buyquantity + "]";
	}
    
    
}