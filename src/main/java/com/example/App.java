package com.example;

import java.awt.Panel;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    private Person currentEntry;
    private Controller controller;
    private Connectivity connectivity;
    private List<Person> results;
    Button browseButton;

    public Label getTest() {
        return test;
    }

    public void setTest(Label test) {
        this.test = test;
    }

    public TextArea getTa() {
        return ta;
    }

    public void setTa(TextArea ta) {
        this.ta = ta;
    }

    public static TextArea ta;
    private Label emailLabel, test;
    private TextField emailTextField;
    private Label firstNameLabel;
    private TextField firstNameTextField;
    private Label idLabel;
    private TextField idTextField;
    private TextField indexTextField;
    private Label lastNameLabel;
    private TextField lastNameTextField;
    private Panel displayPanel;
    private Label phoneLabel;
    private TextField phoneTextField;
    private Button insertButton;
    private Button displayButton;
    private Button  quitButton;

    private Text heading;
    private Label label, labelSuccess, labelError;
    private Button add, list;
    private TextField field;
    private TextArea textarea;
    private Separator separator;

    private TableView table;



    private Label newProductLabel;
    private Label allProductsLabel;

    private Label nameLabel;
    private Label descriptionLabel;
    private Label priceLabel;
    private Label productIdLabel;
    private TextField nameField;
    private TextField descriptionField;
    private TextField priceField;
    private TextField productIdField;
    private Button insertCutomer;
    private Button insertProduct;

    @Override
    public void start(Stage primaryStage) {
        try {
            controller = new Controller();
//            connectivity = new Connectivity();

            ta = new TextArea();
//            ta.setText(connectivity.getRetrieveData());

            test = new Label();

            idLabel = new Label();
            idTextField = new TextField();

            firstNameLabel = new Label();
            firstNameTextField = new TextField();

            lastNameLabel = new Label();
            lastNameTextField = new TextField();

            emailLabel = new Label();
            emailTextField = new TextField();

            phoneLabel = new Label();
            phoneTextField = new TextField();

            browseButton = new Button();
            insertButton = new Button();
            displayButton = new Button();

            quitButton = new Button();

            table = new TableView();

            idLabel.setText("");
            idTextField.setEditable(false);

            firstNameLabel.setText("First Name:");
            lastNameLabel.setText("Last Name:");
            emailLabel.setText("Email:");
            phoneLabel.setText("Phone Number:");

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(20, 20, 20, 20));
            layout.getChildren().addAll(idLabel, firstNameLabel, lastNameLabel, emailLabel, phoneLabel);

            VBox layout2 = new VBox(10);
            layout2.getChildren().addAll(firstNameTextField,lastNameTextField,emailTextField,phoneTextField);

            HBox r1 = new HBox(10);
            r1.getChildren().addAll(layout,layout2,insertButton, quitButton, ta);

            insertButton.setText("Insert New Entry");
//            insertButton.setOnAction(e-> controller.insert(firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), phoneTextField.getText()));


            quitButton.setText("Quit program");
            quitButton.setOnAction(e -> System.exit(0));

            Group root = new Group();
            GridPane grid = new GridPane();

            // Set the alignment of the grid to center.
            grid.setAlignment(Pos.CENTER);

            // Set the horizontal gap.
            grid.setHgap(10);

            // Set the vertical gap.
            grid.setVgap(10);

            // Set the Stage padding.
            grid.setPadding(new Insets(30, 90, 30, 90));

            // Create Text object.
            heading = new Text("Welcome!");
            // Set the Font for the title.
            heading.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            // Add the title to the grid.
            grid.add(heading, 0, 1);

            label = new Label("Customers");
            label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
            grid.add(label, 0, 7);

            insertCutomer = new Button("New Customer");
            insertCutomer.setOnAction(e -> CreateCustomer.display("Create Customer"));

            HBox menu = new HBox();

            // Set the alignment of the hbBtn to right.
            menu.setAlignment(Pos.CENTER_RIGHT);

            // Add btn as a child of hbBtn object.
            menu.getChildren().addAll(insertCutomer);

            // Add the hbBtn to the grid.
            grid.add(menu, 0, 7);

            separator = new Separator();
            grid.add(separator, 0, 8);

            label = new Label("Name                      " + "Address                      ");
            label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
            label.setTextFill(Color.web("#999999"));
            grid.add(label, 0, 9);

            textarea = new TextArea("The report is empty.");
            textarea.setPrefHeight(100);
            textarea.setId("textarea");
            textarea.setText(controller.retrieveCustomer());
            grid.add(textarea, 0, 10);


            label = new Label("Products");
            label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
            grid.add(label, 0, 19);

            insertProduct = new Button("New Product");
            insertProduct.setOnAction(e -> CreateProduct.display("Create Product"));

            menu = new HBox();

            // Set the alignment of the hbBtn to right.
            menu.setAlignment(Pos.CENTER_RIGHT);

            // Add btn as a child of hbBtn object.
            menu.getChildren().addAll(insertProduct);

            // Add the hbBtn to the grid.
            grid.add(menu, 0, 19);

            separator = new Separator();
            grid.add(separator, 0, 20);

            label = new Label("Name                      " + "Description                      " + "Price                      " + "ID                   ");
            label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
            label.setTextFill(Color.web("#999999"));
            grid.add(label, 0, 21);


            textarea = new TextArea("The report is empty.");
            textarea.setPrefHeight(200);
            textarea.setId("textarea");
            textarea.setText(controller.retrieveProduct());
            grid.add(textarea, 0, 23);

            root.getChildren().add(grid);

            // Creating a scene object
            Scene scene = new Scene(root, 730, 800);

            // Setting title to the Stage
            primaryStage.setTitle("Inventory Management System");

            // Adding scene to the stage
            primaryStage.setScene(scene);

            // Displaying the contents of the stage
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}