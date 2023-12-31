//Base class
//Abtract
public abstract class Account{

    // account number
    private int accountNumber;

    //Blance
     protected double Balance;

    //Default constructor
    public Account()
    {
       
    }

    public Account(int accountNumber)
    {
        this.accountNumber=accountNumber;
        Balance=0;
    }
    
    //Getter methods
    public double getBalance()
    {
        return this.Balance;
    }

    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    //Abstract
    /*
     * Funtion to deposit funds into the account as long as
     * the amount parameter is > 0
     * Apply Transaction fee for the CheckingAccount
     */
    public abstract void deposit(double amount);

    /*
     * Function to withdraw funds from the Account as long as
     * 1. Amount to withdraw must be > 0
     * 2. Amount to withdraw must be <= balance
     */
    public abstract void withdraw(double amount);
}