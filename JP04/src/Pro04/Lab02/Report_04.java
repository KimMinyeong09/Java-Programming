package Pro04.Lab02;
import java.util.Scanner;

public class Report_04 {
	static Scanner scanner = new Scanner(System.in);
	
	static void method1() {
		System.out.print("Enter deposit amount for account1: ");
		double deposit1 = Double.parseDouble(scanner.next());
		Account1 account1 = new Account1("account1");
		account1.credit(deposit1);
		
		System.out.print("Enter deposit amount for account2: ");
		double deposit2 = Double.parseDouble(scanner.next());
		Account1 account2 = new Account1("account2");
		account2.credit(deposit2);
		
		System.out.printf("account1 balance: $%.2f\n",account1.getBalance());
		System.out.printf("account2 balance: $%.2f\n",account2.getBalance());
		
	}
	
	static void method2() {
		Account1 account = new Account1("ȫ�浿");
		account.credit(1000.0);
		account.print();
		System.out.println("");
		account.addInterest(1.1);
		account.print();
	}
	
	static void method3() {
		System.out.print("Enter first integer: ");
		int firstNum = Integer.parseInt(scanner.next());
		System.out.print("Enter second integer: ");
		int secondNum = Integer.parseInt(scanner.next());
		
		System.out.printf("Sum is %d\n",firstNum + secondNum);
		System.out.printf("Product is %d\n",firstNum * secondNum);
		System.out.printf("Difference is %d\n",firstNum - secondNum);
		System.out.printf("Quotient is %d\n",firstNum / secondNum);
	}

	public static void main(String[] args) {
		System.out.println("<method1 test>");
		method1();
		System.out.println("");
		
		System.out.println("<method2 test>");
		method2();
		System.out.println("");
		
		System.out.println("<method3 test>");
		method3();
		System.out.println("");
	}

}
