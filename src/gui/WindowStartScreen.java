package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.ComponentTFQuestion.ButtonCommunicatorAdapter;
import interfaces.CustomButtonCommunicator;


public class WindowStartScreen extends JFrame {

	JButton b1;
	JLabel l1;
	private CustomButton NewGame,Settings,HighScore,Exit;
	
		public WindowStartScreen()
		{
		setTitle("Space Quiz");
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\bg.jpeg")));
		setLayout(new BorderLayout());
		setVisible(true);
	
		
		NewGame = new CustomButton("New Game");
		NewGame.setButtonCommunicator(new ButtonHandler());
		
		Settings = new CustomButton("Settings");
		Settings.setButtonCommunicator(new ButtonHandler());
		
		HighScore = new CustomButton("High Score");
		HighScore.setButtonCommunicator(new ButtonHandler());
		
		Exit = new CustomButton("Exit");
		Exit.setButtonCommunicator(new ButtonHandler());
		
		add(NewGame);
		add(Box.createRigidArea(new Dimension(0,13)));
		add(Settings);
		add(Box.createRigidArea(new Dimension(0,13)));
		add(HighScore);
		add(Box.createRigidArea(new Dimension(0,13)));
		add(Exit);
		add(Box.createRigidArea(new Dimension(0,13)));
		
		}
				
	
		class ButtonHandler implements CustomButtonCommunicator{

			@Override
			public void buttonClicked(String userAnswer) {
				// TODO Auto-generated method stub
				
			}
			
		}
}
