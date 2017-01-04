package me.yummykang.bean;

import java.math.BigDecimal;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/4 13:04
 */
public class Order {
    private Integer orderId;

    private String orderNo;

    private String orderName;

    private BigDecimal orderPrice;

    public Order() {
    }

    public Order(Integer orderId, String orderNo, String orderName, BigDecimal orderPrice) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
