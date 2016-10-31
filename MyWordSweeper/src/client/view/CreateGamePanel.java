package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.controller.CreateGameController;
import client.controller.ReturnToMenuController;
import client.model.Model;

public class CreateGamePanel extends JPanel{
	Model model;
	Application application;
	JTextField textFieldNN;
	JTextField textFieldPW;
	ButtonGroup modeBtnGroup;
	JRadioButton rdbtnPublic;
	JRadioButton rdbtnPrivate;
	
	public CreateGamePanel (Model model, Application application) {
		this.model = model;
		this.application = application;
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		
		textFieldNN = new JTextField();
		textFieldNN.setToolTipText("A default name will be assigned if it's empty.");
		textFieldNN.setFont(new Font("Times New Roman", Font.PLAIN, height/36));
		textFieldNN.setBounds(21*width/160, 3*height/20, 3*width/16, height/20);
		add(textFieldNN);
		
		textFieldPW = new JTextField();
		textFieldPW.setEditable(false);
		textFieldPW.setFont(new Font("Times New Roman", Font.PLAIN, height/36));
		textFieldPW.setBounds(21*width/160, 11*height/36, 3*width/16, height/20);
		add(textFieldPW);
		
		rdbtnPublic = new JRadioButton("Public", true);
		rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, height/45));
		rdbtnPublic.setBounds(21*width/160, 41*height/180, 5*width/64, height/45);
		rdbtnPublic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPW.setEditable(false);
				textFieldPW.setText("");
			}
		});
		
		rdbtnPrivate = new JRadioButton("Private", false);
		rdbtnPrivate.setFont(new Font("Tahoma", Font.PLAIN, height/45));
		rdbtnPrivate.setBounds(21*width/160, 47*height/180, 5*width/64, height/45);
		rdbtnPrivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPW.setEditable(true);
			}
		});
		
		modeBtnGroup = new ButtonGroup();
		modeBtnGroup.add(rdbtnPublic);
		modeBtnGroup.add(rdbtnPrivate);
		add(rdbtnPublic);
		add(rdbtnPrivate);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;

		JLabel lblCreateNewGame = new JLabel("Create New Game");
		lblCreateNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewGame.setFont(new Font("Times New Roman", Font.BOLD, 7*height/180));
		lblCreateNewGame.setBounds(3*width/32, height/36, 3*width/16, height/18);
		add(lblCreateNewGame);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lblNickname.setBounds(3*width/80, 3*height/20, width/10, height/20);
		add(lblNickname);
		
		JLabel lblMode = new JLabel("Mode:");
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblMode.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lblMode.setBounds(3*width/80, 41*height/180, width/10, height/20);
		add(lblMode);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lblPassword.setBounds(3*width/80, 11*height/36, width/10, height/20);
		add(lblPassword);
		
		JButton btnNewButton = new JButton("GO!");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, height/36));
		btnNewButton.setBounds(3*width/32, 19*height/45, 3*width/32, height/20);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateGameController(model, application).process(textFieldNN.getText(), textFieldPW.getText());
			}
		});
		
		JButton btnCancelButton = new JButton("Cancel");
		btnCancelButton.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		btnCancelButton.setBounds(17*width/80, 19*height/45, 3*width/32, height/20);
		add(btnCancelButton);
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnToMenuController(model, application).process();
			}
		});
	}

	public JTextField getTextFieldNN() {
		return textFieldNN;
	}

	public JTextField getTextFieldPW() {
		return textFieldPW;
	}

	public JRadioButton getRdbtnPublic() {
		return rdbtnPublic;
	}

	public JRadioButton getRdbtnPrivate() {
		return rdbtnPrivate;
	}
}
