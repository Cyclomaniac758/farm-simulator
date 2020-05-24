package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;

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

/**
 * First start window GUI
 * @author Icarus
 *
 */
public class StartWindow1 {

	public JFrame frame;
	
	private JTextField nameField;
	private JTextField ageField;
	private JComboBox<String> numDays;
	/**
	 * Game object variable
	 */
	private GameGUI game;


	/**
	 * Create the application.
	 */
	public StartWindow1(GameGUI game) {
		this.game = game;
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
		
		String[] days = new String[] {"Select", "5", "6", "7", "8", "9", "10"};
		JComboBox<String> numDays = new JComboBox(days);
		numDays.setBounds(335, 219, 107, 27);
		frame.getContentPane().add(numDays);
		numDays.setToolTipText("Select the number of days you want the game to last");
		
		
		JButton nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String farmerName = nameField.getText();
				int farmerAge = 0;
				try {
					farmerAge = Integer.parseInt(ageField.getText());
					int gameLength = Integer.parseInt((String) numDays.getSelectedItem());
					if (farmerName.length() > 3 && farmerName.length() < 15 && farmerName.matches("^[a-zA-Z]*$")) {
						StartWindow2 window = new StartWindow2(game, frame, gameLength, farmerName, farmerAge);
						window.getFrame().setVisible(true);
						frame.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null,  "Farmer name must be between 3 and 15 characters long and be composed of alphabet characters","ALERT", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Number missing");
				}
				
				
				
				
				
			}

		});
		nextButton.setBounds(335, 280, 73, 23);
		frame.getContentPane().add(nextButton);
	
	}

	public Window getFrame() {
		return frame;
	}
}
