package game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import farm.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import exceptions.NoMoreActionsException;

import java.awt.Font;

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
	private JLabel dayNumLabel;
	private JLabel displayDay;
	private JButton quitButton;
	private JLabel backgroundPic;
	private JLabel remActionsLabel;
	private JLabel displayActions;



	/**
	 * Create the application.
	 */
	public HomeWindow(GameGUI game) {
		this.game = game;
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
		frame.setBounds(100, 100, 1000, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		viewCropsButton = new JButton("View Crops");
		viewCropsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CropsWindow window = new CropsWindow(game);
				window.getFrame().setVisible(true);
				frame.setVisible(false);;
			}
		});
		viewCropsButton.setBounds(252, 354, 102, 23);
		frame.getContentPane().add(viewCropsButton);
		
		visiAnimalsButton = new JButton("Visit Animals");
		visiAnimalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalsWindow window = new AnimalsWindow(game);
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		visiAnimalsButton.setBounds(643, 492, 159, 23);
		frame.getContentPane().add(visiAnimalsButton);
		
		visitFarmhouseButton = new JButton("Visit Farmhouse");
		visitFarmhouseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmHouseWindow window = new FarmHouseWindow(game, frame);
				frame.setVisible(false);
			}
		});
		visitFarmhouseButton.setBounds(577, 180, 159, 34);
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
				displayDay.setText(String.valueOf(game.getCurrentDay()));
			}
		});
		proceedDayButton.setBounds(10, 64, 121, 42);
		frame.getContentPane().add(proceedDayButton);
		
		btnNewButton = new JButton("Tend Land");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Farm farm = game.getFarm();
					game.tendLand();
					String text = "Farm crop capacity increased to " + farm.getMaxCropCapacity() + "\n" + 
					"Your animals are now " + String.format("%.2f", farm.getAnimalHappinessModifier()) + " times happier";
					JOptionPane.showMessageDialog(null, text);
					displayActions.setText(String.valueOf(game.getActionsRemaining()));
				} catch (NoMoreActionsException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				 
			}
		});
		btnNewButton.setBounds(10, 117, 121, 42);
		frame.getContentPane().add(btnNewButton);
		

		
		visitStoreButton = new JButton("Visit Store");
		visitStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreWindow window = new StoreWindow(game, frame);
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		visitStoreButton.setBounds(66, 537, 111, 23);
		frame.getContentPane().add(visitStoreButton);
		
		dayNumLabel = new JLabel("Day:");
		dayNumLabel.setFont(new Font("STXinwei", Font.PLAIN, 15));
		dayNumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dayNumLabel.setBounds(194, 25, 85, 14);
		frame.getContentPane().add(dayNumLabel);
		
		displayDay = new JLabel("");
		displayDay.setFont(new Font("STXinwei", Font.PLAIN, 15));
		displayDay.setBounds(305, 25, 49, 14);
		displayDay.setText(String.valueOf(game.getCurrentDay()));
		frame.getContentPane().add(displayDay);
		
		quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.endGame();
			}
		});
		quitButton.setBounds(855, 29, 121, 34);
		frame.getContentPane().add(quitButton);
		
		remActionsLabel = new JLabel("Actions Remaining:");
		remActionsLabel.setFont(new Font("STXinwei", Font.PLAIN, 15));
		remActionsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		remActionsLabel.setBounds(141, 46, 138, 23);
		frame.getContentPane().add(remActionsLabel);
		
		displayActions = new JLabel("");
		displayActions.setFont(new Font("STXinwei", Font.PLAIN, 15));
		displayActions.setBounds(305, 50, 49, 14);
		displayActions.setText(String.valueOf(game.getActionsRemaining()));
		frame.getContentPane().add(displayActions);
		
		backgroundPic = new JLabel("New label");
		backgroundPic.setIcon(new ImageIcon(HomeWindow.class.getResource("/img/g3.png")));
		backgroundPic.setBounds(0, 0, 986, 629);
		frame.getContentPane().add(backgroundPic);
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
	}

}
