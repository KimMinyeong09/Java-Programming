package Pro02.Lab02;

import java.util.Scanner;

public class Day {

	public static void main(String[] args) {
		char[] day = {'��','��','ȭ','��','��','��','��'};
		
		while(true) {
		System.out.print("������ �Է��ϼ���>> ");
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.next());
		if (input<0) {
			System.out.println("���α׷��� �����մϴ�...");
			break;
		}
		int index = input % 7;
		System.out.println(day[index]);
		
		}
			
	}
}
