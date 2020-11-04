package com.company;

public class Account {

    private String name;
    public static int incrementalVal;
    private String number;
//    private String dateCreated;
    private String email;
    private String phoneNo;
    private int balance = 0;
    
    
 public Account(String name, String number, String email, String phoneNo,int balance){
        this.name = name;
        this.number = number;
        this.email = email;
//        this.dateCreated = dateCreated;
        this.phoneNo = phoneNo;
        this.balance = balance;
        incrementalVal++;

    }

    public void deposit(int amount){
        if(amount > 0){
            balance += amount;
            System.out.println("You have successfully deposited " + amount + " into your account.");
            System.out.println("Your current balance is " + balance);
        }else{ 
            System.out.println("Amount is not valid");
        }
    }

    public void withdraw(int amount){
        if(balance > 0){
            balance -= amount;
            System.out.println("You have withdrawn "+ amount+ " from your account. You are left with " + balance);
        }else{
            System.out.println("You do not have enough money to make the withdrawal");
        }
    }

	public String getName() {
		return name;
    }

    public static int getIncrementalVal() {
        return incrementalVal;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getBalance() {
        return balance;
    }





}
