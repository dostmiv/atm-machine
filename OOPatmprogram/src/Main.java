
//oop atm program
//Login class will control user Login.
//Account class will do Account transaction.
//ATM class will run the atm.

public class Main{
	
	
	public static void main (String [] Args)
	{
		Account recordedaccount = new Account(11888579,1000.0,"Mert",80893);
		Account recordedaccount2 = new Account(227935,15.75,"Mahmut",75929);
		
		
		ATM atm = new ATM();
		atm.Atm(recordedaccount,recordedaccount2);
	}
}