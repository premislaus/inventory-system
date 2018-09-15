package com.example;

import java.util.ArrayList;

/**
 * Customer class.
 */
public class Customer {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param name: It stores the Customer name.
     * @param address: It stores the Customer address.
     * @param orders: It stores the Customer orders.
     */
    private String name;
    private String address;

    /**
     * An empty constructor of the class Customer.
     */
    public Customer() {

    }

    /**
     * The constructor creates 1 instance (1 object) of the class Customer.
     * @param name: It represent Customer name.
     * @param address: It represents Customer address.
     */
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
}