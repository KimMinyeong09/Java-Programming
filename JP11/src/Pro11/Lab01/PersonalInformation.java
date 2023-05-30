package Pro11.Lab01;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;

class MemberInfor {
	private String name;
	private String tel;
	private String addr;

	MemberInfor(String n, String t, String a) {
		this.name = n;
		this.tel = t;
		this.addr = a;
	}

	String getName() {
		return this.name;
	}

	String getTel() {
		return this.tel;
	}

	String getAddr() {
		return this.addr;
	}

	void setTel(String s) {
		this.tel = s;
	}

	void setAddr(String s) {
		this.addr = s;
	}
}

public class PersonalInformation extends JFrame {
	HashMap<String, MemberInfor> dic = new HashMap<String, MemberInfor>();
	private int num = 0;
	private static String name = "";
	private String idPre = "", idBack = "";
	private String tel = "";
	private String addr = "";
	private JPanel inform, check, checkTop, checkBot;
	private JTextArea checkTextArea;
	private JTextField nameTextField, idPreTextField, idBackTextField, telTextField, addTextField;
	private JButton outputButton;
	private JButton keyButton[];
	String[] totalMember = new String[100];
	JFrame f = this;
	ShowDialog d1 = new ShowDialog(f, "����");
	ShowModify d2 = new ShowModify(f, name, idPre, idBack);
	ShowDialog d3 = new ShowDialog(f, "����");

