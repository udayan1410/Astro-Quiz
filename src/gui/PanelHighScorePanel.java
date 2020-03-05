package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.javafx.font.Disposer;

import javax.swing.GroupLayout.Alignment;

import interfaces.CustomButtonCommunicator;
import model.Score;
import sun.swing.SwingAccessor;

public class PanelHighScorePanel extends JPanel {
	private Score score;
	private JLabel highScore, danceImage;
	private CustomButtonCommunicator buttonCommunicator;
	private CustomButton tryAgainButton, exitButton;

	public PanelHighScorePanel(Score score,CustomButtonCommunicator buttonCommunicator) {
		this.score = score;
		this.buttonCommunicator = buttonCommunicator;
		
		Dimension dimension = getToolkit().getScreenSize();
		dimension.width = dimension.width / 3;
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setBackground(Color.black);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Setting up dance animation
		danceImage = new JLabel("");
		danceImage.setPreferredSize(new Dimension(300, 200));
		danceImage.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Score Text and Image
		// score.setFinalScore(18);
		highScore = new JLabel("Score : " + score.getFinalScoreValue() + "/20");
		int finalScore = score.getFinalScoreValue();
		setImageBasedOnScore(score.getFinalScoreValue());
		highScore.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
		highScore.setAlignmentX(Component.CENTER_ALIGNMENT);



		// Try again button
		tryAgainButton = new CustomButton("Try Again");
		tryAgainButton.setButtonCommunicator(new ButtonCommunicator());
		tryAgainButton.setSize(new Dimension(400, 50));

		// Exit button
		exitButton = new CustomButton("Exit");
		exitButton.setButtonCommunicator(new ButtonCommunicator());
		exitButton.setSize(new Dimension(400, 50));

		// Add to panel
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(danceImage);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(highScore);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(tryAgainButton);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(exitButton);
		add(Box.createRigidArea(new Dimension(0, 30)));
	}

	public void setImageBasedOnScore(int finalScore) {
		if (finalScore >= 0 && finalScore <= 10) {
			highScore.setForeground(Color.red);
			ImageIcon icon = new ImageIcon(this.getClass().getResource("./assets/sadFace2.gif"));
			danceImage.setIcon(icon);
		} else if (finalScore > 10 && finalScore <= 15) {
			highScore.setForeground(Color.yellow);
			ImageIcon icon = new ImageIcon(this.getClass().getResource("./assets/thumbsUP.gif"));
			danceImage.setIcon(icon);
		} else {
			highScore.setForeground(Color.green);
			ImageIcon icon = new ImageIcon(this.getClass().getResource("./assets/dancingGreen.gif"));
			danceImage.setIcon(icon);
		}
	}

	class ButtonCommunicator implements CustomButtonCommunicator {
		@Override
		public void buttonClicked(String userClicked) {
			buttonCommunicator.buttonClicked(userClicked);		
		}
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
		Graphics2D g2d = (Graphics2D) grphcs;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 0, new Color(36, 11, 54), 0, 900, new Color(195, 20, 50));

		g2d.setPaint(gp);
		g2d.fillRect(0, 0, getWidth(), getHeight());

	}

}
