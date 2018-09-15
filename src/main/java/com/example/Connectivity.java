package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Connectivity class.
 */
public class Connectivity {

    /**
     * @param connectivity: It stores the Connectivity variable.
     * @param name: It stores the Connectivity name variable.
     */
    private static Connectivity connectivity;
    private String name = "";

    /**
     * An empty private constructor of the class Connectivity.
     */
    private Connectivity() { }

    /**
     * A only public object of the class Connectivity.
     * @return connectivity
     */
    public static Connectivity getInstance() {
        if (connectivity == null) {
            connectivity = new Connectivity();
        }
        return connectivity;
    }

    /**
     * A method that load the connection of the class Connectivity.
     * @return conn
     */
    public static Connection getConnection() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/inventory?autoReconnect=true&useSSL=false", "root", "qwerty12345");
        return conn;
    }

    /**
     * A method that inserts a Product into the Database.
     * @return recordCounter
     */
    public int insertProduct(Product p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int recordCounter = 0;

        try {
            conn = this.getConnection();
            ps = conn.prepareStatement("INSERT INTO Products " + "(Name, Description, Price, ProductId) " + "VALUES (?, ?, ?, ?)");
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setInt(3, p.getPrice());
            ps.setInt(4, p.getProductID());

            recordCounter = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        return recordCounter;
    }

    /**
     * A method that inserts a Customer into the Database.
     * @return recordCounter
     */
    public int insertCustomer(Customer c) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int recordCounter = 0;

        try {
            conn = this.getConnection();
            ps = conn.prepareStatement("INSERT INTO Customers " + "(Name, Address) " + "VALUES (?, ?)");
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());

            recordCounter = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        return recordCounter;
    }


//    // Database URL
//    private static final String URL = "jdbc:mysql://localhost/inventory?autoReconnect=true&useSSL=false";
//
//    // Database credentials
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "qwerty12345";
//
//    private Connection connection = null;
//    private PreparedStatement insert = null;
//    private PreparedStatement insertCostumer = null;
//    private String retrieveData = "";
//
//    public String getRetrieveCustomerData() {
//        return retrieveCustomerData;
//    }
//
//    private String retrieveCustomerData = "";
//
//    public String getRetrieveData() {
//        return retrieveData;
//    }
//
//    public Connectivity() {
//
//        // Insert records SQL clause
//        String insertSQL = "INSERT INTO Products " + "(Name, Description, Price, ProductId) " + "VALUES (?, ?, ?, ?)";
//        String insertCustomerSQL = "INSERT INTO Customers " + "(Name, Address) " + "VALUES (?, ?)";
//
//        // Select records SQL clause
//        String selectSQL = "SELECT Name, Description, Price, ProductId FROM Products";
//        String selectCustomerSQL = "SELECT Name, Address FROM Customers";
//
//        try {
//            // Open a connection
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            // PrepareStatement for Select and Insert clauses
//            insert = connection.prepareStatement(insertSQL);
//            insertCostumer = connection.prepareStatement(insertCustomerSQL);
//
//            PreparedStatement retrieve = connection.prepareStatement(selectSQL);
//            PreparedStatement retrieveCustomer = connection.prepareStatement(selectCustomerSQL);
//
//            // Execute a retrieve query
//            ResultSet rs = retrieve.executeQuery();
//
//            // Extract data from result set
//            while(rs.next()){
//                String name  = rs.getString("Name");
//                String description = rs.getString("Description");
//                int price = rs.getInt("Price");
//                int productId = rs.getInt("ProductId");
//
//                // Return back the data
//                retrieveData += name + "\t\t\t" + description + "\t\t\t€" + price + "\t\t\t\t" + productId +"\n";
//            }
//            rs.close();
//
//            // Execute a retrieve query
//            ResultSet rsCustomer = retrieveCustomer.executeQuery();
//
//            // Extract data from result set
//            while(rsCustomer.next()){
//                String name  = rsCustomer.getString("Name");
//                String address = rsCustomer.getString("Address");
//
//                // Return back the data
//                retrieveCustomerData += name + "\t\t" + address + "\n";
//            }
//            rs.close();
//        }
//
//        catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            System.exit( 1 );
//        }
//    }
//
//    public int addProduct(Product p) {
//        int result = 0;
//
//        try {
//            insert.setString(1, p.getName());
//            insert.setString(2, p.getDescription());
//            insert.setInt(3, p.getPrice());
//            insert.setInt(4, p.getProductID());
//
//            result = insert.executeUpdate();
//        }
//        catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            close();
//        }
//
//        return result;
//    }
//
//    public int addCostumer(Customer c) {
//        int result = 0;
//
//        try {
//            insertCostumer.setString(1, c.getName());
//            insertCostumer.setString(2, c.getAddress());
//
//            result = insertCostumer.executeUpdate();
//        }
//        catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            close();
//        }
//
//        return result;
//    }
//
//    // Close the Database Connection.
//    private void close() {
//        try {
//            connection.close();
//        }
//        catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//    }



}