package Pro06.Lab02;

interface Payable{
	String play();
}

public abstract class Music implements Payable {
	protected String name;
	protected int year;
	
	public Music(String name, int year){
		this.name = name;
		this.year = year;
	}
	public String toString() {
		return "Music [���=" + name + ", ����=" + year + "]";
	}
	
}

class Classic extends Music implements Payable{
	private String composer;
	
	public Classic(String name, int year, String composer){
		super(name, year);
		this.composer= composer;
	}
	public String toString() {
		return "Classic [���=" + name + ", ����=" +year + ", �۰=" + composer + "]";
	}
	public String play() {
		return this.name + "��(��) �����մϴ�.";
	}
}

class Pop extends Music implements Payable{
	private String singer;
	
	public Pop(String name, int year, String singer){
		super(name, year);
		this.singer = singer;
	}
	public String toString() {
		return "Pop [���=" + name + ", ����=" + year + ", ����=" + singer + "]";
	}
	public String play() {
		return this.name + "��(��) �����մϴ�.";
	}
}
