package Pro04.Lab01;
import java.util.Scanner;

public class Account {//1.Account 클래스 만들기
	private double balance;
	
	public Account( double initialBalance )
	{
		if ( initialBalance > 0.0 ) balance = initialBalance; 
	} 
	public void credit( double amount )
	{      
		balance = balance + amount; 
	} 
	public double getBalance()
	{
		return balance; 
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("초기 잔액을 입력하세요.>> ");
		double initialBalance = Double.parseDouble(scanner.next());

		System.out.println("입금할 금액을 입력하세요.>> ");
		double amount = Double.parseDouble(scanner.next());
		
		Account account = new Account(initialBalance);
		account.credit(amount);
		
		System.out.printf("잔액:%f",account.getBalance());
		
	}
}
