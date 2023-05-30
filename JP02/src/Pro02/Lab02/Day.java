package Pro02.Lab02;

import java.util.Scanner;

public class Day {

	public static void main(String[] args) {
		char[] day = {'일','월','화','수','목','금','토'};
		
		while(true) {
		System.out.print("정수를 입력하세요>> ");
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.next());
		if (input<0) {
			System.out.println("프로그램을 종료합니다...");
			break;
		}
		int index = input % 7;
		System.out.println(day[index]);
		
		}
			
	}
}
