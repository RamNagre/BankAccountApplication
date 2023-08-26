import java.util.Scanner;

//import javax.swing.plaf.nimbus.State;
public class AccountDriver {

    //Entry point of program
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);

        //create array of Accounts
        Account accounts[]=new Account[10];
        int numAccounts=0;

        int choice;

        do{
            choice=menu(keyboard);
            System.out.println();
            if(choice==1){
                accounts[numAccounts++]=createAccount(keyboard);
            } else if(choice==2){
                doDeposited(accounts, numAccounts, keyboard);
            }else if(choice==3){
                dowithdraw(accounts, numAccounts, keyboard);
            }else if(choice==4){
                applyInterest(accounts, numAccounts, keyboard);
            }else{
                System.out.println("GoodBye!");
            }
            System.out.println();
        }while(choice!=5);
    }
    
    /**
     * Account choice
     * @param keyboard
     * @return
     */
    public static int accountMenu(Scanner keyboard){
        System.out.println("Select Account Type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do{
            System.out.println("Enter Choice: ");
            choice = keyboard.nextInt();
        }
        while(choice < 1 ||  choice > 2);

        return choice;
    }

    public static int searchAccount(Account accounts [], int count, int accountNumber){

        for(int i=0;i<count;i++){
            if(accounts[i].getAccountNumber()==accountNumber){
                return i;
            }
        }
        return -1;
    }

    /**
     * Function to perform deposite on a selected account
     * @param account
     * @param count
     */
    public static void doDeposited(Account accounts [], int count, Scanner keyboard){
        //Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber=keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index>=0){
        //Amount
        System.out.println("please enter Deposit Amount: ");
        double amount=keyboard.nextDouble();

        accounts[index].deposit(amount);
        }else{
            System.out.println("No Account exist with AccountNumber: "+accountNumber);
        }
    }

    public static void dowithdraw(Account accounts[], int count, Scanner keyboard){
         System.out.print("\nPlease enter account number: ");
        int accountNumber=keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index>=0){
        //Amount
        System.out.println("please enter Withdraw Amount: ");
        double amount=keyboard.nextDouble();
        accounts[index].withdraw(amount);
        }else{
            System.out.println("No Account exist with AccountNumber: "+accountNumber);
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner keyboard){
         System.out.print("\nPlease enter account number: ");
        int accountNumber=keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

         
        if(index>=0){
            // must be instance of saving account
            if(accounts[index] instanceof savingsAccount){
            ((savingsAccount)accounts[index]).applyInterest();
            }
        }else{
            System.out.println("No Account exist with AccountNumber: "+accountNumber);
        }
    }
    /*
     * Funtion to create a new account
     */
    public static Account createAccount(Scanner keyboard){
        
        Account account=null;
        int choice = accountMenu(keyboard);
        
        int accountNumber;
        System.out.print("Enter Account Number");
        accountNumber=keyboard.nextInt();
        if(choice==1) { // cheking account
            System.out.println("Enter trasaction Fee: ");
            double fee=keyboard.nextDouble();
           
            account=new CheckingAccount(accountNumber,fee);
        }
        else{ //Saving account
            System.out.println("Please Enter Interest Rate: ");
            double ir=keyboard.nextDouble();

            account=new savingsAccount(accountNumber, ir);
        }
        return account;
    }
    /*
     * Menu to display and get user's Selection
     */
    public static int menu(Scanner keyboard){
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposite Funds");
        System.out.println("3. withdraw Funds");
        System.out.println("4. Apply Interest");
        //System.out.println("4. Check Blance");
        System.out.println("5. Quit");

        int choice;

        do{
            System.out.println("Enter Choice: ");
            choice=keyboard.nextInt();
        }
        while(choice<1 || choice>5);
        return choice;
    }
}
