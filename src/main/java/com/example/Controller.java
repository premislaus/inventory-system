package com.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Controller class.
 */
public class Controller {

    /**
     * @param jdbc: It creates new Connectivity getInstance object.
     */
    private Connectivity jdbc = Connectivity.getInstance();

    /**
     * A method that inserts a Product into the Database.
     */
    public void createProduct(String name, String description, int price, int id) throws SQLException {

        // Creating a product object
        Product product = new Product(name, description, price, id);

        int result = jdbc.insertProduct(product);

        if(result == 1) {
            modal("Success!", "Product Created!");
        } else {
            modal("Error!", "Product not Created!");
        }
    }

    /**
     * A method that retrieves a Product from the Database.
     * @return data
     */
    public String retrieveProduct() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String data = "";

        try {
            conn = jdbc.getConnection();
            ps = conn.prepareStatement("select * from Products");
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int price = rs.getInt("Price");
                int id = rs.getInt("ProductId");
                data += name + description + price + id + "\n";

                System.out.println(name + description + price + id);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return data;
    }

    /**
     * A method that inserts a Product into the Database.
     */
    public void createCustomer(String name, String address) throws SQLException {

        // Creating a product object
        Customer customer = new Customer(name, address);

        int result = jdbc.insertCustomer(customer);

        if (result == 1) {
            modal("Success!", "Customer Created!");
        } else {
            modal("Error!", "Customer not Created!");
        }
    }

    /**
     * A method that retrieves a Product from the Database.
     * @return data
     */
    public String retrieveCustomer() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String data = "";

        try {
            conn = jdbc.getConnection();
            ps = conn.prepareStatement("select * from Customers");
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                data += name + address + "\n";

                System.out.println(name + address);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return data;
    }

    /**
     * A method that creates a modal window.
     */
    public void modal(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);

        Button closeButton = new Button("Dismiss");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(50, 50, 50, 50));
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
