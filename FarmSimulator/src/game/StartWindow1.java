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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import farmer.*;

public class StartWindow1 {

	private JFrame frame;
	
	private JTextField nameField;
	private JTextField ageField;
	private JComboBox<Integer> numDays;
	
	private GameGUI game;
	private Farmer farmer;

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
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel gameNameLabel = new JLabel("Farm Simulator");
		gameNameLabel.setBounds(165, 21, 436, 54);
		gameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameNameLabel.setFont(new Font("Harrington", Font.BOLD, 45));
		gameNameLabel.setLabelFor(frame.getContentPane());
		frame.getContentPane().add(gameNameLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(274, 113, 49, 20);
		frame.getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameLabel.setLabelFor(nameField);
		nameField.setToolTipText("Type in your farmer's name, must be between 3-12 characters long");
		nameField.setBounds(335, 113, 107, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ageLabel.setBounds(274, 167, 49, 17);
		frame.getContentPane().add(ageLabel);
		
		ageField = new JTextField();
		ageField.setToolTipText("Type in your farmer's age in years");
		ageField.setBounds(335, 165, 107, 20);
		frame.getContentPane().add(ageField);
		ageField.setColumns(10);
		
		JLabel lengthLabel = new JLabel("Game Duration (days):");
		lengthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lengthLabel.setBounds(173, 221, 150, 20);
		frame.getContentPane().add(lengthLabel);
		
		numDays = new JComboBox<Integer>();
		numDays.setBounds(335, 219, 107, 27);
		frame.getContentPane().add(numDays);
		
		numDays.setToolTipText("Select the number of days you want the game to last");
		numDays.setModel(new DefaultComboBoxModel(new Integer[] {5, 6, 7, 8, 9, 10}));
		
		
		JButton nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer gameLength = (Integer) numDays.getSelectedItem();
				String farmerName = nameField.getText();
				Integer farmerAge = Integer.parseInt(ageField.getText());
				
				if (farmerName.length() > 2 && farmerName.length() < 13) {
					StartWindow2 window = new StartWindow2(game, frame, gameLength, farmerName, farmerAge);
					window.getFrame().setVisible(true);
					frame.setVisible(false);
					
				}
				
				
			}

		});
		nextButton.setBounds(335, 280, 73, 23);
		frame.getContentPane().add(nextButton);
	
	}
}
