package Pro03.Lab01;
import java.util.Scanner;

public class PhoneManager {
	private Phone [] p;
	static int inputNum;
	Scanner scanner = new Scanner(System.in);
	
	private void read() {
		int i;
		String name, tel;
		System.out.print("�ο���>> ");
		inputNum = Integer.parseInt(scanner.next());
		
		p = new Phone[inputNum];
		
		for (i=0;i<inputNum;i++) {
			System.out.print("�̸��� ��ȭ��ȣ(��ȣ�� ���������� �Է�)>> ");
			String inputName = scanner.next();
			String inputTel = scanner.next();
			p[i] = new Phone(inputName, inputTel);
		}
		System.out.println("����Ǿ����ϴ�...");
	}
	
	private String search(String name) {
		int i;
		for (i=0;i<inputNum;i++) {
			if (name.equals(p[i].getName())) {
				return name + "�� ��ȣ�� " + p[i].getTel() + "�Դϴ�.";
			}
		}
		return name + "��(��) �����ϴ�.";
	}

	public void run() {
		read();
		while(true) {
			System.out.print("�˻��� �̸�>> ");
			String name = scanner.next(); 
			if(name.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�...");
				break;
			}
			String tel = search(name);
			System.out.println(tel);
		}
	}
	
	public static void main(String[] args) {
		new PhoneManager().run();
	}
}
