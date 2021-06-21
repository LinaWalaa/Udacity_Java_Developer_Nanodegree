package com.udacity.jdnd.course1.model;

import java.util.List;

public class Order {

    private Integer id;
    private Integer customer_id;
    private List<TacoOrder> listOfTacoOrders;
    private Delivery deliveryDetails;

    public Order(Integer id, Integer customer_id, List<TacoOrder> listOfTacoOrders) {
        this.id = id;
        this.customer_id = customer_id;
        this.listOfTacoOrders = listOfTacoOrders;
    }

    public Order(Integer id, Integer customer_id, List<TacoOrder> listOfTacoOrders, Delivery deliveryDetails) {
        this.id = id;
        this.customer_id = customer_id;
        this.listOfTacoOrders = listOfTacoOrders;
        this.deliveryDetails = deliveryDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public List<TacoOrder> getListOfTacoOrders() {
        return listOfTacoOrders;
    }

    public void setListOfTacoOrders(List<TacoOrder> listOfTacoOrders) {
        this.listOfTacoOrders = listOfTacoOrders;
    }

    public Delivery getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(Delivery deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }
}
