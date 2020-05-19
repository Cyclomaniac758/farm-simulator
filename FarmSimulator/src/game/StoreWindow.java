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

public class StoreWindow {
	
	private GameGUI game;
	
	private JFrame frame;


	/**
	 * Create the application.
	 * @param game 
	 */
	public StoreWindow(GameGUI game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[71px][][61px][61px][][57px][79px][1px]", "[38px][23px][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("General Store");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel, "cell 3 1,alignx left,aligny center");
		
		JButton cropsButton = new JButton("Crops");
		cropsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyCropsWindow window = new BuyCropsWindow(game);
				
			}
		});
		
		JButton animalsButton = new JButton("Animals");
		animalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyAnimalsWindow window = new BuyAnimalsWindow(game);
				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(animalsButton, "cell 2 10,alignx left,aligny center");
		frame.getContentPane().add(cropsButton, "cell 3 10,alignx center,aligny center");
		
		JButton itemsButton = new JButton("Items");
		itemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frame.getContentPane().add(itemsButton, "cell 5 10,alignx left,aligny center");
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeWindow window = new HomeWindow(game);
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		
		JButton inventoryButton = new JButton("Inventory");
		frame.getContentPane().add(inventoryButton, "cell 3 20,alignx center,aligny center");
		frame.getContentPane().add(exitButton, "cell 5 20,alignx left");
	}

	public Window getFrame() {
		return frame;
	}
}
