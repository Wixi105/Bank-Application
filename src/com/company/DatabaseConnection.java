package com.company;

import java.sql.*;

public class DatabaseConnection {


    public static void connection() throws ClassNotFoundException, SQLException {
        try {
//           Class.forName("org.mariadb.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/hulubank";
            String dbUser = "odin";
            String dbPass = "123456";
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
//            Statement statement = conn.createStatement();
//            String sql = "INSERT INTO Customers(FIRSTNAME,MIDDLENAME,LASTNAME,EMAIL,ACCOUNT_NUMBER,PHONENO) " + " VALUES('John',' ','Doe','eric@gmail.com','1123456','0203663447');";
//            statement.executeQuery(sql);

        } catch (SQLException e) {
            throw new Error("Error ", e);
        }

    }



}
