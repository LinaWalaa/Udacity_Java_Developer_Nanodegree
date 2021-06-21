package com.udacity.jdnd.course1.model;

import java.sql.Timestamp;

public class Delivery {

    private Integer id;
    private Integer order_id;
    // there are a few types you can use for this.
    // java.sql.Timestamp contains both date and time which tends to
    // play nicely with JDBC
    private Timestamp date;

    public Delivery(Integer id, Integer order_id, Timestamp date) {
        this.id = id;
        this.order_id = order_id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
