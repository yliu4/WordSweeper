package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import client.controller.OpenCreateGamePanelController;
import client.controller.PracticeGameController;
import client.model.Model;

/**
 * The <code>MenuPanel</code> class represents the main menu of the game.
 * 
 * @author Team Pisces
 *
 */
public class MenuPanel extends JPanel {
	Model model;
	Application application;
	
	public MenuPanel (Model model, Application application) {
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
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpenCreateGamePanelController(model, application).process();
			}
		});
		
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
