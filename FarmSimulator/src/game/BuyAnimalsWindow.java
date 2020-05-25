package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import animals.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * Buy animals GUI
 * @author Icarus
 *
 */
public class BuyAnimalsWindow {
	/**
	 * Game object
	 */
	private GameGUI game;
	
	private JFrame frame;
	//JTextField
	private JTextField numAnimals;
	//JLabels
	private JLabel displayPrice;
	private JLabel displayBonus;
	private JLabel displayMoney;

	/**
	 * Create the application.
	 * @param game Game object
	 */
	public BuyAnimalsWindow(GameGUI game) {
		this.game = game;
		initialize();
	}
	/**
	 * Refresh the displayed money value.
	 */
	public void refreshMoney() {
		displayMoney.setText(String.format("$%.2f", game.getFarm().getFarmMoney().getMoneyAmount()));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setFrame(frame);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("Animal Store");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		String[] animals = new String[] {"Select Animal", "Chicken", "Pig", "Cow"};
		JComboBox<String> selectAnimal = new JComboBox(animals) ;
		selectAnimal.setToolTipText("Select the animal you would like to view");
		selectAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeAnimal(animals[selectAnimal.getSelectedIndex()]);
			}
		});
		
		JButton buyAnimal = new JButton("Buy ");
		buyAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String animal = (String) selectAnimal.getSelectedItem();
				if (animal == "Select Animal") {
					JOptionPane.showMessageDialog(null, "Select an animal to buy");
				} else {
					int num = 0;
					try {
						num = Integer.parseInt(numAnimals.getText());
						try {
							game.buyAnimals(animal, num);
							refreshMoney();
							if (num == 1) {
								JOptionPane.showMessageDialog(null,  "Bought " + num + " " + animal);
							} else {
								JOptionPane.showMessageDialog(null,  "Bought " + num + " " + animal + "s");
							}
							
						} catch (IllegalStateException exc) {
							JOptionPane.showMessageDialog(null, exc.getMessage());
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Enter a number");
					}
				}
			}
		});
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JLabel animalPrice = new JLabel("Animal Price:");
		animalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel animalBonus = new JLabel("Daily Bonus Received:");
		animalBonus.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayPrice = new JLabel("Select Animal");
		
		displayBonus = new JLabel("Select Animal");		
		
		numAnimals = new JTextField();
		numAnimals.setColumns(10);
		
		JLabel quantityPrompt = new JLabel("Enter Quantity:");
		quantityPrompt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayMoney = new JLabel("New label");
		displayMoney.setText(String.format("$%.2f", game.getFarm().getFarmMoney().getMoneyAmount()));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(quantityPrompt, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numAnimals, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buyAnimal, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(exit))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(animalPrice, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addComponent(animalBonus, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(displayBonus, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
										.addComponent(displayPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(selectAnimal, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(148)
									.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(displayMoney, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(displayMoney))
					.addGap(18)
					.addComponent(selectAnimal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(animalPrice)
						.addComponent(displayPrice))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(animalBonus)
						.addComponent(displayBonus))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buyAnimal)
						.addComponent(exit)
						.addComponent(numAnimals, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(quantityPrompt))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void changeAnimal(String string) {
		Animals animal;
		switch(string) {
		case "Chicken":
			animal = new Chicken();
			break;
		case "Pig":
			animal = new Pig();
			break;
		case "Cow":
			animal = new Cow();
			break;
		case "Select Animal":
			displayPrice.setText("Select Animal");
			displayBonus.setText("Select Animal");
			return;
		default:
			return;
		}
		displayPrice.setText(String.valueOf(animal.getBuyPrice()));
		displayBonus.setText(String.valueOf(animal.getDailyEarnings()));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
