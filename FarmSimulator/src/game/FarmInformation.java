package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarmInformation {

	public JFrame frame;
	
	private JPanel familyPanel;
	private JPanel commercialPanel;
	private JPanel livestockPanel;
	private JPanel cropPanel;
	
	private JLabel familyLabel;
	private JLabel commercialLabel;
	private JLabel livestockLabel;
	private JLabel cropLabel;
	
	private JTextArea txtrTheCommercialFarm;
	private JTextArea txtrTheFamilyFarm;
	private JTextArea txtrTheLivestockFarm;
	private JTextArea txtrTheCropFarm;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmInformation window = new FarmInformation();
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
	public FarmInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 500, 342);
		frame.getContentPane().add(tabbedPane);
		
		
		familyPanel = new JPanel();
		tabbedPane.addTab("Family", null, familyPanel, null);
		familyPanel.setLayout(null);
		
		familyLabel = new JLabel("Family Farm");
		familyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		familyLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		familyLabel.setBounds(10, 6, 187, 40);
		familyPanel.add(familyLabel);
		
		txtrTheFamilyFarm = new JTextArea();
		txtrTheFamilyFarm.setText("The family farm allows you to\r\nbegin with 1500 dollars, and start with\nvery happy animals increasing their daily earnings. \nHowever, due to the small size of your farm you \nwill have a lower capacity for animals and crops.");
		txtrTheFamilyFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheFamilyFarm.setBackground(SystemColor.window);
		txtrTheFamilyFarm.setBounds(10, 60, 316, 123);
		txtrTheFamilyFarm.setEditable(false);
		familyPanel.add(txtrTheFamilyFarm);
		
		
		commercialPanel = new JPanel();
		tabbedPane.addTab("Commercial", null, commercialPanel, null);
		commercialPanel.setLayout(null);
		
		commercialLabel = new JLabel("Commercial Farm");
		commercialLabel.setHorizontalAlignment(SwingConstants.LEFT);
		commercialLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		commercialLabel.setBounds(10, 6, 248, 40);
		commercialPanel.add(commercialLabel);
		
		txtrTheCommercialFarm = new JTextArea();
		txtrTheCommercialFarm.setText("The commercial farm allows you to\r\nbegin with 3000 dollars, and start with\r\na larger animal and crop capacity than\r\nthe Family farm. However, due to the\r\ncramped lifestyle of the animals their \r\nhappiness is affected.");
		txtrTheCommercialFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheCommercialFarm.setBackground(SystemColor.window);
		txtrTheCommercialFarm.setBounds(10, 60, 316, 123);
		txtrTheCommercialFarm.setEditable(false);
		commercialPanel.add(txtrTheCommercialFarm);
		
		
		JPanel livestockPanel = new JPanel();
		tabbedPane.addTab("Livestock", null, livestockPanel, null);
		livestockPanel.setLayout(null);
		
		livestockLabel = new JLabel("Livestock Farm");
		livestockLabel.setHorizontalAlignment(SwingConstants.LEFT);
		livestockLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		livestockLabel.setBounds(10, 6, 241, 40);
		livestockPanel.add(livestockLabel);
		
		txtrTheLivestockFarm = new JTextArea();
		txtrTheLivestockFarm.setText("The livestock farm allows you to\r\nbegin with 2500 dollars, and start with\nthe base animal and crop max capacity.\nThe animals also have base happiness levels.");
		txtrTheLivestockFarm.setBackground(SystemColor.window);
		txtrTheLivestockFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheLivestockFarm.setBounds(10, 60, 316, 123);
		txtrTheLivestockFarm.setEditable(false);
		livestockPanel.add(txtrTheLivestockFarm);
		
		
		JPanel cropPanel = new JPanel();
		tabbedPane.addTab("Crop", null, cropPanel, null);
		cropPanel.setLayout(null);
		
		cropLabel = new JLabel("Crop Farm");
		cropLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cropLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cropLabel.setBounds(10, 6, 170, 40);
		cropPanel.add(cropLabel);
		
		txtrTheCropFarm = new JTextArea();
		txtrTheCropFarm.setText("The crop farm allows you to\r\nbegin with 2000 dollars, and start with\r\na smaller animal and but much larger crop \ncapacity than the all the other farms. \nDue to the plentifullness of crops, the animals \nare slightly happier than on a normal farm.");
		txtrTheCropFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheCropFarm.setBackground(SystemColor.window);
		txtrTheCropFarm.setBounds(10, 60, 316, 123);
		txtrTheCropFarm.setEditable(false);
		cropPanel.add(txtrTheCropFarm);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(377, 343, 117, 29);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
	}
}
