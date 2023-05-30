package Pro04.Lab01;
import java.util.Scanner;

public class Account {//1.Account Ŭ���� �����
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
		
		System.out.println("�ʱ� �ܾ��� �Է��ϼ���.>> ");
		double initialBalance = Double.parseDouble(scanner.next());

		System.out.println("�Ա��� �ݾ��� �Է��ϼ���.>> ");
		double amount = Double.parseDouble(scanner.next());
		
		Account account = new Account(initialBalance);
		account.credit(amount);
		
		System.out.printf("�ܾ�:%f",account.getBalance());
		
	}
}
