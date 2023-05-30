package Pro07.Lab01;

public class MyColorPoint extends MyPoint {
	String c;

	public MyColorPoint(int x, int y, String color) {
		super(x, y);
		c = color;
	}

	protected void move(int x, int y) {
		super.x = x;
		super.y = y;
	}

	protected void reverse() {
		int temp = x;
		x = y;
		y = temp;
	}

	protected void show() {
		System.out.println(x + ", " + y + ", " + c);
	}

	public static void main(String[] args) {
		MyPoint p = new MyColorPoint(2, 3, "blue");
		p.move(3, 4);
		p.reverse();
		p.show();
	}

}
