package Pro03.Lab01;
import java.util.Scanner;

public class PhoneManager {
	private Phone [] p;
	static int inputNum;
	Scanner scanner = new Scanner(System.in);
	
	private void read() {
		int i;
		String name, tel;
		System.out.print("인원수>> ");
		inputNum = Integer.parseInt(scanner.next());
		
		p = new Phone[inputNum];
		
		for (i=0;i<inputNum;i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력)>> ");
			String inputName = scanner.next();
			String inputTel = scanner.next();
			p[i] = new Phone(inputName, inputTel);
		}
		System.out.println("저장되었습니다...");
	}
	
	private String search(String name) {
		int i;
		for (i=0;i<inputNum;i++) {
			if (name.equals(p[i].getName())) {
				return name + "의 번호는 " + p[i].getTel() + "입니다.";
			}
		}
		return name + "이(가) 없습니다.";
	}

	public void run() {
		read();
		while(true) {
			System.out.print("검색할 이름>> ");
			String name = scanner.next(); 
			if(name.equals("exit")) {
				System.out.println("프로그램을 종료합니다...");
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
