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
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class StoreWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreWindow window = new StoreWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[71px][][61px][61px][][57px][79px][1px]", "[38px][23px][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("General Store");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel, "cell 3 1,alignx left,aligny center");
		
		JLabel label = new JLabel("");
		frame.getContentPane().add(label, "cell 7 1,alignx left,aligny center");
		
		JLabel label_1 = new JLabel("");
		frame.getContentPane().add(label_1, "cell 7 1,alignx left,aligny center");
		
		JButton btnNewButton_1 = new JButton("Crops");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton = new JButton("Animals");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyAnimalsWindow window = new BuyAnimalsWindow();
				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 2 9,alignx left,aligny center");
		frame.getContentPane().add(btnNewButton_1, "cell 3 9,alignx center,aligny center");
		
		JButton btnNewButton_2 = new JButton("Items");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_2, "cell 5 9,alignx left,aligny center");
		
		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_4 = new JButton("Inventory");
		frame.getContentPane().add(btnNewButton_4, "cell 3 19,alignx center,aligny center");
		frame.getContentPane().add(btnNewButton_3, "cell 5 19,alignx left");
	}
}
