package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    private static final Date date = new Date();
//    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static  String firstName;
    private static  String middleName;
    private static  String lastName;




    public static void main(String[] args) {
        try {
//           Class.forName("org.mariadb.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/hulubank";
            String dbUser = "odin";
            String dbPass = "123456";
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            System.out.println("Connection Successful");
            Account account1 = createAccount();
//            Statement statement = conn.createStatement();
//            String sql = "INSERT INTO Customers(FIRSTNAME,MIDDLENAME,LASTNAME,EMAIL,ACCOUNT_NUMBER,PHONENO) " + " VALUES('John',' ','Doe','eric@gmail.com','1123456','0203663447');";
//            statement.executeQuery(sql);

        } catch (SQLException e) {
            throw new Error("Error ", e);
        }

    }

    public static Account createAccount(){
            //welcome message.
            System.out.println("Welcome to First Hulu Bank");
    
            //Taking the name of account
            System.out.print("Enter your full name (first middle last): ");
            String name = scanner.nextLine();
    
            System.out.print("Enter your email address: ");
            String email = scanner.nextLine();
    
            System.out.print("Enter your phone number: ");
            String phoneNo = scanner.nextLine();
    
            //splitting and working with text.
            String[] nameSplit = name.split(" ");
            String accountBaseNumber = "HULU-5000";
            String[] splitBase = accountBaseNumber.split("-");
            int nextAccountNumber = Integer.parseInt(splitBase[1]) + Account.incrementalVal;
            String accountNumber = "HULU-"+ nextAccountNumber +"";
            int balance = 0;

        switch (nameSplit.length) {
            //                if user has three names. e.g John Michael Doe
            case 3 -> {
                firstName = nameSplit[0];
                middleName = nameSplit[1];
                lastName = nameSplit[2];
            }
            //                    if user has four names and in case last two names are surnames e.g. John Michael Doe Raymond.
            case 4 -> {
                firstName = nameSplit[0];
                middleName = nameSplit[1];
                lastName = nameSplit[2] + " " + nameSplit[3];
            }
            default -> System.out.println("Default Printout");
        }

            System.out.println("Hello " + firstName +" "+ lastName + ", your account number is: " + accountNumber + " with a balance of " + balance);
    
            //getting date.
//            String dateCreated = formatter.format(date);
//            System.out.println("This account was created on " + dateCreated);

        return new Account(name,accountNumber,email,phoneNo,balance);
        
    }

    public static void removeAccount(Account account){
        if(accounts.contains(account)){
            System.out.println("The account with account name "+ account.getName() +" is being removed. Press 1 to Confirm or 2 to Cancel");
            int check = scanner.nextInt();
            if(check == 1){
                accounts.remove(account);
                System.out.println("Account removed successfully");
            }else{
                System.out.println("Account failed to be removed");
                return;
            }
        }
    }

    public static void searchAccount(String accountName){
        for(int i =0; i < accounts.size(); i++){
            String nameInAccounts = accounts.get(i).getName();
            if(nameInAccounts.equals(accountName)){
                System.out.println("Account exists");
            }
        }
}
       
    
}

