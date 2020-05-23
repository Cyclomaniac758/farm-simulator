package game;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import items.*;

public class BuyItemsWindow {
	
	private GameGUI game;
	
	private JFrame frame;
	private JTextField numItems;
	private JLabel displayPrice;
	private JLabel displayEffect;
	private JLabel displayMoney;

	/**
	 * Create the application.
	 * @param game 
	 */
	public BuyItemsWindow(GameGUI game) {
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
		
		JLabel titleLabel = new JLabel("Item Store");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		String[] items = new String[] {"Select Item", "Water For Crops", "Hoe", "Fertilizer", "Incubator",
				"Water For Animals", "Grain", "Growth Hormone"};
		JComboBox<String> selectItem = new JComboBox(items) ;
		selectItem.setToolTipText("Select the item you would like to view");
		selectItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeItem(items[selectItem.getSelectedIndex()]);
			}
		});
		
		JButton buyAnimal = new JButton("Buy ");
		buyAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) selectItem.getSelectedItem();
				if (item == "Select Item") {
					JOptionPane.showMessageDialog(null, "Select an item to buy");
				} else {
					int num = 0;
					try {
						num = Integer.parseInt(numItems.getText());
						try {
							game.buyItems(item, num);
							refreshMoney();
							JOptionPane.showMessageDialog(null,  "Bought " + num + " units of " + item);
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
		
		JLabel itemPrice = new JLabel("Item Price:");
		itemPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel itemEffect = new JLabel("Item Effect:");
		itemEffect.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayPrice = new JLabel("Select Item");
		
		displayEffect = new JLabel("Select Item");
		
		numItems = new JTextField();
		numItems.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Quantity:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayMoney = new JLabel(String.format("$%.2f", game.getFarm().getFarmMoney().getMoneyAmount()));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(itemEffect, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(itemPrice, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(displayEffect, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(displayPrice, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(numItems, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(buyAnimal, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(exit))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(displayMoney, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(161)
							.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(displayMoney))
					.addGap(18)
					.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemPrice)
						.addComponent(displayPrice))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(displayEffect, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(itemEffect))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(numItems, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buyAnimal)
						.addComponent(exit))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void changeItem(String string) {
		item item;
		switch(string) {
		case "Water For Crops":
			item = new Water();
			break;
		case "Hoe":
			item = new Hoe();
			break;
		case "Fertilizer":
			item = new Fertilizer();
			break;
		case "Incubator":
			item = new Incubator();
			break;
		case "Water For Animals":
			item = new WaterFood();
			break;
		case "Grain":
			item = new Grain();
			break;
		case "Growth Hormone":
			item = new GrowthHormone();
			break;
		case "Select Item":
			displayPrice.setText("Select Item");
			displayEffect.setText("Select Item");
			return;
		default:
			return;
		}
		displayPrice.setText(String.valueOf(item.getItemPrice()));
		displayEffect.setText(item.getItemUse());
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
