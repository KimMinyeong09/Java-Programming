package Pro06.Lab01;

public class MusicInstance {

	public static void main(String[] args) {
		Music m = new Music("�����", 1700);
		Classic c = new Classic("ĳ��", 1732, "���ۺ�");
		Pop p = new Pop("�ٶ��� �д�", 2004, "�̼Ҷ�");

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
