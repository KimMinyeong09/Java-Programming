package Pro10.Lab01;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPhone extends JFrame {
	private JPanel lcdJPanel;
	private JTextArea lcdJTextArea;
	private String lcdOutput = "";
	private JPanel keyJPanel;
	private JButton keyJButton[];

	public MyPhone() {
		setTitle("MyPhone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lcdJTextArea = new JTextArea(3, 15);
		lcdJPanel = new JPanel();
		lcdJPanel.add(lcdJTextArea);

		keyJButton = new JButton[15];
		for (int i = 3; i <= 11; i++) {
			keyJButton[i] = new JButton(Integer.toString(i - 2));
		}
		keyJButton[0] = new JButton("Send");
		keyJButton[1] = new JButton("clr");
		keyJButton[2] = new JButton("End");
		keyJButton[12] = new JButton("*");
		keyJButton[13] = new JButton("0");
		keyJButton[14] = new JButton("#");

		keyJPanel = new JPanel();
		keyJPanel.setLayout(new GridLayout(5, 3));

		for (int i = 0; i <= 14; i++) {
			keyJPanel.add(keyJButton[i]);
			keyJButton[i].addActionListener(new MyActionListener());

		}

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(lcdJPanel);
		contentPane.add(keyJPanel);

		setSize(250, 280);
		setVisible(true);

	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("Send")) {
				lcdOutput = lcdOutput + "\n전화 거는중...\n";
				lcdJTextArea.setText(lcdOutput);
			} 
			else if (b.getText().equals("clr")) {
				if (lcdOutput.length() == 0)
					return;
				else {
					lcdOutput = lcdOutput.substring(0, (lcdOutput.length() - 1));
					lcdJTextArea.setText(lcdOutput);
				}
			} 
			else if (b.getText().equals("End")) {
				lcdJTextArea.setText(" ");
				lcdOutput = "";
			} 
			else {
				lcdOutput += e.getActionCommand();
				lcdJTextArea.setText(lcdOutput);
				
			}
		}
	}
}
