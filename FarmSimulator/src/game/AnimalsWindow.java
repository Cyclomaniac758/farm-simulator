package game;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import animals.*;
import exceptions.NoMoreActionsException;
import items.*;

public class AnimalsWindow {

	private JFrame frame;
	private JComboBox<Animals> selectAnimal;
	private JComboBox<item> selectItem;
	
	
	private GameGUI game;
	private JLabel displayHealthiness;
	private JLabel displayHappiness;
	private JLabel displayItemImpact;

	/**
	 * Create the application.
	 * @param game 
	 */
	public AnimalsWindow(GameGUI game) {
		this.game = game;
		initialize();
	}
	
	/**
	 * Refreshes the values of displayTotalGrowTime and displayRemainingDays.
	 */
	public void changeAnimal(Animals animal) {
		try {
			double num = animal.getHappinessLevel() * game.getFarm().getAnimalHappinessModifier();
			double num2 = animal.getHealthiness() * game.getFarm().getAnimallHealthinessModifier();
			if (num > 1) {
				num = 1;
			} else if (num2 > 1) {
				num2 = 1;
			}
			displayHappiness.setText(String.format("%.2f", num));
			displayHealthiness.setText(String.format("%.2f", num2));
		} catch (NullPointerException e) {
			displayHappiness.setText("Select Animal");
			displayHealthiness.setText("Select Animal");
		}
		
	}
	
	/**
	 * Refreshes the values of
	 * @param item
	 */
	public void changeItem(item item) {
		try {
			displayItemImpact.setText(item.getItemUse());
		} catch (NullPointerException e) {}
	}
	
	
	/**
	 * Refresh the selectAnimal JCombobox
	 */
	public void refreshAnimals() {
		selectAnimal.removeAllItems();
		for (Animals animal: game.getFarm().getAnimalList()) {
			selectAnimal.addItem(animal);
		}
	}
	
	/**
	 * Refresh the selectItem JComboBox
	 */
	public void refreshItems() {
		selectItem.removeAllItems();
		for (item item: game.getFarm().getItemList()) {
			if (item instanceof Food) {
				selectItem.addItem(item);
			}
		}
	}
	
	public boolean checkAllHappy() {
		boolean result = true;
		for (Animals animal: game.getFarm().getAnimalList()) {
			if (animal.getHappinessLevel() < 1) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1000, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("Animals");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("STFangsong", Font.PLAIN, 45));
		
		JLabel happinessLabel = new JLabel("Animal happiness:");
		happinessLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayHappiness = new JLabel("Select Animal");
		
		JLabel animalHealthinessLabel = new JLabel("Animal healthiness:");
		animalHealthinessLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayHealthiness = new JLabel("Select Animal");
		
		displayItemImpact = new JLabel("Select Item");
		
		selectAnimal = new JComboBox<Animals>();
		selectAnimal.setToolTipText("Select animal from inventory.");
		selectAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeAnimal((Animals) selectAnimal.getSelectedItem());
			}
		});
		refreshAnimals();
		
		selectItem = new JComboBox<item>();
		selectItem.setToolTipText("Select item from inventory.");
		selectItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeItem((item) selectItem.getSelectedItem());
			}
		});
		refreshItems();
		
		JButton feedAnimalButton = new JButton("Feed Animal");
		feedAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food item = (Food) selectItem.getSelectedItem();
				Animals animal = (Animals) selectAnimal.getSelectedItem();
				if (animal instanceof Animals == false) {
					JOptionPane.showMessageDialog(null, "No animal selected");
				} else if (item instanceof Food == false) {
					JOptionPane.showMessageDialog(null, "No item selected");
				} else if (animal.getHealthiness() >= 1) {
					JOptionPane.showMessageDialog(null, "Animal healthiness is already full");
				} else {
					try {
						game.feedAnimals(item, animal);
						JOptionPane.showMessageDialog(null, "Animal fed\nActions remaining : " + game.getFarm().getFarmer().getNumActions());
						refreshAnimals();
						refreshItems();
					} catch (NoMoreActionsException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton playWithAnimalButton = new JButton("Play With Animals");
		playWithAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean allHappy = checkAllHappy();
				if (game.getFarm().getAnimalList().size() == 0) {
					JOptionPane.showMessageDialog(null, "You own no animals");
				} else if (allHappy == true) {
					JOptionPane.showMessageDialog(null, "All your animals are already happy");
				} else {
					try {
						game.playWithAnimals();
						JOptionPane.showMessageDialog(null, "Your animals thoroughly enjoyed your attention\nActions remaining : " + game.getFarm().getFarmer().getNumActions());
						refreshAnimals();
					} catch (NoMoreActionsException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			}
		});
		
		JLabel itemImpactLabel = new JLabel("Item impact\r\n:");
		itemImpactLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		
		JButton btnNewButton = new JButton("Return To Farm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.showHomeWindow();
				frame.dispose();
			}
		});
		
		JLabel healthinessModifierLabel = new JLabel("Farm healthiness modifier:");
		healthinessModifierLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel displayHealthinessModifier = new JLabel("Select Animal");
		displayHealthinessModifier.setText(String.valueOf(game.getFarm().getAnimallHealthinessModifier()));
		
		JLabel happinessModifierLabel = new JLabel("Farm happiness modifier:");
		happinessModifierLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel displayHappinessModifier = new JLabel("Select Animal");
		displayHappinessModifier.setText(String.valueOf(game.getFarm().getAnimalHappinessModifier()));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(245)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
							.addGap(104)
							.addComponent(feedAnimalButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(playWithAnimalButton, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(itemImpactLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(displayItemImpact, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(healthinessModifierLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addComponent(animalHealthinessLabel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(happinessModifierLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(happinessLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
											.addGap(1)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(displayHappinessModifier, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(displayHealthiness, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(displayHealthinessModifier, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
											.addComponent(displayHappiness, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)))))))
					.addContainerGap(77, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(346)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(414))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(288)
					.addComponent(selectAnimal, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(323, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(selectAnimal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(happinessModifierLabel)
						.addComponent(displayHappinessModifier))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(happinessLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(displayHappiness, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(displayHealthinessModifier)
						.addComponent(healthinessModifierLabel))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(feedAnimalButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(itemImpactLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(displayItemImpact, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(animalHealthinessLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(displayHealthiness, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(playWithAnimalButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(48))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public Window getFrame() {
		return frame;
	}

}
