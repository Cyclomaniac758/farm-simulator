package game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import farm.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HomeWindow {
	
	private GameGUI game;
	
	private JFrame frame;
	private JButton viewCropsButton;
	private JButton visiAnimalsButton;
	private JButton visitFarmhouseButton;
	private JButton helpButton;
	private JButton proceedDayButton;
	private JButton btnNewButton;
	private JButton visitStoreButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow window = new HomeWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HomeWindow(){
		initialize();
	}

	/**
	 * Create the application.
	 */
	public HomeWindow(GameGUI game) {
		this.game = game;
		Farm farm = game.getFarm();
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		viewCropsButton = new JButton("View Crops");
		viewCropsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CropsWindow window = new CropsWindow(game);
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		viewCropsButton.setBounds(545, 338, 102, 23);
		frame.getContentPane().add(viewCropsButton);
		
		visiAnimalsButton = new JButton("Visit Animals");
		visiAnimalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalsWindow window = new AnimalsWindow();
				//window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		visiAnimalsButton.setBounds(1220, 489, 159, 23);
		frame.getContentPane().add(visiAnimalsButton);
		
		visitFarmhouseButton = new JButton("Visit Farmhouse");
		visitFarmhouseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmHouseWindow window = new FarmHouseWindow();
				frame.dispose();
			}
		});
		visitFarmhouseButton.setBounds(1006, 136, 159, 34);
		frame.getContentPane().add(visitFarmhouseButton);
		
		helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpWindow window = new HelpWindow();
			}
		});
		helpButton.setBounds(10, 11, 121, 42);
		frame.getContentPane().add(helpButton);
		
		proceedDayButton = new JButton("Proceed Day");
		proceedDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.nextDay();
			}
		});
		proceedDayButton.setBounds(10, 64, 121, 42);
		frame.getContentPane().add(proceedDayButton);
		
		btnNewButton = new JButton("Tend Land");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.tendLand();
			}
		});
		btnNewButton.setBounds(10, 117, 121, 42);
		frame.getContentPane().add(btnNewButton);
		

		
		visitStoreButton = new JButton("Visit Store");
		visitStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreWindow window = new StoreWindow(game);
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		visitStoreButton.setBounds(67, 415, 111, 23);
		frame.getContentPane().add(visitStoreButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -200, 1600, 900);
		lblNewLabel.setIcon(new ImageIcon(HomeWindow.class.getResource("/img/GUITime.jpg")));
		frame.getContentPane().add(lblNewLabel);
		

		
		
		
		
		
		
		
		
	}

}
