package com.cmj.example.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class EbuyPaymentBase implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FId
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FTradeNo
     *
     * @mbg.generated
     */
    private String tradeNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FAmount
     *
     * @mbg.generated
     */
    private BigDecimal amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FCreateTime
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FUpdateTime
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FDeleteTime
     *
     * @mbg.generated
     */
    private Date deleteTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FCreateUser
     *
     * @mbg.generated
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FUpdateUser
     *
     * @mbg.generated
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FDeleteUser
     *
     * @mbg.generated
     */
    private String deleteUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ebuy_payment.FIsDelete
     *
     * @mbg.generated
     */
    private Integer isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FId
     *
     * @return the value of t_ebuy_payment.FId
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FId
     *
     * @param id the value for t_ebuy_payment.FId
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FTradeNo
     *
     * @return the value of t_ebuy_payment.FTradeNo
     *
     * @mbg.generated
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FTradeNo
     *
     * @param tradeNo the value for t_ebuy_payment.FTradeNo
     *
     * @mbg.generated
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FAmount
     *
     * @return the value of t_ebuy_payment.FAmount
     *
     * @mbg.generated
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FAmount
     *
     * @param amount the value for t_ebuy_payment.FAmount
     *
     * @mbg.generated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FCreateTime
     *
     * @return the value of t_ebuy_payment.FCreateTime
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FCreateTime
     *
     * @param createTime the value for t_ebuy_payment.FCreateTime
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FUpdateTime
     *
     * @return the value of t_ebuy_payment.FUpdateTime
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FUpdateTime
     *
     * @param updateTime the value for t_ebuy_payment.FUpdateTime
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FDeleteTime
     *
     * @return the value of t_ebuy_payment.FDeleteTime
     *
     * @mbg.generated
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FDeleteTime
     *
     * @param deleteTime the value for t_ebuy_payment.FDeleteTime
     *
     * @mbg.generated
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FCreateUser
     *
     * @return the value of t_ebuy_payment.FCreateUser
     *
     * @mbg.generated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FCreateUser
     *
     * @param createUser the value for t_ebuy_payment.FCreateUser
     *
     * @mbg.generated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FUpdateUser
     *
     * @return the value of t_ebuy_payment.FUpdateUser
     *
     * @mbg.generated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FUpdateUser
     *
     * @param updateUser the value for t_ebuy_payment.FUpdateUser
     *
     * @mbg.generated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FDeleteUser
     *
     * @return the value of t_ebuy_payment.FDeleteUser
     *
     * @mbg.generated
     */
    public String getDeleteUser() {
        return deleteUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FDeleteUser
     *
     * @param deleteUser the value for t_ebuy_payment.FDeleteUser
     *
     * @mbg.generated
     */
    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser == null ? null : deleteUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ebuy_payment.FIsDelete
     *
     * @return the value of t_ebuy_payment.FIsDelete
     *
     * @mbg.generated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ebuy_payment.FIsDelete
     *
     * @param isDelete the value for t_ebuy_payment.FIsDelete
     *
     * @mbg.generated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    public static EbuyPaymentBase.Builder builder() {
        return new EbuyPaymentBase.Builder();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", deleteUser=").append(deleteUser);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        private EbuyPaymentBase obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public Builder() {
            this.obj = new EbuyPaymentBase();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FId
         *
         * @param id the value for t_ebuy_payment.FId
         *
         * @mbg.generated
         */
        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FTradeNo
         *
         * @param tradeNo the value for t_ebuy_payment.FTradeNo
         *
         * @mbg.generated
         */
        public Builder tradeNo(String tradeNo) {
            obj.setTradeNo(tradeNo);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FAmount
         *
         * @param amount the value for t_ebuy_payment.FAmount
         *
         * @mbg.generated
         */
        public Builder amount(BigDecimal amount) {
            obj.setAmount(amount);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FCreateTime
         *
         * @param createTime the value for t_ebuy_payment.FCreateTime
         *
         * @mbg.generated
         */
        public Builder createTime(Date createTime) {
            obj.setCreateTime(createTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FUpdateTime
         *
         * @param updateTime the value for t_ebuy_payment.FUpdateTime
         *
         * @mbg.generated
         */
        public Builder updateTime(Date updateTime) {
            obj.setUpdateTime(updateTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FDeleteTime
         *
         * @param deleteTime the value for t_ebuy_payment.FDeleteTime
         *
         * @mbg.generated
         */
        public Builder deleteTime(Date deleteTime) {
            obj.setDeleteTime(deleteTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FCreateUser
         *
         * @param createUser the value for t_ebuy_payment.FCreateUser
         *
         * @mbg.generated
         */
        public Builder createUser(String createUser) {
            obj.setCreateUser(createUser);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FUpdateUser
         *
         * @param updateUser the value for t_ebuy_payment.FUpdateUser
         *
         * @mbg.generated
         */
        public Builder updateUser(String updateUser) {
            obj.setUpdateUser(updateUser);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FDeleteUser
         *
         * @param deleteUser the value for t_ebuy_payment.FDeleteUser
         *
         * @mbg.generated
         */
        public Builder deleteUser(String deleteUser) {
            obj.setDeleteUser(deleteUser);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column t_ebuy_payment.FIsDelete
         *
         * @param isDelete the value for t_ebuy_payment.FIsDelete
         *
         * @mbg.generated
         */
        public Builder isDelete(Integer isDelete) {
            obj.setIsDelete(isDelete);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public EbuyPaymentBase build() {
            return this.obj;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    public enum Column {
        id("FId", "id", "INTEGER", false),
        tradeNo("FTradeNo", "tradeNo", "VARCHAR", false),
        amount("FAmount", "amount", "DECIMAL", false),
        createTime("FCreateTime", "createTime", "TIMESTAMP", false),
        updateTime("FUpdateTime", "updateTime", "TIMESTAMP", false),
        deleteTime("FDeleteTime", "deleteTime", "TIMESTAMP", false),
        createUser("FCreateUser", "createUser", "VARCHAR", false),
        updateUser("FUpdateUser", "updateUser", "VARCHAR", false),
        deleteUser("FDeleteUser", "deleteUser", "VARCHAR", false),
        isDelete("FIsDelete", "isDelete", "TINYINT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public static Column[] all() {
            return Column.values();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_ebuy_payment
         *
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}