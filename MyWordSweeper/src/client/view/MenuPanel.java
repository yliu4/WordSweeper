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
	 * @param m <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public MenuPanel(Model m, Application application) {
		this.model = m;
		this.app = application;

		setLayout(new GroupLayout(this));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 180;
		int width = d.width / 32;
		
		JLabel lblWordswepper = new JLabel("WordSwepper");
		lblWordswepper.setFont(new Font("Times New Roman", Font.BOLD, 8*height));
		lblWordswepper.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordswepper.setBounds(3*width, 5*height, 6*width, 14*height);
		add(lblWordswepper);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 6*height));
		btnCreate.setBounds(4*width, 24*height, 4*width, 14*height);
		add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpenCreateGamePanelController(model, app).process();
			}
		});
		
		JButton btnJoin = new JButton("JOIN");
		btnJoin.setFont(new Font("Tahoma", Font.PLAIN, 6*height));
		btnJoin.setBounds(4*width, 44*height, 4*width, 14*height);
		add(btnJoin);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpenJoinGamePanelController(app, model).process();
			}
		});
		
		JButton btnPractice = new JButton("PRACTICE");
		btnPractice.setFont(new Font("Tahoma", Font.PLAIN, 6*height));
		btnPractice.setBounds(4*width, 64*height, 4*width, 14*height);
		add(btnPractice);
		btnPractice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PracticeGameController(model, app).process();
			}
		});
	}
}
