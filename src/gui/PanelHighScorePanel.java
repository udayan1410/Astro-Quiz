package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import interfaces.CustomButtonCommunicator;
import model.Score;
import sun.swing.SwingAccessor;

public class PanelHighScorePanel extends JPanel {
	private Score score;
	private JLabel highScore,danceImage;
	
	private CustomButton tryAgainButton,exitButton;
	
	public PanelHighScorePanel(Score score){
		this.score = score;

		Dimension dimension = getToolkit().getScreenSize();	
		dimension.width = dimension.width/3;
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setBackground(Color.black);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));	
		
		//Setting up dance animation
		danceImage = new JLabel("");
		danceImage.setPreferredSize(new Dimension(300,200));
		danceImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Score Text and Image						
		highScore = new JLabel("Score : "+score.getFinalScore()+"/20");
		int finalScore = score.getFinalScore();	
		setImageBasedOnScore(score.getFinalScore());			
		highScore.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
		highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Button handler
		ButtonCommunicator buttonCommunicator = new ButtonCommunicator();
		
		//Try again button
		tryAgainButton = new CustomButton("Try Again");
		tryAgainButton.setButtonCommunicator(buttonCommunicator);
		tryAgainButton.setSize(new Dimension(400,50));		
		
		//Exit button
		exitButton = new CustomButton("Exit");
		exitButton.setButtonCommunicator(buttonCommunicator);
		exitButton.setSize(new Dimension(400,50));		
		
		//Add to panel
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
	
	
	public void setImageBasedOnScore(int finalScore){
		if(finalScore>=0 && finalScore<=10){
			highScore.setForeground(Color.red);			
			ImageIcon icon =new ImageIcon(this.getClass().getResource("./assets/sadFace2.gif"));			
			danceImage.setIcon(icon);
		}
		else if(finalScore>10 && finalScore<=15){
			highScore.setForeground(Color.yellow);
			ImageIcon icon =new ImageIcon(this.getClass().getResource("./assets/thumbsUP.gif"));			
			danceImage.setIcon(icon);
		}
		else{			
			highScore.setForeground(Color.green);
			ImageIcon icon =new ImageIcon(this.getClass().getResource("./assets/dancingGreen.gif"));
			danceImage.setIcon(icon);
		}
	}
	
	class ButtonCommunicator implements CustomButtonCommunicator{
		@Override
		public void buttonClicked(String userAnswer) {			
			switch(userAnswer){
			
			case "TRY AGAIN":
				System.out.println("Clicked Try again");
				break;
				
			case "EXIT":
			System.out.println("Clicked Exit");
			break;
			}
			
		}
	}
}
