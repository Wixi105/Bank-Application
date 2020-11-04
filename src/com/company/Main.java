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


    }

    public static Account createAccount(){
            //welcome message.
            System.out.println("Welcome to First Hulu Bank");
    
            //Taking the name of account
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your middle name: ");
            String middleName = scanner.nextLine();

            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
    
            System.out.print("Enter your email address: ");
            String email = scanner.nextLine();
    
            System.out.print("Enter your phone number: ");
            String phoneNo = scanner.nextLine();
    
            //splitting and working with text.

            String accountBaseNumber = "HULU-5000";
            String[] splitBase = accountBaseNumber.split("-");
            int nextAccountNumber = Integer.parseInt(splitBase[1]) + Account.incrementalVal;
            String accountNumber = "HULU-"+ nextAccountNumber +"";
            int balance = 0;

            System.out.println("Hello " + firstName +" "+ lastName + ", your account number is: " + accountNumber + " with a balance of " + balance);
    
            //getting date.

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
                System.out.println("Personal Information has been stored. Press 1 to initiate deposit or 2 to cancel");
                int userOption = scanner.nextInt();
                switch (userOption){
                    case 1 -> {
                        int depositAmount = depositAmount();
                        String sql2 = "UPDATE Customers SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql2);
                        preparedStatement.setInt(1,depositAmount);
                        preparedStatement.setString(2,accountNumber);
                        preparedStatement.executeUpdate();
                        System.out.print("Your balance is now: " + depositAmount);
                        check = false;
                    }
                    case 2 ->{
                        check = false;
                        System.out.print("Your account balance remains : " + balance);
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

    public static void removeAccount(Account account){
        if(accounts.contains(account)){
            System.out.println("The account with account name "+ account.getFullName() +" is being removed. Press 1 to Confirm or 2 to Cancel");
            int check = scanner.nextInt();
            if(check == 1){
                accounts.remove(account);
                System.out.println("Account removed successfully");
            }else{
                System.out.println("Account failed to be removed");
            }
        }
    }

    public static void searchAccount(String accountName){
        for (Account account : accounts) {
            String nameInAccounts = account.getFullName();
            if (nameInAccounts.equals(accountName)) {
                System.out.println("Account exists");
            }
        }
}
       
    
}

