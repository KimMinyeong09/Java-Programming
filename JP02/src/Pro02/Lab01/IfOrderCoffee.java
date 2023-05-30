package Pro02.Lab01;

import java.util.Scanner;

public class IfOrderCoffee {

	public static void main(String[] args){
		int price;
		System.out.print("커피주문하세요>> ");
		
		Scanner scanner = new Scanner(System.in);
		String input_menu = scanner.next();
		int input_num =Integer.parseInt(scanner.next());
		
		if (input_menu.equals("에스프레소")) {//2000
			price = input_num * 2000;
			System.out.printf("%d원 입니다", price);
		}
		else if (input_menu.equals("아메리카노")) {//2500
			price = input_num * 2500;
			System.out.printf("%d원 입니다", price);
		}
		else if (input_menu.equals("카푸치노")) {//3000
			price = input_num * 3000;
			System.out.printf("%d원 입니다", price);
		}
		else if (input_menu.equals("카페라테")) {//3500
			price = input_num * 3500;
			System.out.printf("%d원 입니다", price);
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
	}

}
