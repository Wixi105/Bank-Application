package com.company;

import java.sql.*;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Account> accounts = new ArrayList<>();
    public static void main(String[] args) {

        Account account1 = createAccount();
        Account account2 = createAccount();
        Account account3 = createAccount();

    }

    public static Account createAccount(){
            //welcome message.
            System.out.println("Welcome to First Hulu Bank");
    
            //Taking the name of account
            System.out.println("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.println("Enter your middle name: ");
            String middleName = scanner.nextLine();

            System.out.println("Enter your last name: ");
            String lastName = scanner.nextLine();
    
            System.out.println("Enter your email address: ");
            String email = scanner.nextLine();
    
            System.out.println("Enter your phone number: ");
            String phoneNo = scanner.nextLine();
    
            //splitting and working with text.

            String accountBaseNumber = "HULU-5000";
            String[] splitBase = accountBaseNumber.split("-");
            int nextAccountNumber = Integer.parseInt(splitBase[1]) + Account.incrementalVal;
            String accountNumber = "HULU-"+ nextAccountNumber +"";
            int balance = 0;

            System.out.println("Hello " + firstName +" "+ lastName + ", your account number is: " + accountNumber + " with a balance of " + balance);


        try {
//           Class.forName("org.mariadb.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/hulubank";
            String dbUser = "odin";
            String dbPass = "123456";
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "INSERT INTO Customers(FIRSTNAME,MIDDLENAME,LASTNAME,EMAIL,ACCOUNT_NUMBER,PHONENO) VALUES(?,?,?,?,?,?);";
            PreparedStatement pstatement = conn.prepareStatement(sql);

            pstatement.setString(1,firstName);
            pstatement.setString(2,middleName);
            pstatement.setString(3,lastName);
            pstatement.setString(4,email);
            pstatement.setString(5,accountNumber);
            pstatement.setString(6,phoneNo);
            pstatement.executeUpdate();

            boolean check = true;
            while(check){
                System.out.println("Personal Information has been stored. Press 1 to initiate deposit or 0 to view Menu");
                int userOption = scanner.nextInt();
                switch (userOption){
                    case 0 ->{
                        System.out.println("----WELCOME TO HULU BANK----");
                        System.out.println(" Press 0 - To Print Menu \n Press 1 - To initiate deposit \n Press 2 - To view account details" +
                                "\n Press 3 - To remove your account");
                    }
                    case 1 -> {
                        int depositAmount = depositAmount();
                        String sql2 = "UPDATE Customers SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql2);
                        preparedStatement.setInt(1,depositAmount);
                        preparedStatement.setString(2,accountNumber);
                        preparedStatement.executeUpdate();
                        check = false;
                    }
                    case 2 ->{
                        PreparedStatement statement = conn.prepareStatement("SELECT FIRSTNAME, MIDDLENAME, LASTNAME, ACCOUNT_NUMBER, PHONENO, BALANCE FROM Customers WHERE ACCOUNT_NUMBER = ?");
                        statement.setString(1,accountNumber);
                        ResultSet result = statement.executeQuery();

                        while(result.next()){
                            String fName = result.getString("FIRSTNAME");
                            String mName = result.getString("MIDDLENAME");
                            String lName = result.getString("LASTNAME");
                            String accNumber = result.getString("ACCOUNT_NUMBER");
                            String phoneNumber = result.getString("PHONENO");
                            System.out.println("Account Details for Customer");
                            System.out.println("Your account name is : " +fName+" "+mName+ " "+" "+lName + "\n Your account number is " + accNumber +"\n Your phone number is: " + phoneNumber);
                            check =false;
                        }
                    }
                    case 3 -> {
                        PreparedStatement statement = conn.prepareStatement("DELETE FROM Customers WHERE ACCOUNT_NUMBER = ?");
                        statement.setString(1,accountNumber);
                        statement.executeUpdate();
                        System.out.println("Account Deleted successfully. \n Thank you for Banking with Us");
                        check = false;
                    }
                }

            }

        } catch (SQLException e) {
            throw new Error("Error ", e);
        }

        return new Account(firstName,middleName,lastName,accountNumber,email,phoneNo,balance);

    }


    public static int depositAmount(){
        System.out.print("Enter amount to deposit: ");
        return scanner.nextInt();
    }

}

