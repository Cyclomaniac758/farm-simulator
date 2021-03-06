package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import farm.*;
import farmer.*;
import java.awt.Color;

/**
 * 2nd start window GUI
 * @author Icarus
 *
 */
public class StartWindow2 {

	private JFrame frame;
	private JTextField textField;
	//JButtons
	private JButton familyFarmButton;
	private JButton commercialFarmButton;
	private JButton livestockFarmButton;
	private JButton cropFarmButton;
	/**
	 * Farmer object variable
	 */
	private Farm farm;
	/**
	 * Game object variable
	 */
	private GameGUI game;
	/**
	 * Game length variable
	 */
	private int gameLength;
	/**
	 * Farmer name variable
	 */
	private String farmerName;
	/**
	 * Farmer age variable
	 */
	private int farmerAge;
	/**
	 * Farm name variable
	 */
	private String farmName;
	/**
	 * Boolean whether a farm type has been selected
	 */
	private boolean farmTypeChosen;


	/**
	 * Create the object
	 * @param game Game object
	 * @param length Length of the game
	 * @param farmersName Name of the user
	 * @param farmersAge Age of the user
	 */
	public StartWindow2(GameGUI game, int length, String farmersName, int farmersAge) {
		this.game = game;
		gameLength = length;
		farmerName = farmersName;
		farmerAge = farmersAge;
		farmTypeChosen = false;
		initialize();
	}
	/**
	 *Start the main game
	 */
	public void startGame() {
		game = new GameGUI();
		game.setFarm(farm);
		Farmer farmer = new Farmer(farmerName, farmerAge, farm);
		game.setFarmer(farmer);
		game.setGameLength(gameLength);
		game.getFarm().setFarmer(farmer);
		game.getFarm().setFarmName(textField.getText());
		game.setHomeWindow(new HomeWindow(game));
	}
	/**
	 * Reset the buttons colors to black
	 */
	public void refreshButtons() {
		familyFarmButton.setForeground(Color.BLACK);
		commercialFarmButton.setForeground(Color.BLACK);
		livestockFarmButton.setForeground(Color.BLACK);
		cropFarmButton.setForeground(Color.BLACK);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(50, 100, 750, 500);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Farm Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(192, 69, 131, 25);
		getFrame().getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(344, 70, 123, 24);
		textField.setToolTipText("Enter your farm's name, must be between 4-16 characters");
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Select Farm Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(298, 159, 123, 25);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		familyFarmButton = new JButton("Family");
		familyFarmButton.setForeground(Color.BLACK);
		familyFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmName = textField.getText();
				farm = new FamilyFarm(farmName);
				farmTypeChosen = true;
				refreshButtons();
				familyFarmButton.setForeground(Color.RED);
			}
		});
		familyFarmButton.setToolTipText("Family\r\nFarm");
		familyFarmButton.setBounds(81, 250, 108, 60);
		getFrame().getContentPane().add(familyFarmButton);
		
		commercialFarmButton = new JButton("Commercial");
		commercialFarmButton.setForeground(Color.BLACK);
		commercialFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmName = textField.getText();
				farm = new CommercialFarm(farmName);
				farmTypeChosen = true;
				refreshButtons();
				commercialFarmButton.setForeground(Color.RED);
			}
		});
		
		commercialFarmButton.setBounds(221, 250, 108, 60);
		getFrame().getContentPane().add(commercialFarmButton);
		
		livestockFarmButton = new JButton("Livestock");
		livestockFarmButton.setForeground(Color.BLACK);
		livestockFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmName = textField.getText();
				farm = new LivestockFarm(farmName);
				farmTypeChosen = true;
				refreshButtons();
				livestockFarmButton.setForeground(Color.RED);
			}
		});
		livestockFarmButton.setBounds(371, 250, 108, 60);
		getFrame().getContentPane().add(livestockFarmButton);
		
		cropFarmButton = new JButton("Crop");
		cropFarmButton.setForeground(Color.BLACK);
		cropFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmName = textField.getText();
				farm = new CropFarm(farmName);
				farmTypeChosen = true;
				refreshButtons();
				cropFarmButton.setForeground(Color.RED);
			}
		});
		cropFarmButton.setBounds(509, 250, 114, 60);
		getFrame().getContentPane().add(cropFarmButton);
		
		JButton farmInfoButton = new JButton("INFO");
		farmInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmInformation window = new FarmInformation();
				window.frame.setVisible(true);
			}
		});
		farmInfoButton.setBounds(526, 160, 91, 26);
		getFrame().getContentPane().add(farmInfoButton);
		
		JButton nextButton = new JButton("Start Game");
		nextButton.setToolTipText("Start the game");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmName = textField.getText();
				if (farmName.length() > 3 && farmName.length() < 17) {
					if (farmTypeChosen == true) {
						startGame();
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Select a farm type");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Farm name must be between 3 and 17 letters");
				}
				
			}
		});
		nextButton.setBounds(285, 340, 136, 23);
		getFrame().getContentPane().add(nextButton);
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
