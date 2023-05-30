package Pro08.Lab02;

import java.util.*;

public class HashMapEx {

	public static void main(String[] args) {
		HashMap<String, Integer> dic = new HashMap<String, Integer>();

		System.out.println("** ����Ʈ ���� ���α׷� �Դϴ�. **");
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("�̸��� ����Ʈ �Է�>> ");
			String s = scanner.next();

			if (s.equals("exit")) {
				System.out.print("���α׷��� �����մϴ�...");
				break;
			}

			int n = scanner.nextInt();

			if (dic.containsKey(s)) {
				int sum = dic.get(s);
				sum += n;
				dic.replace(s, sum);
				
			}

			else {
				dic.put(s, n);
			}

			Set<String> keys = dic.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String key = it.next();
				int value = dic.get(key);
				System.out.print("(" + key + ", " + value + ")");
			}
			System.out.println();
		}
	}

}
