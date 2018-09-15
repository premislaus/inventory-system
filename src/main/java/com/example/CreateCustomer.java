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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * CreateCustomer class.
 */
public class CreateCustomer {

    /**
     * @param controller: It creates new the Controller object.
     */
    private static Controller controller = new Controller();

    /**
     * A display method that creates a window for inserting new Customer.
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
        nameField.setPromptText("John Doe");

        // Create new HBox object.
        HBox nameRow = new HBox(10);

        // Set the alignment of the hbBtn to left.
        nameRow.setAlignment(Pos.CENTER_LEFT);

        // Add btn as a child of hbBtn object.
        nameRow.getChildren().addAll(nameLabel, nameField);

        // Add the hbBtn to the grid.
        grid.add(nameRow, 0, 0);

        // Create a Label object.
        Label addressLabel = new Label("Enter the address:");
        addressLabel.setMinWidth(150);

        // Create a TextField object.
        TextField addressField = new TextField();
        addressField.setPromptText("22 Gleann Tuarigh");

        // Create new HBox object.
        HBox descriptionRow = new HBox(10);

        // Set the alignment of the hbBtn to left.
        descriptionRow.setAlignment(Pos.CENTER_LEFT);

        // Add btn as a child of hbBtn object.
        descriptionRow.getChildren().addAll(addressLabel, addressField);

        // Add the hbBtn to the grid.
        grid.add(descriptionRow, 0, 1);

        Button insertBtn = new Button();
        insertBtn.setText("Create Customer");
        insertBtn.setOnAction(e -> {
            try {
                controller.createCustomer(nameField.getText(), addressField.getText());
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
