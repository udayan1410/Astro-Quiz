package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.deploy.uitoolkit.impl.fx.Utils;

import gui.ComponentTFQuestion.ButtonCommunicatorAdapter;
import interfaces.CustomButtonCommunicator;
import interfaces.SoundCommunicator;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class WindowStartScreen extends JFrame {

	private JButton b1;
	private JLabel l1;
	private CustomButton NewGame, Settings, HighScore, Exit;
	private SoundCommunicator soundCommunicator;
	private Clip clip = null;

	public WindowStartScreen() {
		setSoundPlayer();
		playSound();
		setTitle("Space Quiz");

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));

		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		NewGame = new CustomButton("New Game");
		NewGame.setButtonCommunicator(new CustomButtonCommunicator() {
			@Override
			public void buttonClicked(String userAnswer) {
				setVisible(false);
				new WindowQuestionScreen();
				dispose();

			}
		});

		Settings = new CustomButton("Settings");
		Settings.setButtonCommunicator(new CustomButtonCommunicator() {

			@Override
			public void buttonClicked(String userAnswer) {
				setVisible(false);
				new WindowSettings(soundCommunicator);
				dispose();

			}
		});

		HighScore = new CustomButton("High Score");
		HighScore.setButtonCommunicator(new ButtonHandler());

		Exit = new CustomButton("Exit");
		Exit.setButtonCommunicator(new CustomButtonCommunicator() {

			@Override
			public void buttonClicked(String userAnswer) {
				dispose();

			}
		});

		add(new PanelTitlePanel());
		add(Box.createRigidArea(new Dimension(0, 120)));
		add(NewGame);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(Settings);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(HighScore);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(Exit);
		add(Box.createRigidArea(new Dimension(0, 13)));
		soundCommunicator.changeSound();
		setVisible(true);

	}

	class ButtonHandler implements CustomButtonCommunicator {

		@Override
		public void buttonClicked(String userAnswer) {
			// TODO Auto-generated method stub

		}

	}

	public void setSoundPlayer() {
		try {
			InputStream in;
			InputStream bufferedIn;
			AudioInputStream as;
			in = new FileInputStream("./Sounds/mmt.wav");
			bufferedIn = new BufferedInputStream(in);
			as = AudioSystem.getAudioInputStream(bufferedIn);
			clip = AudioSystem.getClip();
			clip.open(as);
		} catch (Exception e) {
		}
	}

	public void playSound() {
		soundCommunicator = new SoundCommunicator() {

			@Override
			public void changeSound() {
				if (utilities.Utils.gameMusic)
					clip.loop(Clip.LOOP_CONTINUOUSLY);

				else
					clip.stop();

			}

		};
	}

}
