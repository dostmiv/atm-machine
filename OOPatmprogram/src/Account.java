public class Account {
		private int id;
		private double amount;
		private String name;
		private int password;
		
		public Account () 
		{	
			this(0,0.0,"No information-",0000);
		}
		
		
		public Account (int id,double amount,String name,int password) 
		{
			this.id = id;
			if (amount >= 0 ) 
			{
				this.amount = amount;	
			}
			else 
			{
				System.out.println("amount can not be lower than 0. So amount is assigned as 0.0");
			}
			this.name = name;
			this.password = password;
		}
		
		public void showInf () 
		{
			System.out.println(this.id);
			System.out.println(this.name);
			System.out.println(this.amount+" "+ "$");
		}
		
		public void withdraw(double amount) {
			System.out.println("please enter your password to continue the process :");
			
			if (amount > this.amount)
				System.out.println("you can not withdraw an amount that is more than current.");
			else if (amount <= this.amount) {
				this.amount -= amount;
			}
		}
		public void deposit(double amount) {
			if (amount <= 0 )
				System.out.println("you can only deposit an amount that is more than 0 $.");
			else if (amount > 0) {
				this.amount += amount;
			}
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPassword() {
			return password;
		}
		public void setPassword(int password) {
			this.password = password;
		}
}