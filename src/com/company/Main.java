package com.company;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Date date = new Date();
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

    //    Account Eric =  createAccount();
    //    Account Michael = createAccount();
    //    Account John = createAccount();

    //     accounts.add(Eric);
    //     accounts.add(Michael);
    //     accounts.add(John);

    //     for(int i =0; i < accounts.size(); i++){
    //         System.out.println(accounts.get(i).getName());
    //     }


    Animal dog;
    dog = new Animal();
    dog.bark();






    }

    public static Account createAccount(){
            //welcome message.
            System.out.println("Welcome to Hulu Bank");
    
            //Taking the name of account
            System.out.print("Enter your full name: ");
            String name = scanner.nextLine();
    
            System.out.print("Enter your email address: ");
            String email = scanner.nextLine();
    
            System.out.print("Enter your phone number: ");
            String phoneNo = scanner.nextLine();
    
            //splitting and working with text.
            String[] firstName = name.split(" ");
            String accountBaseNumber = "HULU-5000";
            String[] baseValue = accountBaseNumber.split("-");
            int nextAccountNumber = Integer.parseInt(baseValue[1]) + Account.incrementalVal;
            String accountNumber = "HULU-"+ nextAccountNumber +"";
            System.out.println("Hello " + firstName[0] + ", your account number is: " + accountNumber);
    
            //getting date.
            String dateCreated = formatter.format(date);
            System.out.println("This account was created on " + dateCreated);
    
           Account newAccount = new Account(name,accountNumber,email,dateCreated,phoneNo);

           return newAccount;
    
        
    
    }
       
    
}

