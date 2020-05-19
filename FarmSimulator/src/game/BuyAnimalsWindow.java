package game;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BuyAnimalsWindow {
	
	private GameGUI game;
	
	private JFrame frame;

	/**
	 * Create the application.
	 * @param game 
	 */
	public BuyAnimalsWindow(GameGUI game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setFrame(frame);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
