package Pro08.Lab01;

import java.util.*;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();

		Scanner scanner = new Scanner(System.in);

		loop1: while (true) {
			System.out.println("1.ADD  2.REMOVE  3.PRINT POSITION  4.PRINT ALL  5.EXIT");
			System.out.print("���ൿ��: ");
			int n = Integer.parseInt(scanner.nextLine());

			loop2: switch (n) {
			case 1:
				System.out.print("�Է� ��: ");
				String s1 = scanner.nextLine();
				if (!(a.contains(s1)))
					a.add(s1);
				break;
			case 2:
				System.out.print("���� ��: ");
				String s2 = scanner.nextLine();

				for (int i = 0; i < a.size(); i++) {
					String s3 = a.get(i);
					if (s2.equals(s3)) {
						a.remove(i);
						break loop2;
					}
				}
				System.out.printf("%s�� ���� �������� �ʽ��ϴ�.\n", s2);
				break;
			case 3:
				System.out.print("�˻� ��: ");
				String s4 = scanner.nextLine();

				for (int i = 0; i < a.size(); i++) {
					String s5 = a.get(i);
					if (s4.equals(s5)) {
						System.out.printf("%s�� ���� %d��°�� ��ġ�մϴ�\n", s4, i + 1);
						break loop2;
					}
				}
				System.out.printf("%s�� ���� �������� �ʽ��ϴ�.\n", s4);
				break;
			case 4:
				System.out.print("��� ��: ");
				if (a.size() == 0)
					System.out.print("����� ���� �����ϴ�.");
				else {
					for (int i = 0; i < a.size(); i++) {
						String s6 = a.get(i);
						System.out.print(s6 + " ");
					}
				}
				System.out.println();
				break;
			case 5:
				System.out.print("���α׷��� �����մϴ�.");
				break loop1;
			}

		}

	}

}
