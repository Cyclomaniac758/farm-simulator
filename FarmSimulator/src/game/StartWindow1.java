package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class StartWindow1 {

	private JFrame frame;
	private JTextField nameField;
	private JTextField ageField;
	private JComboBox<Integer> numDaysBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow1 window = new StartWindow1();
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
	public StartWindow1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel gameNameLabel = new JLabel("Farm Simulator");
		gameNameLabel.setBounds(10, 21, 436, 54);
		gameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameNameLabel.setFont(new Font("Harrington", Font.BOLD, 45));
		gameNameLabel.setLabelFor(frame.getContentPane());
		frame.getContentPane().add(gameNameLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(111, 113, 49, 20);
		frame.getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameLabel.setLabelFor(nameField);
		nameField.setBounds(170, 113, 107, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ageLabel.setBounds(108, 154, 49, 17);
		frame.getContentPane().add(ageLabel);
		
		ageField = new JTextField();
		ageField.setBounds(170, 151, 107, 20);
		frame.getContentPane().add(ageField);
		ageField.setColumns(10);
		
		JLabel lengthLabel = new JLabel("Game Duration (days):");
		lengthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lengthLabel.setBounds(10, 185, 150, 20);
		frame.getContentPane().add(lengthLabel);
		
		JButton nextButton = new JButton("NEXT");
		nextButton.setBounds(170, 216, 73, 23);
		frame.getContentPane().add(nextButton);
		
		Integer[] numDays = {5, 6, 7, 8, 9, 10};
		numDaysBox = new JComboBox(numDays);

		numDaysBox.setBounds(180, 182, 63, 22);
		frame.getContentPane().add(numDaysBox);
	}
}
