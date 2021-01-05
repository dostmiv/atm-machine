import java.util.Scanner;
public class Login {
	Scanner scanner = new Scanner(System.in);
	
	public Account createAccount() {
		Account account = new Account();
		System.out.println("+++++");
		System.out.println(
				  "Id : ");
		account.setId(scanner.nextInt());
		System.out.println(
				  "Password : ");
		account.setPassword(scanner.nextInt());
		
		return account;
	}
	
	public void Loginscreen(){
		
	}
}






