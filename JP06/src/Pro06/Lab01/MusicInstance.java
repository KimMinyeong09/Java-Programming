package Pro06.Lab01;

public class MusicInstance {

	public static void main(String[] args) {
		Music m = new Music("흥부전", 1700);
		Classic c = new Classic("캐논", 1732, "파핼벨");
		Pop p = new Pop("바람이 분다", 2004, "이소라");

		Music[] musics = new Music[3];
		musics[0] = m; musics[1] = c; musics[2] = p;
		
		for  (int i =0; i<musics.length; i++) {
			System.out.println(musics[i]);
			if (musics[i] instanceof Classic) {
				Classic cl = (Classic) musics[i];
				System.out.println(cl.getComposer());
			}
			else if (musics[i] instanceof Pop) {
				Pop po = (Pop) musics[i];
				System.out.println(po.getSinger());
			}
		}
		
		for (int i =0; i<musics.length; i++) {
				System.out.println(musics[i].getClass().getName());
		}
	}

}
