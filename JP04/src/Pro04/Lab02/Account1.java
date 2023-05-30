package Pro04.Lab02;

public class Account1 {//2.Account 클래스 확장하기
	private String name;//예금주
	private double balance;//잔액

	public Account1(String n){
		name = n;
		balance = 0;
	}
	public String getName(){ 
		return name;
	}

	public double getBalance(){ 
		return balance;
	}

	public void credit(double b){
		balance = balance + b; 
	}
		
	public void print() {
		System.out.printf("예금주: %s\n",name);
		System.out.printf("잔액: %.2f\n", balance);
	}
			
	public void addInterest(double interestRates) {
		 balance = balance * interestRates;
	}
}
