package com.example;

/**
 * Product class.
 */
public class Product {

    /**
     * @param name: It stores the Product name.
     * @param description: It stores the Product description.
     * @param price: It stores the Product price.
     * @param productID: It stores the Product ID.
     */
    private String name;
    private String description;
    private int price;
    private int productID;

    /**
     * An empty constructor of the class Product.
     */
    public Product() { }

    /**
     * The constructor creates 1 instance (1 object) of the class Product.
     * @param name: It represent Product name.
     * @param description: It represents Product description.
     * @param price: It represents Product price.
     * @param productID: It represents Product ID.
     */
    public Product(String name, String description, int price, int productID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productID = productID;
    }

    /**
     * Given a concrete Product (this), the function modifies the name.<br>
     * @param: The new name of a Product for the concrete object (this) calling to the method.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Given a concrete Product (this), the function modifies the description.<br>
     * @param: The new description of a Product for the concrete object (this) calling to the method.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Given a concrete Product (this), the function modifies the price.<br>
     * @param: The new price of a Product for the concrete object (this) calling to the method.
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Given a concrete Product (this), the function modifies the ID.<br>
     * @param: The new ID of a Product for the concrete object (this) calling to the method.
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Given a concrete Product (this), the function returns Product name.<br>
     * @return: The type of Product of the concrete object (this) calling to the method.
     */
    public String getName() {
        return name;
    }
    /**
     * Given a concrete Product (this), the function returns Product description.<br>
     * @return: The type of Product of the concrete object (this) calling to the method.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Given a concrete Product (this), the function returns Product price.<br>
     * @return: The type of Product of the concrete object (this) calling to the method.
     */
    public int getPrice() {
        return price;
    }
    /**
     * Given a concrete Product (this), the function returns Product ID.<br>
     * @return: The type of Product of the concrete object (this) calling to the method.
     */
    public int getProductID() {
        return productID;
    }

    /**
     * The print method of the class Product.
     */
//    public void print() {
//        System.out.println();
//        System.out.println("Name                    " + this.name);
//        System.out.println("Description             " + this.description);
//        System.out.println("Price                   €" + this.price);
//        System.out.println("Product ID              " + this.productID);
//    }
}
