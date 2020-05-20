package game;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimalsWindow {

	private JFrame frame;
	
	private GameGUI game;

	/**
	 * Create the application.
	 * @param game 
	 */
	public AnimalsWindow(GameGUI game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1000, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("Animals");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("STFangsong", Font.PLAIN, 45));
		
		JComboBox selectAnimal = new JComboBox();
		
		JLabel happienessLabel = new JLabel("Animal happiness:");
		happienessLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel displayHappiness = new JLabel("");
		
		JLabel animalHealthinessLabel = new JLabel("Animal healthiness:");
		animalHealthinessLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel displayHealthiness = new JLabel("");
		
		JButton feedAnimalButton = new JButton("Feed Animal");
		
		JButton playWithAnimalButton = new JButton("Play With Animals");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel itmeImpactLabel = new JLabel("Item impact\r\n:");
		itmeImpactLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblnewLabelggg = new JLabel("");
		
		JButton btnNewButton = new JButton("Return To Farm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.showHomeWindow();
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(328)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, 0, 325, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(animalHealthinessLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(happienessLabel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(itmeImpactLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(playWithAnimalButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblnewLabelggg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(displayHealthiness, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(displayHappiness, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
						.addComponent(selectAnimal, Alignment.TRAILING, 0, 325, Short.MAX_VALUE)
						.addComponent(titleLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
					.addGap(86)
					.addComponent(feedAnimalButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(155))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(selectAnimal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(happienessLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(displayHappiness, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(animalHealthinessLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(displayHealthiness, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(feedAnimalButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(itmeImpactLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblnewLabelggg, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(playWithAnimalButton, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
					.addGap(56))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public Window getFrame() {
		return frame;
	}

}
