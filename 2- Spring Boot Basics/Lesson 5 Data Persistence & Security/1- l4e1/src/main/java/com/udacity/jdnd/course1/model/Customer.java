package com.udacity.jdnd.course1.model;

import java.util.List;

public class Customer {

    private Integer id;
    private String username;

    //It would be better if the password field for the Customer class is
    // char[ ] array instead of a String.
    // As a developer, you would want to encrypt each character
    // so that you wouldn't store the actual password anywhere in the system.
    // A String is immutable by nature, and hence you cannot change/convert
    // the characters of a String.
    private char[] password;
    private List<Order> listOfOrders;

    public Customer(Integer id, String username, char[] password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Customer(Integer id, String username, char[] password, List<Order> listOfOrders) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.listOfOrders = listOfOrders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public List<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(List<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }
}
