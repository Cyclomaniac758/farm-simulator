package game;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import crops.*;
import exceptions.NoMoreActionsException;
import items.*;

/**
 * Crops window
 * @author Icarus
 *
 */
public class CropsWindow {
	/**
	 * Game object variable
	 */
	private GameGUI game;
	
	private JFrame frame;
	//JComboBox
	private JComboBox<Crops> selectCrop;
	private JComboBox<Item> selectItem;
	//JLabels
	private JLabel displayTotalGrowTime;
	private JLabel displayRemainingDays;
	private JLabel displayItemImpact;
	/**
	 * Create the application.
	 * @param game 
	 */
	public CropsWindow(GameGUI game) {
		this.game = game;
		initialize();
	}
	
	/**
	 * Refreshes the values of displayTotalGrowTime and displayRemainingDays.
	 */
	public void changeCrop(Crops crop) {
		try {
			displayTotalGrowTime.setText(String.valueOf(crop.getTotalGrowTime()));
			displayRemainingDays.setText(String.valueOf(crop.getGrowTime()));
		} catch (NullPointerException e) {
			displayTotalGrowTime.setText("Select Crop");
			displayRemainingDays.setText("Select Crop");
		}
		
	}
	/**
	 * Refreshes the values of displayItemImpact
	 * @param item
	 */
	public void changeItem(Item item) {
		try {
			displayItemImpact.setText(item.getItemUse());
		} catch (NullPointerException e) {
			displayItemImpact.setText("Select Item");
		}
	}
	/**
	 * Refresh the selectCrop JCombobox
	 */
	public void refreshCrops() {
		selectCrop.removeAllItems();
		for (Crops crop: game.getFarm().getCropList()) {
			selectCrop.addItem(crop);
		}
	}
	/**
	 * Refresh the selectItem JComboBox
	 */
	public void refreshItems() {
		selectItem.removeAllItems();
		for (Item item: game.getFarm().getItemList()) {
			if (item instanceof CropTools) {
				selectItem.addItem(item);
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 0, 1000, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("Crops");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("STFangsong", Font.PLAIN, 45));
		
		JButton returnButton = new JButton("Return To Farm");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.showHomeWindow();
				frame.dispose();
			}
		});
		
		JButton tendCropButton = new JButton("Tend Crop");
		tendCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CropTools item = (CropTools) selectItem.getSelectedItem();
				Crops crop = (Crops) selectCrop.getSelectedItem();
				if (crop instanceof Crops) {
					if (item instanceof Item && crop.getGrowTime() != 0) {
						try {
							game.tendCrops(item, crop);
							JOptionPane.showMessageDialog(null, "Crop tended\nActions remaining : " + game.getFarm().getFarmer().getNumActions());
							refreshCrops();
							refreshItems();
						} catch (NoMoreActionsException ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						if (crop.getGrowTime() == 0) {
							JOptionPane.showMessageDialog(null, "Crop is already ready for harvest");
						} else {
							JOptionPane.showMessageDialog(null, "You have no items\nVisit the store to buy items");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have no crops\nVisit the store to buy crops");
				}
			}
		});
		
		JLabel totalTimeLabel = new JLabel("Total growing time:");
		totalTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		JLabel remainingLabel = new JLabel("Remaing days: ");
		remainingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayTotalGrowTime = new JLabel("Select Crop");
		
		displayRemainingDays = new JLabel("Select Crop");
		
		selectCrop = new JComboBox<Crops>();
		selectCrop.setToolTipText("Select crop from inventory.");
		selectCrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCrop((Crops) selectCrop.getSelectedItem());
			}
		});
		refreshCrops();
		
		
		JLabel itemImpactLabel = new JLabel("Item impact:");
		itemImpactLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayItemImpact = new JLabel("Select Item");
		
		selectItem = new JComboBox();
		selectItem.setToolTipText("Select item from inventory.");
		selectItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeItem((Item) selectItem.getSelectedItem());
			}
		});
		refreshItems();
		
		
		JButton harvestCropButton = new JButton("Harvest Crop");
		harvestCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crops crop = (Crops) selectCrop.getSelectedItem();
				if (crop instanceof Crops == false) {
					JOptionPane.showMessageDialog(null, "You own no crops\nVisit the store to buy crops");
				} else {
					if (crop.getGrowTime() == 0) {
					try {
						int price = crop.getSellPrice();
						game.harvestCrops(crop);
						JOptionPane.showMessageDialog(null, "Sold " + crop + " for " + price + " dollars\n" + "Actions remaining: " + game.getFarm().getFarmer().getNumActions());
						refreshCrops();
					} catch (NoMoreActionsException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
					}
					} else {
					JOptionPane.showMessageDialog(null, "Crop not ready for harvest!", "Alert", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		JLabel growTimeModifier = new JLabel("Farm grow time modifier:");
		growTimeModifier.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel displayModifier = new JLabel(String.valueOf(game.getFarm().getGrowingSpeedModifier()));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(312)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(363, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(285)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(growTimeModifier, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
												.addComponent(remainingLabel, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addContainerGap()
											.addComponent(totalTimeLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(displayModifier, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(displayTotalGrowTime, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addComponent(displayRemainingDays, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(selectCrop, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
							.addGap(91))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(95)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(harvestCropButton, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(tendCropButton, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addGap(190))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(139)
					.addComponent(itemImpactLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(displayItemImpact, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
					.addGap(412))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(394)
					.addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(425, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(selectCrop, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(displayTotalGrowTime, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(totalTimeLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(growTimeModifier)
								.addComponent(displayModifier, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(remainingLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(displayRemainingDays, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addComponent(harvestCropButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tendCropButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(displayItemImpact, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(itemImpactLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
					.addGap(73)
					.addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(113))
		);
		frame.getContentPane().setLayout(groupLayout);
	}


	public Window getFrame() {
		return frame;
	}
}
