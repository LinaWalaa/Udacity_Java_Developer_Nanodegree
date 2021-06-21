package com.udacity.jdnd.course1.model;

import java.math.BigDecimal;

public class TacoOrder {

    private Integer order_id;
    private String taco_name;
    // double will work here, but you should often use BigDecimal for prices
    // if you plan to do any math with them since it has better precision
    // with decimal math (for precise values such as currency or price)
    private BigDecimal taco_price;
    private Integer count;

    public TacoOrder(Integer order_id, String taco_name, BigDecimal taco_price, Integer count) {
        this.order_id = order_id;
        this.taco_name = taco_name;
        this.taco_price = taco_price;
        this.count = count;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getTaco_name() {
        return taco_name;
    }

    public void setTaco_name(String taco_name) {
        this.taco_name = taco_name;
    }

    public BigDecimal getTaco_price() {
        return taco_price;
    }

    public void setTaco_price(BigDecimal taco_price) {
        this.taco_price = taco_price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
