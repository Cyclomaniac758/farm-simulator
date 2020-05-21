package game;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import crops.*;

public class CropsWindow {
	
	private GameGUI game;
	
	private JFrame frame;
	private JComboBox<Crops> selectCrop;
	/**
	 * Create the application.
	 * @param game 
	 */
	public CropsWindow(GameGUI game) {
		this.game = game;
		initialize();
	}
	
	public void refreshCrops() {
		selectCrop.removeAllItems();
		for (Crops crop: game.getFarm().getCropList()) {
			selectCrop.addItem(crop);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 666);
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
		
		selectCrop = new JComboBox<Crops>();
		selectCrop.setToolTipText("Select crop from inventory.");
		refreshCrops();
		
		JLabel totalTimeLabel = new JLabel("Total growing time:");
		totalTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel displayTotalGrowTime = new JLabel("");
		
		JLabel remainingLabel = new JLabel("Remaing days: ");
		remainingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel displayRemainingDays = new JLabel("");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("Item impact:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JButton harvestCropButton = new JButton("Harvest Crop");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(312)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(363, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(190)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(95)
									.addComponent(remainingLabel, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
								.addComponent(totalTimeLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(displayTotalGrowTime, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(28))
								.addComponent(displayRemainingDays, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectCrop, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(37))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(368)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(harvestCropButton, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(tendCropButton, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addGap(190))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(316)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(441, Short.MAX_VALUE))
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
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(totalTimeLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(displayTotalGrowTime, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(displayRemainingDays, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(remainingLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addComponent(harvestCropButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tendCropButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
							.addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(41))))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public Window getFrame() {
		return frame;
	}
}
