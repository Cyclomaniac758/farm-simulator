package game;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import crops.*;

public class BuyCropsWindow {

	private JFrame frame;
	private GameGUI game;
	private JLabel displayPrice;
	private JLabel displayGrowTime;
	private JLabel displaySellPrice;

	/**
	 * Create the application.
	 * @param game 
	 */
	public BuyCropsWindow(GameGUI game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setFrame(frame);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("Crop Store");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		String[] crops = new String[] {"Select Crop", "Carrots", "Wheat", "Tomatoes", "Corn",
				"Lemon Tree", "Apple Tree"};
		JComboBox<String> selectItem = new JComboBox(crops) ;
		selectItem.setToolTipText("Select the crop you would like to view");
		selectItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCrop(crops[selectItem.getSelectedIndex()]);
			}
		});
		
		JButton buyAnimal = new JButton("Buy ");
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JLabel cropPrice = new JLabel("Crop Price:");
		cropPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel itemEffect = new JLabel("Grow Time:");
		itemEffect.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displayPrice = new JLabel("Select Crop");
		
		displayGrowTime = new JLabel("Select Crop");		
		
		JLabel cropSellPrice = new JLabel("Sell Price:");
		cropSellPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		displaySellPrice = new JLabel("Select Crop");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(buyAnimal, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(exit))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(164)
							.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(148)
								.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(cropSellPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(itemEffect, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGap(23)
										.addComponent(cropPrice, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(displaySellPrice, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addComponent(displayGrowTime, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addComponent(displayPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(selectItem, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cropPrice)
						.addComponent(displayPrice))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemEffect)
						.addComponent(displayGrowTime))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cropSellPrice)
						.addComponent(displaySellPrice))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buyAnimal)
						.addComponent(exit))
					.addGap(7))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void changeCrop(String string) {
		Crops crop;
		switch(string) {
		case "Carrots":
			crop = new Carrots();
			break;
		case "Wheat":
			crop = new Wheat();
			break;
		case "Tomatoes":
			crop = new Tomatoes();
			break;
		case "Corn":
			crop = new Corn();
			break;
		case "Lemon Tree":
			crop = new LemonTree();
			break;
		case "Apple Tree":
			crop = new AppleTree();
			break;
		case "Select Crop":
			displayPrice.setText("Select Crop");
			displayGrowTime.setText("Select Crop");
			displaySellPrice.setText("Select Crop");
			return;
		default:
			return;
		}
		displayPrice.setText(String.valueOf(crop.getBuyPrice()));
		displayGrowTime.setText(String.valueOf(crop.getGrowTime()));
		displaySellPrice.setText(String.valueOf(crop.getSellPrice()));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
