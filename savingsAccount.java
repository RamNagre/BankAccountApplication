//saving Account child Class
// has an interest rate
//a method to apply interest - profit

import javax.sql.rowset.spi.SyncResolver;

public class savingsAccount extends Account {
    
    //private static final double FEE = 0;
    //interest rate
    private double interestRate;

    //default constructor
    public savingsAccount(){
        super();
    }
     /*
     * parametre constructor to intialize saving Account
     * with a custom Account Number and interest rate
     */
    public savingsAccount(int accountNumber, double interestRate)
    {
       super(accountNumber);
       this.interestRate=interestRate;
    }

    //getter function
    public double getInterestRate(){
        return this.interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate=interestRate;
    }
    
    public double calcInterest(){

        return Balance * interestRate;
    }

    public void applyInterest(){
       double interest=calcInterest();
        System.out.printf("Interest amount %.2f added to fund");
        deposit(interest);
     }

    /*
     * Funtion to deposit funds into the account as long as
     * the amount parameter is > 0
     * Apply Transaction fee for the CheckingAccount
     */
    public void deposit(double amount)
    {
            //First check amount
            if(amount>0){
                Balance += amount;
                System.out.printf("Amount %.2f deposited%n",amount);
                System.out.printf("Current Balance is: %.2f%n",Balance);
            }
            else{
                System.out.println("A negative amount cannot be deposited");
            }
    }

    /*
     * Function to withdraw funds from the Account as long as
     * 1. Amount to withdraw must be > 0
     * 2. Amount to withdraw must be <= balance
     */
    public void withdraw(double amount)
    {
        if(amount>0)
        {
            if((amount)<=amount){

                System.out.printf("Amount of %.2f withdrawn from Account%n",amount);
                Balance -=amount;
                System.out.printf("Current Balance is: %.2f%n",Balance);
            }
        }
        else{
            System.out.println("Negative amount cannot be withdrawn ");
        }
    }
}
