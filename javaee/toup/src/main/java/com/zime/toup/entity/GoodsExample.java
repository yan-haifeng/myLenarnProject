package com.zime.toup.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNull() {
            addCriterion("goods_stock is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNotNull() {
            addCriterion("goods_stock is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockEqualTo(Integer value) {
            addCriterion("goods_stock =", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotEqualTo(Integer value) {
            addCriterion("goods_stock <>", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThan(Integer value) {
            addCriterion("goods_stock >", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_stock >=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThan(Integer value) {
            addCriterion("goods_stock <", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThanOrEqualTo(Integer value) {
            addCriterion("goods_stock <=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIn(List<Integer> values) {
            addCriterion("goods_stock in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotIn(List<Integer> values) {
            addCriterion("goods_stock not in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockBetween(Integer value1, Integer value2) {
            addCriterion("goods_stock between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_stock not between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCityIsNull() {
            addCriterion("goods_city is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCityIsNotNull() {
            addCriterion("goods_city is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCityEqualTo(String value) {
            addCriterion("goods_city =", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityNotEqualTo(String value) {
            addCriterion("goods_city <>", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityGreaterThan(String value) {
            addCriterion("goods_city >", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityGreaterThanOrEqualTo(String value) {
            addCriterion("goods_city >=", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityLessThan(String value) {
            addCriterion("goods_city <", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityLessThanOrEqualTo(String value) {
            addCriterion("goods_city <=", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityLike(String value) {
            addCriterion("goods_city like", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityNotLike(String value) {
            addCriterion("goods_city not like", value, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityIn(List<String> values) {
            addCriterion("goods_city in", values, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityNotIn(List<String> values) {
            addCriterion("goods_city not in", values, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityBetween(String value1, String value2) {
            addCriterion("goods_city between", value1, value2, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsCityNotBetween(String value1, String value2) {
            addCriterion("goods_city not between", value1, value2, "goodsCity");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsIsNull() {
            addCriterion("goods_specifications is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsIsNotNull() {
            addCriterion("goods_specifications is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsEqualTo(String value) {
            addCriterion("goods_specifications =", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotEqualTo(String value) {
            addCriterion("goods_specifications <>", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsGreaterThan(String value) {
            addCriterion("goods_specifications >", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_specifications >=", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsLessThan(String value) {
            addCriterion("goods_specifications <", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("goods_specifications <=", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsLike(String value) {
            addCriterion("goods_specifications like", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotLike(String value) {
            addCriterion("goods_specifications not like", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsIn(List<String> values) {
            addCriterion("goods_specifications in", values, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotIn(List<String> values) {
            addCriterion("goods_specifications not in", values, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsBetween(String value1, String value2) {
            addCriterion("goods_specifications between", value1, value2, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotBetween(String value1, String value2) {
            addCriterion("goods_specifications not between", value1, value2, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerIsNull() {
            addCriterion("goods_manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerIsNotNull() {
            addCriterion("goods_manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerEqualTo(String value) {
            addCriterion("goods_manufacturer =", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerNotEqualTo(String value) {
            addCriterion("goods_manufacturer <>", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerGreaterThan(String value) {
            addCriterion("goods_manufacturer >", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("goods_manufacturer >=", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerLessThan(String value) {
            addCriterion("goods_manufacturer <", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerLessThanOrEqualTo(String value) {
            addCriterion("goods_manufacturer <=", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerLike(String value) {
            addCriterion("goods_manufacturer like", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerNotLike(String value) {
            addCriterion("goods_manufacturer not like", value, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerIn(List<String> values) {
            addCriterion("goods_manufacturer in", values, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerNotIn(List<String> values) {
            addCriterion("goods_manufacturer not in", values, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerBetween(String value1, String value2) {
            addCriterion("goods_manufacturer between", value1, value2, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsManufacturerNotBetween(String value1, String value2) {
            addCriterion("goods_manufacturer not between", value1, value2, "goodsManufacturer");
            return (Criteria) this;
        }

        public Criteria andGoodsDateIsNull() {
            addCriterion("goods_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDateIsNotNull() {
            addCriterion("goods_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDateEqualTo(Date value) {
            addCriterion("goods_date =", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateNotEqualTo(Date value) {
            addCriterion("goods_date <>", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateGreaterThan(Date value) {
            addCriterion("goods_date >", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_date >=", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateLessThan(Date value) {
            addCriterion("goods_date <", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateLessThanOrEqualTo(Date value) {
            addCriterion("goods_date <=", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateIn(List<Date> values) {
            addCriterion("goods_date in", values, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateNotIn(List<Date> values) {
            addCriterion("goods_date not in", values, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateBetween(Date value1, Date value2) {
            addCriterion("goods_date between", value1, value2, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateNotBetween(Date value1, Date value2) {
            addCriterion("goods_date not between", value1, value2, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathIsNull() {
            addCriterion("goods_imgpath is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathIsNotNull() {
            addCriterion("goods_imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathEqualTo(String value) {
            addCriterion("goods_imgpath =", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathNotEqualTo(String value) {
            addCriterion("goods_imgpath <>", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathGreaterThan(String value) {
            addCriterion("goods_imgpath >", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("goods_imgpath >=", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathLessThan(String value) {
            addCriterion("goods_imgpath <", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathLessThanOrEqualTo(String value) {
            addCriterion("goods_imgpath <=", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathLike(String value) {
            addCriterion("goods_imgpath like", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathNotLike(String value) {
            addCriterion("goods_imgpath not like", value, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathIn(List<String> values) {
            addCriterion("goods_imgpath in", values, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathNotIn(List<String> values) {
            addCriterion("goods_imgpath not in", values, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathBetween(String value1, String value2) {
            addCriterion("goods_imgpath between", value1, value2, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsImgpathNotBetween(String value1, String value2) {
            addCriterion("goods_imgpath not between", value1, value2, "goodsImgpath");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeIsNull() {
            addCriterion("goods_describe is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeIsNotNull() {
            addCriterion("goods_describe is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeEqualTo(String value) {
            addCriterion("goods_describe =", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotEqualTo(String value) {
            addCriterion("goods_describe <>", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeGreaterThan(String value) {
            addCriterion("goods_describe >", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_describe >=", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeLessThan(String value) {
            addCriterion("goods_describe <", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeLessThanOrEqualTo(String value) {
            addCriterion("goods_describe <=", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeLike(String value) {
            addCriterion("goods_describe like", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotLike(String value) {
            addCriterion("goods_describe not like", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeIn(List<String> values) {
            addCriterion("goods_describe in", values, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotIn(List<String> values) {
            addCriterion("goods_describe not in", values, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeBetween(String value1, String value2) {
            addCriterion("goods_describe between", value1, value2, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotBetween(String value1, String value2) {
            addCriterion("goods_describe not between", value1, value2, "goodsDescribe");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}