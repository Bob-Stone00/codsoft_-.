import java.util.*;
import java.time.LocalDateTime;

 class UserAccount {
    private double currentBalance;

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double setCurrentBalance(double newBalance) {
        this.currentBalance = newBalance;
        return this.currentBalance;
    }
}

class ATM {
    Scanner input = new Scanner(System.in);
    LocalDateTime localdatetime = LocalDateTime.now();

    UserAccount useraccount = new UserAccount();
    double currentBalance = useraccount.setCurrentBalance(1500.00);

    public void Withdraw(double amount){
        try{
        System.out.println("Enter the amount you want to withdraw below:");
        amount = input.nextInt();

        if(amount <= currentBalance){
           currentBalance -= amount;

            System.out.println("Withdrawl Succcessful!!");

            System.out.println("====ATM Receipt====");
            System.out.println("Date :" + localdatetime);
            System.out.println("Withdrawl Amount R" + amount);
            System.out.println("Available R: ****");
            System.out.println("===================");

        }
        else
        {
            System.out.println("Insufficient Funds!!");
            System.out.println("Requested Amount: R" + amount);
            System.out.println("Available Amount: R" +currentBalance);
        }

        }
        catch(InputMismatchException e){
            System.out.println("Invalid input Type");
        }
  
    }

    public void deposit(double amount){
        try{
        System.out.println("Enter deposit amount below:");
        amount = input.nextInt();

        System.out.println("Deposited Amount: R" + amount);
        
       currentBalance += amount;

        System.out.println("New Balance: R" +currentBalance);
        
        System.out.println("Deposit Successful!!");

        System.out.println("====ATM Receipt====");
        System.out.println("Date :" + localdatetime);
        System.out.println("Deposited Amount R" + amount);
        System.out.println("Available R: ****");
        System.out.println("===================");

        }
        catch(InputMismatchException e){
            System.out.println("Invalid input Type");
        }

    }

   public void checkBalance(){
        System.out.println("Date: " + localdatetime);
        System.out.println("Balance: R" +currentBalance);
   }

}


public class App {
    public static void main(String[] args)  {
       
    Scanner scanner = new Scanner(System.in);
    
    ATM atm = new ATM();

    String userOption;

    do {

    System.out.println("==========ATM==============");
    System.out.println("Select from the options below:");

    System.out.println("A.Withdraw");
    System.out.println("B.Deposit"); 
    System.out.println("C.Check Balance");
    System.out.println("D.Exit");
    System.out.println("============================");

    userOption = scanner.nextLine();

    if(userOption.equals("A")){
        atm.Withdraw(0);
    }
    else if(userOption.equals("B")){
        atm.deposit(0);
    }
    else if(userOption.equals("C")){
        atm.checkBalance();
    }

    }
    while(!userOption.equals("D"));

    System.out.println("Thank you for using our service");

    scanner.close();
    }
}
