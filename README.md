# Bank-Application
This is a banking app with the most minimal of features. Still in development.
## Installation
The application requires no installation, but it requires users to have a Java JDK and a database driver for MySQL installed to be able to run it. For Linux systems
you can refer to your distributions to wiki to find the available Java JDK you can install. 

Arch Linux
```
sudo pacman -S jdk-openjdk

```

Ubuntu

```
sudo apt update

sudo apt install default-jre

sudo apt install default-jdk

```

Fedora

```
dnf search openjdk

sudo dnf install java-latest-openjdk.x86_64

```

Once you have Java installed, you can run ``` java -version ``` to verify your install.

You can download the MySQL driver from their official website, and using IntelliJ, go to File -> Project Structures -> Modules -> Dependencies -> Click on the plus sign at the bottom, Navigate to your driver's location and add it -> Click Apply then Ok to Finish.


## Usage

Open the Main.java file in an IDE like VS Code or IntelliJ(recommended). 
Navigate to the Main.java file, and run the program.

1. The program starts by asking users to fill in their details so it can be added to a database.

![Screenshot 1] (https://github.com/Wixi105/Bank-Application/blob/main/images/BankApp1.png)


2. Once details are collected, it prints to STDOUT, the user's name and account details but it also prompts the user to initiate a deposit, or do some of the other items on the menu.
Option 1 : initiates a deposit
Option 2: shows account details.
Option 3: deletes your account from the database;
![Screenshot 2] (https://github.com/Wixi105/Bank-Application/blob/main/images/BankApp2.png)

Output of option 2 being displayed.
![Screenshot 3] (https://github.com/Wixi105/Bank-Application/blob/main/images/BankApp3.png)


3. Once your data is captured, it appears in the databases and is kept for safe keeping
![Screenshot 4] (https://github.com/Wixi105/Bank-Application/blob/main/images/Bank4.png)




