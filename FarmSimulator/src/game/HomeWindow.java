package game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import farm.*;
import generalStore.GeneralStore;

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

/**
 * Main game window
 * @author Icarus
 *
 */
public class HomeWindow {
	/**
	 * Game object variable
	 */
	private GameGUI game;
	
	private JFrame frame;
	//JButtons
	private JButton viewCropsButton;
	private JButton visitAnimalsButton;
	private JButton visitFarmhouseButton;
	private JButton rulesButton;
	private JButton proceedDayButton;
	private JButton tendLandButton;
	private JButton visitStoreButton;
	private JButton quitButton;
	//JLabels
	private JLabel dayNumLabel;
	private JLabel displayDay;
	private JLabel backgroundPic;
	private JLabel remActionsLabel;
	private JLabel displayActions;
	private JLabel farmerLabel;
	private JLabel displayFarmer;
	private JLabel farmLabel;
	private JLabel displayFarm;
	private JLabel farmTypeLabel;
	private JLabel displayFarmType;
	private JLabel farmMoneyLabel;
	private JLabel displayFarmMoney;


	/**
	 * Create the application
	 * @param game
	 */
	public HomeWindow(GameGUI game) {
		this.game = game;
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Refresh the displayed number of actions remaining
	 */
	public void refreshActions() {
		displayActions.setText(String.valueOf(game.getFarm().getFarmer().getNumActions()));
	}
	/**
	 * Refresh the displayed money value
	 */
	public void refreshMoney() {
		displayFarmMoney.setText(String.format("$%.2f", game.getFarm().getFarmMoney().getMoneyAmount()));
	}
	/**
	 * Proceed to the next day
	 */
	public void proceedDay() {
		double moneyBefore = game.getFarm().getFarmMoney().getMoneyAmount();
		game.nextDay();
		double moneyAfter = game.getFarm().getFarmMoney().getMoneyAmount();
		double moneyGained = moneyAfter - moneyBefore;
		if (game.getCurrentDay() < game.getGameLenth()+1) {
			JOptionPane.showMessageDialog(null, String.format("Day %s\nMoney earned overnight = %.2f", game.getCurrentDay(), moneyGained));
		}
		displayDay.setText(String.valueOf(game.getCurrentDay()));
		refreshActions();
		refreshMoney();
	}
	/**
	 * Try to tend farm land
	 * If farmer has no actions remaining, display error message
	 */
	public void tendLand() {
		try {
			Farm farm = game.getFarm();
			game.tendLand();
			String text = "Farm crop capacity increased to " + farm.getMaxCropCapacity() + "\n" + 
			"Your animals now stay happier for longer"
					+ "\nActions left: " + game.getFarm().getFarmer().getNumActions();
			JOptionPane.showMessageDialog(null, text);
			refreshActions();
		} catch (NoMoreActionsException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 0, 1000, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		viewCropsButton = new JButton("View Crops");
		viewCropsButton.setToolTipText("View the crops on your farm");
		viewCropsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CropsWindow window = new CropsWindow(game);
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		viewCropsButton.setBounds(252, 354, 102, 23);
		frame.getContentPane().add(viewCropsButton);
		
		visitAnimalsButton = new JButton("Visit Animals");
		visitAnimalsButton.setToolTipText("Visit the animals on your farm");
		visitAnimalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalsWindow window = new AnimalsWindow(game);
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		visitAnimalsButton.setBounds(643, 492, 159, 23);
		frame.getContentPane().add(visitAnimalsButton);
		
		visitFarmhouseButton = new JButton("Visit Farmhouse");
		visitFarmhouseButton.setToolTipText("Visit the farmhouse and check your inventory");
		visitFarmhouseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmHouseWindow window = new FarmHouseWindow(game, frame);
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		visitFarmhouseButton.setBounds(577, 180, 159, 34);
		frame.getContentPane().add(visitFarmhouseButton);
		
		rulesButton = new JButton("Rules");
		rulesButton.setToolTipText("View the rules");
		rulesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RulesWindow window = new RulesWindow();
			}
		});
		rulesButton.setBounds(10, 11, 121, 42);
		frame.getContentPane().add(rulesButton);
		
		proceedDayButton = new JButton("Proceed Day");
		proceedDayButton.setToolTipText("Proceed to the next day");
		proceedDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proceedDay();
			}
		});
		proceedDayButton.setBounds(10, 64, 121, 42);
		frame.getContentPane().add(proceedDayButton);
		
		tendLandButton = new JButton("Tend Land");
		tendLandButton.setToolTipText("Tend the land to increase animal happiness and increase crop capacity");
		tendLandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tendLand();
			}
		});
		tendLandButton.setBounds(10, 117, 121, 42);
		frame.getContentPane().add(tendLandButton);
		

		
		visitStoreButton = new JButton("Visit Store");
		visitStoreButton.setToolTipText("Visit the store");
		visitStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreWindow window = new StoreWindow(game, frame, displayFarmMoney);
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
		
		farmerLabel = new JLabel("Farmer:");
		farmerLabel.setFont(new Font("STXinwei", Font.PLAIN, 15));
		farmerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		farmerLabel.setBounds(182, 72, 97, 23);
		frame.getContentPane().add(farmerLabel);
		
		displayFarmer = new JLabel("");
		displayFarmer.setFont(new Font("STXinwei", Font.PLAIN, 15));
		displayFarmer.setBounds(305, 75, 175, 16);
		displayFarmer.setText(String.valueOf(game.getFarmer().getName()));
		frame.getContentPane().add(displayFarmer);
		
		
		farmLabel = new JLabel("Farm:");
		farmLabel.setFont(new Font("STXinwei", Font.PLAIN, 15));
		farmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		farmLabel.setBounds(182, 98, 97, 23);
		frame.getContentPane().add(farmLabel);
		
		displayFarm = new JLabel("");
		displayFarm.setFont(new Font("STXinwei", Font.PLAIN, 15));
		displayFarm.setBounds(305, 101, 250, 16);
		displayFarm.setText(String.valueOf(game.getFarm().getFarmName()));
		frame.getContentPane().add(displayFarm);
		
		farmTypeLabel = new JLabel("Farm Type:");
		farmTypeLabel.setFont(new Font("STXinwei", Font.PLAIN, 15));
		farmTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		farmTypeLabel.setBounds(182, 125, 97, 23);
		frame.getContentPane().add(farmTypeLabel);
		
		displayFarmType = new JLabel("");
		displayFarmType.setFont(new Font("STXinwei", Font.PLAIN, 15));
		displayFarmType.setBounds(305, 128, 250, 16);
		displayFarmType.setText(String.valueOf(game.getFarm().getFarmType()));
		frame.getContentPane().add(displayFarmType);
		
		farmMoneyLabel = new JLabel("Money:");
		farmMoneyLabel.setFont(new Font("STXinwei", Font.PLAIN, 15));
		farmMoneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		farmMoneyLabel.setBounds(468, 25, 87, 14);
		frame.getContentPane().add(farmMoneyLabel);
		
		displayFarmMoney = new JLabel(String.format("$%.2f",game.getFarm().getFarmMoney().getMoneyAmount()));
		displayFarmMoney.setFont(new Font("STXinwei", Font.PLAIN, 15));
		displayFarmMoney.setBounds(577, 25, 85, 14);
		frame.getContentPane().add(displayFarmMoney);
		
		backgroundPic = new JLabel("New label");
		backgroundPic.setIcon(new ImageIcon(HomeWindow.class.getResource("/img/g3.png")));
		backgroundPic.setBounds(0, 0, 986, 629);
		frame.getContentPane().add(backgroundPic);
	}
}
