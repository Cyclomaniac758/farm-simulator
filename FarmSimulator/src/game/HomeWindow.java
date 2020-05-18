package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HomeWindow {

	private JFrame frame;
	private JButton visitStoreButton;
	private JButton viewCropsButton;
	private JButton visiAnimalsButton;
	private JButton visitFarmhouseButton;
	private JButton helpButton;
	private JButton proceedDayButton;
	private JButton btnNewButton;

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

	/**
	 * Create the application.
	 */
	public HomeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		visitStoreButton = new JButton("Visit Store");
		visitStoreButton.setBounds(75, 413, 102, 23);
		frame.getContentPane().add(visitStoreButton);
		
		viewCropsButton = new JButton("View Crops");
		viewCropsButton.setBounds(545, 338, 102, 23);
		frame.getContentPane().add(viewCropsButton);
		
		visiAnimalsButton = new JButton("Visit Animals");
		visiAnimalsButton.setBounds(1220, 489, 159, 23);
		frame.getContentPane().add(visiAnimalsButton);
		
		visitFarmhouseButton = new JButton("Visit Farmhouse");
		visitFarmhouseButton.setBounds(1006, 136, 159, 34);
		frame.getContentPane().add(visitFarmhouseButton);
		
		helpButton = new JButton("Help");
		helpButton.setBounds(10, 11, 121, 42);
		frame.getContentPane().add(helpButton);
		
		proceedDayButton = new JButton("Proceed Day");
		proceedDayButton.setBounds(10, 64, 121, 42);
		frame.getContentPane().add(proceedDayButton);
		
		btnNewButton = new JButton("Tend Land");
		btnNewButton.setBounds(10, 117, 121, 42);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -200, 1600, 900);
		lblNewLabel.setIcon(new ImageIcon(HomeWindow.class.getResource("/img/GUITime.jpg")));
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		
	}

}
