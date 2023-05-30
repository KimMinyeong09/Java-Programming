package Pro12.Lab01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Report12 extends JFrame {
	Report12() {
		super("쓰레드를 가진 겜블링");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel());
		setSize(300, 200);
		setVisible(true);
	}

	class GamePanel extends JPanel {
		JLabel[] label = new JLabel[3];
		JLabel result = new JLabel("마우스를 클릭할 때마다 게임합니다.");
		GamblingThread thread = new GamblingThread(label, result);

		public GamePanel() {
			setLayout(null);
			for (int i = 0; i < label.length; i++) {
				label[i] = new JLabel("0");
				label[i].setSize(60, 30);
				label[i].setLocation(30 + 80 * i, 50);
				label[i].setHorizontalAlignment(JLabel.CENTER);
				label[i].setOpaque(true);
				label[i].setBackground(Color.MAGENTA);
                label[i].setForeground(Color.YELLOW);
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
				add(label[i]);
			}
			result.setHorizontalAlignment(JLabel.CENTER);
			result.setSize(250, 20);
			result.setLocation(30, 120);
			add(result);
			thread.start();
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if ((thread).isReady())
						thread.startGambling();
				}
			});
		}
	}

	class GamblingThread extends Thread {
		JLabel[] label;
		JLabel result;
		long delay = 200;
		boolean gambling = false;

		public GamblingThread(JLabel[] label, JLabel result) {
			this.label = label;
			this.result = result;
		}

		boolean isReady() {
			return !gambling;
		}

		synchronized public void waitForGambling() {
			if (!gambling) {
				try {
					this.wait();
				} 
				catch (InterruptedException e) {
					return;
				}
			}

		}

		synchronized public void startGambling() {
			gambling = true;
			this.notify();
		}

		public void run() {
			while (true) {
				waitForGambling();
				try {
					int x1 = (int) (Math.random() * 5);
					int x2 = (int) (Math.random() * 5);
					int x3 = (int) (Math.random() * 5);

					label[0].setForeground(Color.BLACK);
					sleep(delay);
					label[0].setForeground(Color.YELLOW);
					label[0].setText(Integer.toString(x1));

					label[1].setForeground(Color.BLACK);
					sleep(delay);
					label[1].setForeground(Color.YELLOW);
					label[1].setText(Integer.toString(x2));

					label[2].setForeground(Color.BLACK);
					sleep(delay);
					label[2].setForeground(Color.YELLOW);
					label[2].setText(Integer.toString(x3));

					if (x1 == x2 && x2 == x3)
						result.setText("축하합니다!!");
					else
						result.setText("아쉽군요");
					gambling = false;
				} catch (InterruptedException e) {
					return;
				}
			}

		}
	}

	public static void main(String[] args) {
		new Report12();
	}

}
