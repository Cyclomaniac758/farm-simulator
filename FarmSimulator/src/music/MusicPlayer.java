package music;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
/**
 * Music player class that plays the music while the game is being played
 * @author Michael Peters
 *
 */
public class MusicPlayer {
	/**
	 * The location of the music file
	 */
	private File musicPath;
	/**
	 * The input of the music file's audio
	 */
	private AudioInputStream audioInput;
	/**
	 * Reference to the clip interface to get functionality to be able to play the music
	 */
	private Clip clip;
	
	public void playMusic(String musicLocation) {
		
		try {
			musicPath = new File(musicLocation);
		 
			if (musicPath.exists()) {
				audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				
			}
			else {
				System.out.println("Can't find file");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
