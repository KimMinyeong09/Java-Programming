package Pro02.Lab01;

import java.util.Scanner;

public class IfOrderCoffee {

	public static void main(String[] args){
		int price;
		System.out.print("Ŀ���ֹ��ϼ���>> ");
		
		Scanner scanner = new Scanner(System.in);
		String input_menu = scanner.next();
		int input_num =Integer.parseInt(scanner.next());
		
		if (input_menu.equals("����������")) {//2000
			price = input_num * 2000;
			System.out.printf("%d�� �Դϴ�", price);
		}
		else if (input_menu.equals("�Ƹ޸�ī��")) {//2500
			price = input_num * 2500;
			System.out.printf("%d�� �Դϴ�", price);
		}
		else if (input_menu.equals("īǪġ��")) {//3000
			price = input_num * 3000;
			System.out.printf("%d�� �Դϴ�", price);
		}
		else if (input_menu.equals("ī�����")) {//3500
			price = input_num * 3500;
			System.out.printf("%d�� �Դϴ�", price);
		}
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
	}

}
