package com.liuzhe.shop.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdminuserExample {
    private static final String USER_NAME = "username";

    private static final String PASSWORD = "password";

    private static final String STATE = "state";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminuserExample() {
        oredCriteria = new ArrayList<>();
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
        if (oredCriteria.isEmpty()) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        return new Criteria();
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
            this.criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return !criteria.isEmpty();
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, USER_NAME);
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, PASSWORD);
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, PASSWORD);
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, STATE);
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, STATE);
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, STATE);
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, STATE);
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, STATE);
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, STATE);
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, STATE);
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, STATE);
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, STATE);
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, STATE);
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