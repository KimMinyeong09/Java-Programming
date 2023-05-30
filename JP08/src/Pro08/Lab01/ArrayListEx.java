package Pro08.Lab01;

import java.util.*;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();

		Scanner scanner = new Scanner(System.in);

		loop1: while (true) {
			System.out.println("1.ADD  2.REMOVE  3.PRINT POSITION  4.PRINT ALL  5.EXIT");
			System.out.print("실행동작: ");
			int n = Integer.parseInt(scanner.nextLine());

			loop2: switch (n) {
			case 1:
				System.out.print("입력 값: ");
				String s1 = scanner.nextLine();
				if (!(a.contains(s1)))
					a.add(s1);
				break;
			case 2:
				System.out.print("삭제 값: ");
				String s2 = scanner.nextLine();

				for (int i = 0; i < a.size(); i++) {
					String s3 = a.get(i);
					if (s2.equals(s3)) {
						a.remove(i);
						break loop2;
					}
				}
				System.out.printf("%s의 값은 존재하지 않습니다.\n", s2);
				break;
			case 3:
				System.out.print("검색 값: ");
				String s4 = scanner.nextLine();

				for (int i = 0; i < a.size(); i++) {
					String s5 = a.get(i);
					if (s4.equals(s5)) {
						System.out.printf("%s의 값은 %d번째에 위치합니다\n", s4, i + 1);
						break loop2;
					}
				}
				System.out.printf("%s의 값은 존재하지 않습니다.\n", s4);
				break;
			case 4:
				System.out.print("모든 값: ");
				if (a.size() == 0)
					System.out.print("저장된 값이 없습니다.");
				else {
					for (int i = 0; i < a.size(); i++) {
						String s6 = a.get(i);
						System.out.print(s6 + " ");
					}
				}
				System.out.println();
				break;
			case 5:
				System.out.print("프로그램을 종료합니다.");
				break loop1;
			}

		}

	}

}
