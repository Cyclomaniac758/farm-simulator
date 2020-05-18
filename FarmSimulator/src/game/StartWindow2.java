package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartWindow2 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow2 window = new StartWindow2();
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
	public StartWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 695, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Farm Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(73, 33, 131, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(214, 35, 123, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Select Farm Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(149, 83, 123, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton familyFarmButton = new JButton("Family");
		familyFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		familyFarmButton.setToolTipText("Family\r\nFarm");
		familyFarmButton.setBounds(20, 137, 91, 60);
		frame.getContentPane().add(familyFarmButton);
		
		JButton commercialFarmButton = new JButton("Commercial");
		commercialFarmButton.setBounds(121, 137, 91, 60);
		frame.getContentPane().add(commercialFarmButton);
		
		JButton livestockFarmButton = new JButton("Livestock");
		livestockFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		livestockFarmButton.setBounds(224, 137, 91, 60);
		frame.getContentPane().add(livestockFarmButton);
		
		JButton cropFarmButton = new JButton("Crop");
		cropFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cropFarmButton.setBounds(325, 137, 91, 60);
		frame.getContentPane().add(cropFarmButton);
		
		JButton farmInfoButton = new JButton("INFO");
		farmInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		farmInfoButton.setBounds(282, 86, 70, 23);
		frame.getContentPane().add(farmInfoButton);
		
		JButton nextButton = new JButton("NEXT");
		nextButton.setBounds(184, 208, 89, 23);
		frame.getContentPane().add(nextButton);
	}

}
