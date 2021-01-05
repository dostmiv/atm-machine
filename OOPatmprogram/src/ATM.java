import java.util.Scanner;
public class ATM {
	Scanner scanner = new Scanner(System.in);
	public void Bankingscreen() {
		System.out.println("$$$$$$$$$$$" +'\n'
				+ "1-Withdraw"+ '\n'
				+ "2-Deposit in"+ '\n'
				+ "3-Send Money"+ '\n'
				+ "4-Exit to main menu"+ '\n'
				+ "$$$$$$$$$$$"+ '\n');
	}
	public void AtmTransactionscreen() {
		System.out.println("----------------------" +'\n'
				+ "1-Amount Screen"+ '\n'
				+ "2-Banking Transaction"+ '\n'
				+ "3-Account Information"+ '\n'
				+ "4-Change Password"+ '\n'
				+ "5-Exit"+ '\n'
				+ "----------------------");
	}
	public void Atmscreen() {
		System.out.println("-----" +'\n'
				+ "1-Create Account"+ '\n'
				+ "2-Login in"+ '\n'
				+ "3-Exit"+ '\n'
				+ "-----"+ '\n');
	}
	public void SendMoneyscreen(double Amount,Account recordedaccount2){
		System.out.println("-->-->-->-->-->-->" +'\n'
				+ "Reciever ID : ");
				int Id = scanner.nextInt();
				System.out.println('\n' + "Amount: ");
				double amount = scanner.nextDouble();
				System.out.println('\n' + "Note : "+ '\n');
				String Note = scanner.nextLine();
				System.out.println("-->-->-->-->-->-->" + '\n');
				System.out.println("Do you approve that ?" + amount+ "$" + " will be sent to " + Id + "numbered customer with " +"'"+ Note + "'"+  " note .");
				System.out.println("1) Yes " + '\n' + "2)No");
				int selection = scanner.nextInt();
				
				if (selection == 1 ) {
					if (Id == recordedaccount2.getId() && Amount >= amount ) {
						System.out.println("Process Succeed ! money sent !");
						recordedaccount2.setAmount(recordedaccount2.getAmount() + amount);
						System.out.println(recordedaccount2.getName()+"have" +recordedaccount2.getAmount()+ " " + "$");
					}
					if (amount > Amount ) {
						System.out.println("you dont have enough money to send.");
					}
					if (Id != recordedaccount2.getId()) {
						System.out.println("invalid id !");
					}
						
				}
				else if (selection == 2) {
					System.out.println("Send process is cancelled !");
				}
				else {
					System.out.println("invalid number");
				}
				}
	
	public void AtmTransaction (Account account,Account recordedaccount2) {
		while(true) {
			AtmTransactionscreen();
			System.out.println("Enter a number to process :");
			int selection = scanner.nextInt();
			
			if (selection == 1) {
				System.out.println(account.getAmount());
			}
			else if (selection == 2) {
				Bankingtransaction(account,recordedaccount2);
				
			}
			else if (selection == 3) {
				account.showInf();
			}
			else if (selection == 4) {
				System.out.println("enter your password to change it : ");
				if (account.getPassword() == scanner.nextInt()) {
					System.out.println("Password is correct !");
					System.out.print("Enter new password :");
					int pass = scanner.nextInt();
							System.out.print("Enter again to validade it :");
							if (pass == scanner.nextInt()) {
								System.out.println("correct ! New password is updated !");
								account.setPassword(pass);
							}else 
								System.out.println("incorrect !");
				}
			}
			else if (selection == 5) {
				System.out.println("Leaving from System");
				break;
			}
		}	
	}
	
	public void Bankingtransaction(Account recordedaccount,Account recordedaccount2) {
				Bankingscreen();
			while(true) {
				System.out.print("Enter an input to process: ");
				int input = scanner.nextInt();
				if (input == 1) {
					System.out.println("Enter an amount to withdraw : ");
					int withdraw = scanner.nextInt();
					if (withdraw <= recordedaccount.getAmount()) {
					recordedaccount.setAmount(recordedaccount.getAmount() - withdraw);
					System.out.println("Withdraw process has been done successfully ! ");
					AtmTransaction(recordedaccount, recordedaccount2);
				
					}else
						System.out.println("unsuccessful transaction"+ '\n' + "you can not withdraw more money than in account ");
				}else if (input ==2) {
					System.out.println("Enter an amount to deposit : ");
					int depo = scanner.nextInt();
					if (depo > 0) {
					recordedaccount.setAmount(recordedaccount.getAmount() + depo);
					System.out.println("Deposit process has been done successfully ! ");
					AtmTransaction(recordedaccount, recordedaccount2);
					}else 
						System.out.println("you only can deposit amount higher than 0 $");
					
				}else if (input == 3) {
					SendMoneyscreen(recordedaccount.getAmount(),recordedaccount2);
					AtmTransaction(recordedaccount, recordedaccount2);
				}
					else {
					System.out.println("invalid number");
					Bankingscreen();
				}
			}
	}
	
	public void Atm(Account recordedaccount,Account recordedaccount2) {
		Atmscreen();
		while (true) {
			System.out.print("Enter an input to process: ");
			int input = scanner.nextInt();
			if (input == 1) {
				Login login = new Login();//we may work with database.
				recordedaccount = login.createAccount();
			}else if (input ==2) {
				System.out.println("******");
				System.out.print(
						  "Id : ");
				while(true) {
					int counter = 3;
					if (counter == 0) {}
						//exit
				if (recordedaccount.getId() == scanner.nextInt()) {
					System.out.println(" " + "true");
					break;
				}
				else {
					System.out.println("no valid account");
					counter--;
				}
				}
				
				System.out.print(
						  "Password : ");
				while(true) {
					int counter = 3;
					if (counter == 0 ) {}
						//exit
				if (recordedaccount.getPassword() == scanner.nextInt()) {
					System.out.print(" " + "true");
					AtmTransaction(recordedaccount,recordedaccount2);
					break;
					//when the transaction over, it will come back here. !!
				}
				else {
					System.out.println("invalid password");
					counter--;
				}
				}
			}else if (input == 3) {
				System.out.println("Terminating");
				break;
			}else {
				System.out.println("invalid number");
			}
			if(input == 2)
			break;
		}
		
	}
	
	
	
}
	