package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import interfaces.CustomButtonCommunicator;
import utilities.Utils;

public class CustomInteractiveButton extends JLabel {

	private CustomInteractiveButton customInteractiveButton;
	private CustomButtonCommunicator buttonCommunicator;

	public CustomInteractiveButton(String title) {
		title = title.toUpperCase();
		LineBorder line = new LineBorder(Color.white, 2, true);
		customInteractiveButton = this;
		new JLabel();
		setText(title);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setMinimumSize(new Dimension(460, 60));
		setMaximumSize(new Dimension(460, 60));
		setOpaque(false);
		setBorder(line);
		setForeground(Color.white);		
		setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 68));
		setAlignmentX(Component.CENTER_ALIGNMENT);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				customInteractiveButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 68));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				playSound();
				customInteractiveButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 75));
				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e){
				buttonCommunicator.buttonClicked(customInteractiveButton.getText());
			}
		});			
	}
	
	public void setButtonCommunicator(CustomButtonCommunicator buttonCommunicator){
		this.buttonCommunicator = buttonCommunicator;
	}
	
	public void playSound() {
		try {
			if (Utils.gameSound) {
				InputStream in = new FileInputStream("./Sounds/pop.wav");
				InputStream bufferedIn = new BufferedInputStream(in);
				AudioInputStream as = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(as);
				clip.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
