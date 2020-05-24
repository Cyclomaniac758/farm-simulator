package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

/**
 * General store window
 * @author Icarus
 *
 */
public class StoreWindow {
	
	private GameGUI game;
	private JFrame homeWindow;
	private JLabel displayMoney;
	private JFrame frame;


	/**
	 * Create GeneralStore object
	 * @param game
	 * @param frame2
	 * @param displayMoney
	 */
	public StoreWindow(GameGUI game, JFrame frame2, JLabel displayMoney) {
		this.game = game;
		this.homeWindow = frame2;
		this.displayMoney = displayMoney;
		game.createStore();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 0, 1000, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton itemsButton = new JButton("Items");
		itemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyItemsWindow window = new BuyItemsWindow(game);
				window.getFrame().setVisible(true);
			}
		});
		
		JButton cropsButton = new JButton("Crops");
		cropsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyCropsWindow window = new BuyCropsWindow(game);
				window.getFrame().setVisible(true);
			}
		});
		
		JButton animalsButton = new JButton("Animals");
		animalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyAnimalsWindow window = new BuyAnimalsWindow(game);
				window.getFrame().setVisible(true);
			}
		});
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeWindow.setVisible(true);
				displayMoney.setText(String.format("$%.2f", game.getFarm().getFarmMoney().getMoneyAmount()));
				frame.dispose();
			}
		});
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmHouseWindow window = new FarmHouseWindow(game, frame);
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(StoreWindow.class.getResource("/img/gen2.png")));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(308)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(362, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(727, Short.MAX_VALUE)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(144))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addComponent(animalsButton, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(inventoryButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cropsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
					.addGap(54)
					.addComponent(itemsButton, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(97))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(lblNewLabel)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cropsButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
								.addComponent(itemsButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(animalsButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
					.addGap(92)
					.addComponent(inventoryButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public Window getFrame() {
		return frame;
	}
}
