package com.company;

public class Account {

    private String firstName;
    private String middleName;
    private String lastName;
    public static int incrementalVal;
    private String number;
//    private String dateCreated;
    private String email;
    private String phoneNo;
    private int balance = 0;
    
    
 public Account(String firstName, String middleName, String lastName, String number, String email, String phoneNo,int balance){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
//        this.dateCreated = dateCreated;
        this.phoneNo = phoneNo;
        this.balance = balance;
        incrementalVal++;

    }

    public void withdraw(int amount){
        if(balance > 0){
            balance -= amount;
            System.out.println("You have withdrawn "+ amount+ " from your account. You are left with " + balance);
        }else{
            System.out.println("You do not have enough money to make the withdrawal");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
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

    public String getFullName(){
     return getFirstName() + getMiddleName() + getLastName();
    }





}
