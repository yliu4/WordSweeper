package client.view;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import client.controller.*;
import client.model.*;

public class MenuPanel extends JPanel {
	Model model;
	Application application;
	
	public MenuPanel (Model model, Application application) {
		this.model = model;
		this.application = application;
//		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;

		
		JLabel lblWordswepper = new JLabel("WordSwepper");
		lblWordswepper.setFont(new Font("Times New Roman", Font.BOLD, 2*height/45));
		lblWordswepper.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordswepper.setBounds(67*height/360, width/64, 29*height/90, 7*width/160);
		add(lblWordswepper);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, height/30));
		btnCreate.setBounds(83*height/360, 3*width/40, 7*height/30, 7*width/160);
		add(btnCreate);
		
		JButton btnJoin = new JButton("JOIN");
		btnJoin.setFont(new Font("Tahoma", Font.PLAIN, height/30));
		btnJoin.setBounds(83*height/360, 11*width/80, 7*height/30, 7*width/160);
		add(btnJoin);
		
		JButton btnPractice = new JButton("PRACTICE");
		btnPractice.setFont(new Font("Tahoma", Font.PLAIN, height/30));
		btnPractice.setBounds(83*height/360, width/5, 7*height/30, 7*width/160);
		add(btnPractice);
		PracticeGameController practice = new PracticeGameController(model, application);
		btnPractice.addMouseListener(practice);
	}
}
