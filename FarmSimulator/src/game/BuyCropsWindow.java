package game;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BuyCropsWindow {

	private JFrame frame;
	private GameGUI game;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
