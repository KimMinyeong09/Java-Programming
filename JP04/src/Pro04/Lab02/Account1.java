package Pro04.Lab02;

public class Account1 {//2.Account Ŭ���� Ȯ���ϱ�
	private String name;//������
	private double balance;//�ܾ�

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
		System.out.printf("������: %s\n",name);
		System.out.printf("�ܾ�: %.2f\n", balance);
	}
			
	public void addInterest(double interestRates) {
		 balance = balance * interestRates;
	}
}
