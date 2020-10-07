package com.company;

public class Account {

    private String name;
    public static int incrementalVal;
    private String number;
    private String dateCreated;
    private String email;
    private String phoneNo;
    
    public Account(){
       incrementalVal++;
    };

    Account(String name, String number, String email, String dateCreated, String phoneNo){
        this.name = name;
        this.number = number;
        this.email = email;
        this.dateCreated = dateCreated;
        this.phoneNo = phoneNo;
    }

	public String getName() {
		return name;
    }
    
    public int getIncrementalValue(){
        return incrementalVal;
    }

    





}
