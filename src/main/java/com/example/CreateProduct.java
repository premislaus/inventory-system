package com.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * CreateProduct class.
 */
public class CreateProduct {

    /**
     * @param controller: It creates new the Controller object.
     */
    private static Controller controller = new Controller();

    /**
     * A display method that creates a window for inserting new Product.
     */
    public static void display(String title) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Group root = new Group();
        GridPane grid = new GridPane();

        // Set the alignment of the grid to center.
        grid.setAlignment(Pos.CENTER);

        // Set the horizontal gap.
        grid.setHgap(10);

        // Set the vertical gap.
        grid.setVgap(10);

        // Set the Stage padding.
        grid.setPadding(new Insets(30, 30, 30, 30));

        // Create a Label object.
        Label nameLabel = new Label("Enter the name:");
        nameLabel.setMinWidth(150);

        // Create a TextField object.
        TextField nameField = new TextField();
        nameField.setPromptText("iPhone");

        // Create new HBox object.
        HBox nameRow = new HBox(10);

        // Set the alignment of the hbBtn to left.
        nameRow.setAlignment(Pos.CENTER_LEFT);

        // Add btn as a child of hbBtn object.
        nameRow.getChildren().addAll(nameLabel, nameField);

        // Add the hbBtn to the grid.
        grid.add(nameRow, 0, 0);



        // Create a Label object.
        Label descriptionLabel = new Label("Enter the description:");
        descriptionLabel.setMinWidth(150);

        // Create a TextField object.
        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Smartphone");

        // Create new HBox object.
        HBox descriptionRow = new HBox(10);

        // Set the alignment of the hbBtn to left.
        descriptionRow.setAlignment(Pos.CENTER_LEFT);

        // Add btn as a child of hbBtn object.
        descriptionRow.getChildren().addAll(descriptionLabel, descriptionField);

        // Add the hbBtn to the grid.
        grid.add(descriptionRow, 0, 1);


        // Create a Label object.
        Label priceLabel = new Label("Enter the price:");
        priceLabel.setMinWidth(150);

        // Create a TextField object.
        TextField priceField = new TextField();
        priceField.setPromptText("199");

        // Create new HBox object.
        HBox priceRow = new HBox(10);

        // Set the alignment of the hbBtn to left.
        priceRow.setAlignment(Pos.CENTER_LEFT);

        // Add btn as a child of hbBtn object.
        priceRow.getChildren().addAll(priceLabel, priceField);

        // Add the hbBtn to the grid.
        grid.add(priceRow, 0, 2);

        // Create a Label object.
        Label productIdLabel = new Label("Enter the product ID:");
        productIdLabel.setMinWidth(150);

        // Create a TextField object.
        TextField productIdField = new TextField();
        productIdField.setPromptText("1...");

        // Create new HBox object.
        HBox productIdRow = new HBox(10);

        // Set the alignment of the hbBtn to left.
        productIdRow.setAlignment(Pos.CENTER_LEFT);

        // Add btn as a child of hbBtn object.
        productIdRow.getChildren().addAll(productIdLabel, productIdField);

        // Add the hbBtn to the grid.
        grid.add(productIdRow, 0, 3);

        Button insertBtn = new Button();
        insertBtn.setText("Create Product");
        insertBtn.setOnAction(e -> {
            try {
                controller.createProduct(nameField.getText(), descriptionField.getText(),  Integer.parseInt(priceField.getText()), Integer.parseInt(productIdField.getText()));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        grid.add(insertBtn, 0, 5);

        root.getChildren().add(grid);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }
}
