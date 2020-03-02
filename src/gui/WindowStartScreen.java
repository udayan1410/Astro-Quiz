package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
		

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
		
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));

		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
					
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
				new WindowSettings();
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
		add(Box.createRigidArea(new Dimension(0,120)));
		add(NewGame);
		add(Box.createRigidArea(new Dimension(0,13)));
		add(Settings);
		add(Box.createRigidArea(new Dimension(0,13)));
		add(HighScore);
		add(Box.createRigidArea(new Dimension(0,13)));
		add(Exit);
		add(Box.createRigidArea(new Dimension(0,13)));
		setVisible(true);
		}
				
	
		class ButtonHandler implements CustomButtonCommunicator{

			@Override
			public void buttonClicked(String userAnswer) {
				// TODO Auto-generated method stub
				
				
				
			}
			
		}
}
