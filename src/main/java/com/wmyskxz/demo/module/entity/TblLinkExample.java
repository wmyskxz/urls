package com.wmyskxz.demo.module.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblLinkExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLongUrlIsNull() {
            addCriterion("long_url is null");
            return (Criteria) this;
        }

        public Criteria andLongUrlIsNotNull() {
            addCriterion("long_url is not null");
            return (Criteria) this;
        }

        public Criteria andLongUrlEqualTo(String value) {
            addCriterion("long_url =", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotEqualTo(String value) {
            addCriterion("long_url <>", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlGreaterThan(String value) {
            addCriterion("long_url >", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlGreaterThanOrEqualTo(String value) {
            addCriterion("long_url >=", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLessThan(String value) {
            addCriterion("long_url <", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLessThanOrEqualTo(String value) {
            addCriterion("long_url <=", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLike(String value) {
            addCriterion("long_url like", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotLike(String value) {
            addCriterion("long_url not like", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlIn(List<String> values) {
            addCriterion("long_url in", values, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotIn(List<String> values) {
            addCriterion("long_url not in", values, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlBetween(String value1, String value2) {
            addCriterion("long_url between", value1, value2, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotBetween(String value1, String value2) {
            addCriterion("long_url not between", value1, value2, "longUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlIsNull() {
            addCriterion("short_url is null");
            return (Criteria) this;
        }

        public Criteria andShortUrlIsNotNull() {
            addCriterion("short_url is not null");
            return (Criteria) this;
        }

        public Criteria andShortUrlEqualTo(String value) {
            addCriterion("short_url =", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotEqualTo(String value) {
            addCriterion("short_url <>", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThan(String value) {
            addCriterion("short_url >", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThanOrEqualTo(String value) {
            addCriterion("short_url >=", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThan(String value) {
            addCriterion("short_url <", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThanOrEqualTo(String value) {
            addCriterion("short_url <=", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLike(String value) {
            addCriterion("short_url like", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotLike(String value) {
            addCriterion("short_url not like", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlIn(List<String> values) {
            addCriterion("short_url in", values, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotIn(List<String> values) {
            addCriterion("short_url not in", values, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlBetween(String value1, String value2) {
            addCriterion("short_url between", value1, value2, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotBetween(String value1, String value2) {
            addCriterion("short_url not between", value1, value2, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andVisitSizeIsNull() {
            addCriterion("visit_size is null");
            return (Criteria) this;
        }

        public Criteria andVisitSizeIsNotNull() {
            addCriterion("visit_size is not null");
            return (Criteria) this;
        }

        public Criteria andVisitSizeEqualTo(Integer value) {
            addCriterion("visit_size =", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeNotEqualTo(Integer value) {
            addCriterion("visit_size <>", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeGreaterThan(Integer value) {
            addCriterion("visit_size >", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("visit_size >=", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeLessThan(Integer value) {
            addCriterion("visit_size <", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeLessThanOrEqualTo(Integer value) {
            addCriterion("visit_size <=", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeIn(List<Integer> values) {
            addCriterion("visit_size in", values, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeNotIn(List<Integer> values) {
            addCriterion("visit_size not in", values, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeBetween(Integer value1, Integer value2) {
            addCriterion("visit_size between", value1, value2, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("visit_size not between", value1, value2, "visitSize");
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