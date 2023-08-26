//Cheking Account
public class CheckingAccount  extends Account{

    //Defoult Transaction fee
    private static double FEE=2.5;

    //default constructor
    public CheckingAccount()
    {
        super();
    }

    /*
     * parametre constructor to intialize CheckingAccount
     * with a custom Account Number and a customer Transaction
     * Fee.
     */
    public CheckingAccount(int accountNumber, double fee)
    {
       super(accountNumber);
       FEE=fee; 
    }

    //Abstract
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

                //Apply Transaction Fee
                Balance -= FEE;
                System.out.printf("Fee %.2f Applied%n",FEE);
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
            if((amount+FEE)<=amount){

                System.out.printf("Amount of %.2f withdrawn from Account%n",amount);
                Balance -=amount;
                Balance -= FEE;
                System.out.printf("Fee of %.2fapplied%n",FEE);
                System.out.printf("Current Balance is: %.2f%n",Balance);
            }
        }
        else{
            System.out.println("Negative amount cannot be withdrawn ");
        }
    }
}
