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
		return "Music [곡명=" + name + ", 연도=" + year + "]";
	}
	
}

class Classic extends Music implements Payable{
	private String composer;
	
	public Classic(String name, int year, String composer){
		super(name, year);
		this.composer= composer;
	}
	public String toString() {
		return "Classic [곡명=" + name + ", 연도=" +year + ", 작곡가=" + composer + "]";
	}
	public String play() {
		return this.name + "을(를) 연주합니다.";
	}
}

class Pop extends Music implements Payable{
	private String singer;
	
	public Pop(String name, int year, String singer){
		super(name, year);
		this.singer = singer;
	}
	public String toString() {
		return "Pop [곡명=" + name + ", 연도=" + year + ", 가수=" + singer + "]";
	}
	public String play() {
		return this.name + "을(를) 연주합니다.";
	}
}
