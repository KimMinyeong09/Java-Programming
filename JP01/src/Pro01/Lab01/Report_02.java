package Pro01.Lab01;
import java.util.Scanner;

public class Report_02 {
	
	static void method1()
	{	
		int sum = 0, count = 0, average;
		
		while (true) {
			System.out.print("Enter grade: ");
			Scanner scanner = new Scanner(System.in);
			String grade;
			grade = scanner.nextLine();
			if (grade.equals("-1")) {
				break;
			}
			sum += Integer.parseInt(grade);
			count++;
		}
		average = sum / count;
		System.out.printf("Total of %d student grades is %d\n", count, sum);
		System.out.printf("Class average is %d\n", average);

	}
	
	static void method2 ()
	{
		int a = 0, b = 0, c = 0, d = 0, f = 0;
		while (true) {
			System.out.print("Enter grade: ");
			Scanner scanner = new Scanner(System.in);
			String grade;
			grade = scanner.nextLine();
			if (grade.equals("-1")) {
				break;
			}
			if (90 <= Integer.parseInt(grade) && Integer.parseInt(grade) <= 100) {
				a++;
			}
			if (80 <= Integer.parseInt(grade) && Integer.parseInt(grade) <= 89) {
				b++;
			}
			if (70 <= Integer.parseInt(grade) && Integer.parseInt(grade) <= 79) {
				c++;
			}
			if (60 <= Integer.parseInt(grade) && Integer.parseInt(grade) <= 69) {
				d++;
			}
			if (Integer.parseInt(grade) <= 59) {
				f++;
			}

		}
		System.out.println("Number of students who received each grade");
		System.out.printf("A: %d\nB: %d\nC: %d\nD: %d\nF: %d\n", a, b, c, d, f);
	}
	
	public static void main(String[] args) {
		
		method1();
		System.out.print("\n");
		method2();

	}

}
