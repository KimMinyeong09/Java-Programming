package Pro02.Lab01;

import java.util.Scanner;

public class SwitchOrderCoffee {

	public static void main(String[] args) {
		int price;
		System.out.print("Ŀ���ֹ��ϼ���>> ");
		
		Scanner scanner = new Scanner(System.in);
		String input_menu = scanner.next();
		int input_num =Integer.parseInt(scanner.next());
		
		switch (input_menu) {
		case "����������"://2000
			price = input_num * 2000;
			System.out.printf("%d�� �Դϴ�", price);
			break;
		case "�Ƹ޸�ī��"://2500
			price = input_num * 2500;
			System.out.printf("%d�� �Դϴ�", price);
			break;
		case "īǪġ��"://3000
			price = input_num * 3000;
			System.out.printf("%d�� �Դϴ�", price);
			break;
		case "ī�����"://3500
			price = input_num * 3500;
			System.out.printf("%d�� �Դϴ�", price);
			break;
		default :
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}

	}

}
