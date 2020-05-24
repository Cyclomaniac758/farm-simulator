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
/**
 * Farm Information GUI
 * @author Icarus
 *
 */
public class FarmInformation {

	public JFrame frame;
	//JPanels
	private JPanel familyPanel;
	private JPanel commercialPanel;
	private JPanel livestockPanel;
	private JPanel cropPanel;
	//JLabels
	private JLabel familyLabel;
	private JLabel commercialLabel;
	private JLabel livestockLabel;
	private JLabel cropLabel;
	//JTextAreas
	private JTextArea txtrTheCommercialFarm;
	private JTextArea txtrTheFamilyFarm;
	private JTextArea txtrTheLivestockFarm;
	private JTextArea txtrTheCropFarm;
	private JButton btnBack;

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
		txtrTheFamilyFarm.setText("The family farm allows your\r\nanimals to lead very happy\r\nlives increasing their daily\r\nearnings. However, due to the\r\nsmall size of your farm you\r\nwill have a lower capacity for\r\nanimals and crops, and longer grow times.");
		txtrTheFamilyFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheFamilyFarm.setBackground(SystemColor.window);
		txtrTheFamilyFarm.setBounds(10, 60, 333, 142);
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
		txtrTheCommercialFarm.setText("The commercial farm allows you to\r\nfarm more crops and animals\r\nwith the downside of having less\nhealthy and happy animals.");
		txtrTheCommercialFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheCommercialFarm.setBackground(SystemColor.window);
		txtrTheCommercialFarm.setBounds(10, 60, 316, 95);
		txtrTheCommercialFarm.setEditable(false);
		commercialPanel.add(txtrTheCommercialFarm);
		
		
		livestockPanel = new JPanel();
		tabbedPane.addTab("Livestock", null, livestockPanel, null);
		livestockPanel.setLayout(null);
		
		livestockLabel = new JLabel("Livestock Farm");
		livestockLabel.setHorizontalAlignment(SwingConstants.LEFT);
		livestockLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		livestockLabel.setBounds(10, 6, 241, 40);
		livestockPanel.add(livestockLabel);
		
		txtrTheLivestockFarm = new JTextArea();
		txtrTheLivestockFarm.setText("The livestock farm allows you to\r\nstart with the base animal and"
				+ "\ncrop max capacity.The animals\nalso have base happiness levels.");
		txtrTheLivestockFarm.setBackground(SystemColor.window);
		txtrTheLivestockFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheLivestockFarm.setBounds(10, 60, 316, 95);
		txtrTheLivestockFarm.setEditable(false);
		livestockPanel.add(txtrTheLivestockFarm);
		
		
		cropPanel = new JPanel();
		tabbedPane.addTab("Crop", null, cropPanel, null);
		cropPanel.setLayout(null);
		
		cropLabel = new JLabel("Crop Farm");
		cropLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cropLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cropLabel.setBounds(10, 6, 170, 40);
		cropPanel.add(cropLabel);
		
		txtrTheCropFarm = new JTextArea();
		txtrTheCropFarm.setText("The crop farm allows you to\r\nstart with a smaller animal but much\nlarger crop capacity than the all\nthe other farms. Due to the farms crop environment\nthe animals are slightly happier than on a normal farm.");
		txtrTheCropFarm.setAlignmentX(SwingConstants.CENTER);
		txtrTheCropFarm.setBackground(SystemColor.window);
		txtrTheCropFarm.setBounds(10, 60, 316, 100);
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
