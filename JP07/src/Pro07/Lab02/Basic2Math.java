package Pro07.Lab02;

public class Basic2Math extends BasicMath{
	private double a;
	private double b;

	public Basic2Math(double a, double b) {
		setA(a);
		setB(b);
	}

	public void setA(double a) {
		this.a = a;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double sum() {
		return BasicMath.sum(a, b);
	}

	public double sub() {
		return BasicMath.sub(a, b);
	}

	public double mul() {
		return mul(a, b);
	}
}
