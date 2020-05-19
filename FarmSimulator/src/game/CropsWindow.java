package game;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

public class CropsWindow {
	
	private GameGUI game;
	
	private JFrame frame;

	/**
	 * Create the application.
	 * @param game 
	 */
	public CropsWindow(GameGUI game) {
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

	public Window getFrame() {
		return frame;
	}

}
