package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import client.controller.OpenCreateGamePanelController;
import client.controller.OpenJoinGamePanelController;

import client.controller.PracticeGameController;
import client.model.Model;

/**
 * The <code>MenuPanel</code> class represents the main menu of the game.
 * 
 * @author Team Pisces
 *
 */
public class MenuPanel extends JPanel {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/**
	 * Create the main menu panel.
	 * 
	 * @param model <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public MenuPanel(Model model, Application application) {
		this.model = model;
		this.app = application;

		setLayout(new GroupLayout(this));
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
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
				new OpenCreateGamePanelController(model, app).process();
			}
		});
		
		JButton btnJoin = new JButton("JOIN");
		btnJoin.setFont(new Font("Tahoma", Font.PLAIN, height/30));
		btnJoin.setBounds(83*height/360, 11*width/80, 7*height/30, 7*width/160);
		add(btnJoin);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpenJoinGamePanelController(app, model).process();
			}
		});
		
		JButton btnPractice = new JButton("PRACTICE");
		btnPractice.setFont(new Font("Tahoma", Font.PLAIN, height/30));
		btnPractice.setBounds(83*height/360, width/5, 7*height/30, 7*width/160);
		add(btnPractice);
		btnPractice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PracticeGameController(model, app).process();
			}
		});
	}
}