	public PersonalInformation() {
		setTitle("����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		nameTextField = new JTextField(13);
		nameTextField.addKeyListener(new MyKeyListener());
		idPreTextField = new JTextField(6);
		idPreTextField.addKeyListener(new MyKeyListener());
		idBackTextField = new JTextField(6);
		idBackTextField.addKeyListener(new MyKeyListener());
		telTextField = new JTextField(13);
		telTextField.addKeyListener(new MyKeyListener());
		addTextField = new JTextField(13);
		addTextField.addKeyListener(new MyKeyListener());

		inform = new JPanel(new GridBagLayout());
		TitledBorder oneTb = new TitledBorder(new BevelBorder(BevelBorder.RAISED), "��������");
		inform.setBorder(oneTb);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 0.5;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JLabel nameLabel = new JLabel("�̸�: ");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		inform.add(nameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		inform.add(nameTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JLabel IDLabel = new JLabel("�ֹι�ȣ: ");
		IDLabel.setHorizontalAlignment(JLabel.RIGHT);
		inform.add(IDLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		inform.add(idPreTextField, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		inform.add(idBackTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JLabel telLabel = new JLabel("��ȭ��ȣ: ");
		telLabel.setHorizontalAlignment(JLabel.RIGHT);
		inform.add(telLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		inform.add(telTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JLabel addrLabel = new JLabel("�ּ�: ");
		addrLabel.setHorizontalAlignment(JLabel.RIGHT);
		inform.add(addrLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		inform.add(addTextField, gbc);

		checkTop = new JPanel();
		checkTop.setLayout(new BorderLayout());
		JPanel temp = new JPanel();
		outputButton = new JButton("��ü����");
		outputButton.addActionListener(new MyActionListener());
		temp.add(outputButton);
		temp.add(new JLabel("<== �̰��� ������ ��ü���Ⱑ �˴ϴ�."));
		checkTop.add(temp, BorderLayout.WEST);

		checkBot = new JPanel();
		keyButton = new JButton[4];
		keyButton[0] = new JButton("���");
		keyButton[1] = new JButton("����");
		keyButton[2] = new JButton("����");
		keyButton[3] = new JButton("����");
		for (int i = 0; i < 4; i++) {
			checkBot.add(keyButton[i]);
			keyButton[i].addActionListener(new MyActionListener());
		}

		check = new JPanel();
		TitledBorder twoTb = new TitledBorder(new BevelBorder(BevelBorder.RAISED), "��������Ȯ��");
		check.setBorder(twoTb);
		check.setLayout(new BorderLayout());
		check.add(checkTop, BorderLayout.NORTH);
		checkTextArea = new JTextArea(13, 33);
		check.add(checkTextArea, BorderLayout.CENTER);
		check.add(new JScrollPane(checkTextArea));
		check.add(checkBot, BorderLayout.SOUTH);

		contentPane.add(inform);
		contentPane.add(check);

		super.pack();
		setVisible(true);

		checking();
		nameTextField.requestFocus();
	}

	class ShowDialog extends JDialog {
		JTextField tf1 = new JTextField(13);
		JTextField tf2 = new JTextField(6);
		JTextField tf3 = new JTextField(6);
		JButton b1;
		JButton b2 = new JButton("���");

		public ShowDialog(JFrame f, String s) {
			super(f, s);
			b1 = new JButton(s);
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			
			p1.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 0.5;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			JLabel nameLabel = new JLabel("�̸�: ");
			nameLabel.setHorizontalAlignment(JLabel.RIGHT);
			p1.add(nameLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			p1.add(tf1, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			JLabel IDLabel = new JLabel("�ֹι�ȣ: ");
			IDLabel.setHorizontalAlignment(JLabel.RIGHT);
			p1.add(IDLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			p1.add(tf2, gbc);

			gbc.gridx = 2;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			p1.add(tf3, gbc);
			
			p2.add(b1);
			p2.add(b2);
			
			p3.setLayout(new BorderLayout());
			
			p3.add(p1, BorderLayout.CENTER);
			p3.add(p2, BorderLayout.SOUTH);
			
			b1.addActionListener(new MyActionListener());
			b2.addActionListener(new MyActionListener());
			tf2.addKeyListener(new MyKeyListener());

			add(p3);
			setSize(250, 130);
			
		}
	}

	class ShowModify extends JDialog {
		String name, idpre, idback;
		JTextField tf1 = new JTextField(13);
		JTextField tf2 = new JTextField(13);
		JButton b1 = new JButton("����");
		JButton b2 = new JButton("���");

		public ShowModify(JFrame f, String s1, String s2, String s3) {
			super(f, "����");

			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			
			p1.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 0.5;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			JLabel nameLabel1 = new JLabel("�̸�: ");
			nameLabel1.setHorizontalAlignment(JLabel.RIGHT);
			p1.add(nameLabel1, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			JLabel nameLabel2 = new JLabel(s1);
			p1.add(nameLabel2, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			JLabel IDLabel1 = new JLabel("�ֹι�ȣ: ");
			IDLabel1.setHorizontalAlignment(JLabel.RIGHT);
			p1.add(IDLabel1, gbc);

			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			JLabel IDLabel2 = new JLabel(s2 + "-" + s3);
			p1.add(IDLabel2, gbc);

			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			JLabel telLabel = new JLabel("��ȭ��ȣ: ");
			telLabel.setHorizontalAlignment(JLabel.RIGHT);
			p1.add(telLabel, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			p1.add(tf1, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			JLabel addrLabel = new JLabel("�ּ�: ");
			addrLabel.setHorizontalAlignment(JLabel.RIGHT);
			p1.add(addrLabel, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			p1.add(tf2, gbc);
			
			p2.add(b1);
			p2.add(b2);
			
			p3.setLayout(new BorderLayout());
			
			p3.add(p1, BorderLayout.CENTER);
			p3.add(p2, BorderLayout.SOUTH);

			this.name = s1;
			this.idpre = s2;
			this.idback = s3;

			b1.addActionListener(new MyActionListener());
			b2.addActionListener(new MyActionListener());
			tf1.addKeyListener(new MyKeyListener());
			tf2.addKeyListener(new MyKeyListener());

			add(p3);
			setSize(250, 200);
			
		}
	}

	public void checking() {
		String s1 = nameTextField.getText().trim();
		String s2 = idPreTextField.getText().trim();
		String s3 = idBackTextField.getText().trim();
		String s4 = telTextField.getText().trim();
		String s5 = addTextField.getText().trim();

		if ((s1.length() != 0) && (s2.length() != 0) && (s3.length() != 0) && (s4.length() != 0)
				&& (s5.length() != 0)) {
			keyButton[0].setEnabled(true);
		} 
		else if ((s1.length() != 0) || (s2.length() != 0) || (s3.length() != 0) || (s4.length() != 0)
				|| (s5.length() != 0)) {
			keyButton[0].setEnabled(false);
			keyButton[3].setEnabled(true);
		}
		else {
			keyButton[0].setEnabled(false);
			keyButton[3].setEnabled(false);
		}
	}
	
	public void checkingModify() {
		String s1 = d2.tf1.getText().trim();
		String s2 = d2.tf2.getText().trim();

		if ((s1.length() != 0) && (s2.length() != 0)) {
			d2.b1.setEnabled(true);
		} 
		else {
			d2.b1.setEnabled(false);
		}
	}

	class MyFocusListener implements FocusListener {
		public void focusGained(FocusEvent e) {}
		public void focusLost(FocusEvent fe) {}
	}

	class MyKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {}

		public void keyReleased(KeyEvent e) {
			if (e.getSource() == nameTextField) {
				checking();
			} else if (e.getSource() == idPreTextField) {
				String str = idPreTextField.getText().trim();
				if (str.length() == 6) {
					idBackTextField.requestFocus();
				}
				checking();
				
			} else if (e.getSource() == idBackTextField) {
				String str = idBackTextField.getText().trim();
				if (str.length() == 7) {
					telTextField.requestFocus();
				}
				checking();
			}

			else if (e.getSource() == telTextField) {
				checking();
			}

			else if (e.getSource() == addTextField) {
				checking();
			}

			else if (e.getSource() == d1.tf2) {
				String str = d1.tf2.getText().trim();
				if (str.length() == 6) {
					d1.tf3.requestFocus();
				}
			}

			else if (e.getSource() == d3.tf2) {
				String str = d3.tf2.getText().trim();
				if (str.length() == 6) {
					d3.tf3.requestFocus();
				}
			}
			
			else if (e.getSource() == d2.tf1) {
				checkingModify();
			}
			
			else if (e.getSource() == d2.tf2) {
				checkingModify();
			}
		}
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("���")) {
				name = nameTextField.getText();
				idPre = idPreTextField.getText();
				idBack = idBackTextField.getText();
				tel = telTextField.getText();
				addr = addTextField.getText();
				if (idPre.length() == 6 && idBack.length() == 7) {
					if (dic.containsKey(idPre + idBack)) {
						MemberInfor temp = dic.get(idPre + idBack);
						if (temp.getName().equals(name)) {
							String error = "�̹� ��ϵǾ��ִ� ����Դϴ�.\n";
							checkTextArea.setText(error);
						} else {
							String error = "�̹� ��ϵǾ��ִ� �ֹι�ȣ�Դϴ�.\n";
							checkTextArea.setText(error);
						}
					} else {
						MemberInfor m = new MemberInfor(name, tel, addr);
						dic.put(idPre + idBack, m);
						num++;
						String guide = "������ �� �Ǿ����ϴ�.\n";
						checkTextArea.setText(guide);
					}
				}
				else {
					String error = "�߸��� ������ �ֹι�ȣ�Դϴ�..\n";
					checkTextArea.setText(error);
				}
				String numGuide = "���� �� " + num + "���� �����Ͱ� �����մϴ�.\n";
				checkTextArea.append(numGuide);
				nameTextField.setText("");
				idPreTextField.setText("");
				idBackTextField.setText("");
				telTextField.setText("");
				addTextField.setText("");
				nameTextField.requestFocus();
				checking();
			}

			else if (e.getSource() == keyButton[1]) {
				d1.setVisible(true);
				d1.tf1.setText("");
				d1.tf2.setText("");
				d1.tf3.setText("");
				d1.tf1.requestFocus();
				checking();
			}

			else if (e.getSource() == d1.b1) {
				name = d1.tf1.getText();
				idPre = d1.tf2.getText();
				idBack = d1.tf3.getText();
				if (dic.containsKey(idPre + idBack)) {
					MemberInfor temp = dic.get(idPre + idBack);
					if (temp.getName().equals(name)) {
						String guide = "�ش� ����ڸ� ã�ҽ��ϴ�. �����ϼ���.\n";
						checkTextArea.setText(guide);
						d2 = new ShowModify(f, name, idPre, idBack);
						d2.setVisible(true);
						d2.tf1.setText("");
						d2.tf2.setText("");
						d2.tf1.requestFocus();
						d1.setVisible(false);
					} else {
						String error = "�������� �ʴ� ���������Դϴ�.\n";
						checkTextArea.setText(error);
						d1.tf1.requestFocus();
					}
				} else {
					String error = "�������� �ʴ� ���������Դϴ�.\n";
					checkTextArea.setText(error);
					d1.tf1.requestFocus();
				}
				String numGuide = "���� �� " + num + "���� �����Ͱ� �����մϴ�.\n";
				checkTextArea.append(numGuide);
				d1.tf1.setText("");
				d1.tf2.setText("");
				d1.tf3.setText("");
				checking();
				checkingModify();
			}

			else if (e.getSource() == d1.b2) {
				d1.setVisible(false);
				String numGuide = "������ ����߽��ϴ�.\n���� �� " + num + "���� �����Ͱ� �����մϴ�.\n";
				checkTextArea.setText(numGuide);
				nameTextField.requestFocus();
				checking();
			}

			else if (e.getSource() == d2.b1) {
				String changeTel = d2.tf1.getText();
				String changeAddr = d2.tf2.getText();
				MemberInfor temp = dic.get(d2.idpre + d2.idback);
				temp.setTel(changeTel);
				temp.setAddr(changeAddr);
				dic.replace(d2.idpre + d2.idback, temp);
				checkTextArea.setText("������ �Ϸ�Ǿ����ϴ�.\n");
				String numGuide = "���� �� " + num + "���� �����Ͱ� �����մϴ�.\n";
				checkTextArea.append(numGuide);
				d2.setVisible(false);
				nameTextField.requestFocus();
				checking();
			}

			else if (e.getSource() == d2.b2) {
				d2.setVisible(false);
				String numGuide = "������ ����߽��ϴ�.\n���� �� " + num + "���� �����Ͱ� �����մϴ�.\n";
				checkTextArea.setText(numGuide);
				nameTextField.requestFocus();
				checking();
			}

			else if (e.getSource() == keyButton[2]) {
				d3.setVisible(true);
				d3.tf1.setText("");
				d3.tf2.setText("");
				d3.tf3.setText("");
				d3.tf1.requestFocus();
				checking();
			}

			else if (e.getSource() == d3.b1) {
				name = d3.tf1.getText();
				idPre = d3.tf2.getText();
				idBack = d3.tf3.getText();
				if (dic.containsKey(idPre + idBack)) {
					MemberInfor temp = dic.get(idPre + idBack);
					if (temp.getName().equals(name)) {
						dic.remove(idPre + idBack);
						String guide = "������ ����ڸ� ������ ����ҿ��� �����Ͽ����ϴ�.\n���� !!!\n";
						checkTextArea.setText(guide);
						num--;
						checkTextArea.append("�̸�: " + name + "\n");
						checkTextArea.append("�ֹι�ȣ: " + idPre + "-" + idBack + "\n");
						d3.setVisible(false);
						nameTextField.requestFocus();

					} else {
						String error = "�������� �ʴ� ���������Դϴ�.\n";
						checkTextArea.setText(error);
						d3.tf1.requestFocus();
					}
				} else {
					String error = "�������� �ʴ� ���������Դϴ�.\n";
					checkTextArea.setText(error);
					d3.tf1.requestFocus();
				}
				String numGuide = "���� ���� �������� ����: " + num + "��\n";
				checkTextArea.append(numGuide);
				d3.tf1.setText("");
				d3.tf2.setText("");
				d3.tf3.setText("");
				checking();
			}

			else if (e.getSource() == d3.b2) {
				d3.setVisible(false);
				String numGuide = "������ ����߽��ϴ�.\n���� �� " + num + "���� �����Ͱ� �����մϴ�.\n";
				checkTextArea.setText(numGuide);
				nameTextField.requestFocus();
				checking();
			}

			else if (e.getSource() == keyButton[3]) {
				System.exit(0);
			}

			else if (e.getSource() == outputButton) {
				checkTextArea.setText("��ü �ο��� ���������Դϴ�.\n");
				String s1 = String.format("%-15s %-29s %-21s %s\n", "�̸�", "�ֹι�ȣ", "��ȭ��ȣ", "�ּ�");
				checkTextArea.append(s1);
				checkTextArea.append("===================================================\n");

				Set<String> keys = dic.keySet();
				Iterator<String> it = keys.iterator();
				while (it.hasNext()) {
					String key = it.next();
					MemberInfor value = dic.get(key);
					String s2 = String.format("%-12s %-23s %-18s %s\n", value.getName(), key, value.getTel(),
							value.getAddr());
					checkTextArea.append(s2);
				}
				checkTextArea.append("===================================================\n");

				String numGuide = "�� " + num + "��\n";
				checkTextArea.append(numGuide);
				nameTextField.requestFocus();
				checking();
			}
		}

	}
}
