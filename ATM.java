package ATM_Package;

//importing necesary packages
import java.util.*;
import java.text.*;


//Account Class having all the classes
class Account
{	
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("'Rupee : '###,##0.00");
	int CN;
	int PN;
	private double CB =2000;
	private double SB =1000;
	void setCostumerNumber(int a) 
	{CN = a;}
	void setPinNumber(int b)
	{PN = b;}
	int getCostumerNumber() 
    {return CN;}
	int getPinNumber()
    {return PN;}
	double getCurrentBalance()
	{
	 return CB;   
	}
	double getSavingBalance()
    {
     return SB;   
    }
	void getSavingWithdrawInput()
	{
	    System.out.println("Your Saving Account Balance is :"+ df.format(SB));
	    System.out.print("Please Enter the Amount You want to Withdraw : ");
	    double amount= sc.nextDouble();
	    
	    if((SB-amount)>=0)
	    {
	        calcSavingWithdraw(amount);
	        System.out.println("\n"+"Your new Saving account balance is : "+df.format(SB));
	    }
	    else
	    {
	       System.out.println("Sorry ,Your Balance is insufficient for this Transaction");
	    }
	  
	}
	double calcSavingWithdraw(double amount)
	{
	    SB = SB-amount;
	    return SB;
	}
	void getCurrentWithdrawInput()
	    {
	        System.out.println("Your Current Account Balance is :"+ df.format(CB));
	        System.out.print("Please Enter the Amount You want to Withdraw : ");
	        double amount= sc.nextDouble();
	        
	        if((CB-amount)>=0)
	        {
	            calcCurrentWithdraw(amount);
	            System.out.println("\n"+"Your new current account balance is : "+df.format(CB));
	        }
	        else
	        {
	           System.out.println("Sorry ,Your Balance is insufficient for this Transaction");
	        }
	      
	    }
	double calcCurrentWithdraw(double amount)

	    {
	        CB = CB-amount;
	        return CB;
	    }
	void getCurrentDepositInput() 
	{
	    System.out.println("Your Current Account Balance is :"+ df.format(CB));
	    System.out.println("Please Enter the Amount You Want to deposit");
	    double amount =sc.nextDouble();
	    if((CB+amount)>=0) 
	    {
	        calcCurrentDeposit(amount);
	        System.out.println("\n"+"Your new Current Account Balance is:"+df.format(CB));
	    }
	    else 
	    {
	     System.out.println("Please Enter the Valid amount");   
	    }
	}
	double calcCurrentDeposit(double amount)
	{
	    CB= CB + amount;
	    return CB;
	}
	void getSavingDepositInput() 
    {
        System.out.println("Your Saving Account Balance is :"+ df.format(SB));
        System.out.println("Please Enter the Amount You Want to deposit");
        double amount =sc.nextDouble();
        if((SB+amount)>=0) 
        {
            calcSavingDeposit(amount);
            System.out.println("\n"+"Your new Saving Account Balance is:"+df.format(SB));
        }
        else 
        {
         System.out.println("Please Enter the Valid amount");   
        }
    }
    double calcSavingDeposit(double amount)
    {
        SB= SB + amount;
        return SB;
    }
}

class OptionMenu extends Account
{
Scanner sc = new Scanner(System.in);
HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
DecimalFormat df = new DecimalFormat("'Rupee : '###,##0.00");

void getLogin() 
{
    int x=1;
do {
    try
    {
               hm.put(11111,111);
               hm.put(22222,222);
               hm.put(33333,333);
               hm.put(44444,444);
               hm.put(55555,555);
               
               System.out.println("Welcome to MSBECL ATM" + "\n");
               System.out.println("Enter your Costumer Number");
               setCostumerNumber(sc.nextInt());
               System.out.println("Enter your PIN Number");
               setPinNumber(sc.nextInt());
               
               int p= getCostumerNumber();
               int q =getPinNumber();
               
               if(hm.containsKey(p) && hm.get(p)==q) 
               {
                   getAccountType();
               }
               else
               {
                   System.out.println("Wrong Customer Number Or Pin Number \n Please Enter Correct Customer Number Or Pin Number");
               }
               
               
    }
    catch (InputMismatchException e) 
        {
           System.out.println(" \n Please only Enter only number.\n Character are not allowed");
           x=2;
        }
}
while(x==1);
}

void getAccountType()
{
	    System.out.println("Select the Account Type You Want to Access");
	    System.out.println("Type 1 - Current Account");
	    System.out.println("Type 2 - Saving Account");
	    System.out.println("Type 3 - Exit");
	    System.out.println("Enter Your Choice:-");
	    int choice =sc.nextInt();
            switch(choice)
            {
             case 1:
                 getCurrent();
                 break;
                 
             case 2:       
                 getSaving();
                 break;
                 
             case 3:
                 System.out.print("Thank You For Visiting \n Visit Again");
                 getLogin();
                 break;
                 
             default:
                 System.out.print("Invalid Choice \n Please Enter Valid Choice");   
            }
}
	
void getCurrent() 
{
	    System.out.println("Type-1 'View Balance'");
	    System.out.println("Type-2 'Withdraw Funds'");
	    System.out.println("Type-3 'Deposit Funds'");
	    System.out.println("Type-4 'Exit'");
	    System.out.println("Choice:");
	    int choice =sc.nextInt();
	    switch(choice) 
	    {
	        case 1:
	            System.out.println("Your Current Account Balance is: " + df.format(getCurrentBalance()) );
	            getAccountType();// getCurrentBalance();
	            break;
	        case 2:
	            getCurrentWithdrawInput();
	            getAccountType();
	            break;
	        case 3:
	            getCurrentDepositInput();
	            getAccountType();
	            break;
	        case 4:
	            System.out.print("Thank You \n Visit Again");
	            getAccountType();
	        default:
	            System.out.print("Invalid Choice \n Please Enter Valid Choice"); 
	            break;
	            
	    }
}
void getSaving() 
{
        System.out.println("Type-1 'View Balance'");
        System.out.println("Type-2 'Withdraw Funds'");
        System.out.println("Type-3 'Deposit Funds'");
        System.out.println("Type-4 'Exit'");
        System.out.println("Choice:");
        int choice =sc.nextInt();
        switch(choice)
        
        {
            case 1:
                System.out.println("Your Saving Account Balance is: " + df.format(getSavingBalance()) );
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.print("Thank You \n Visit Again");
                getAccountType();
            default:
                System.out.print("Invalid Choice \n Please Enter Valid Choice"); 
                break;
                
        }
}
}

public class ATM extends OptionMenu
{	
	public static void main (String[] args) 
	{
		OptionMenu op = new OptionMenu();
		op.getLogin();
	}
}

