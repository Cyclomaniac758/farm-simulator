package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class HelpWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpWindow window = new HelpWindow();
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
	public HelpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel rules = new JLabel("Rules");
		rules.setHorizontalAlignment(SwingConstants.CENTER);
		rules.setFont(new Font("Tahoma", Font.BOLD, 30));
		rules.setBounds(122, 11, 119, 37);
		frame.getContentPane().add(rules);
		
		JButton btnNewButton = new JButton("Return To Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(96, 208, 186, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnRulesVisit = new JTextPane();
		txtpnRulesVisit.setEditable(false);
		txtpnRulesVisit.setText("RULES:\r\n1. Visit the store to buy crops, animals and \r\nitems.\r\n2. Items can be used to increase animal \r\nbonus's and speed up crop growth.\r\n3. You are limited to two actions a day not\r\nincluding buying items.\r\n4. Create your dream farm.");
		txtpnRulesVisit.setBounds(70, 59, 248, 138);
		frame.getContentPane().add(txtpnRulesVisit);
	}
}
