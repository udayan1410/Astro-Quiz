package gui;


import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.WindowStartScreen.ButtonHandler;
import interfaces.CustomButtonCommunicator;

public class WindowSettings extends JFrame{

	

	private static final LayoutManager FlowLayout = null;

	private CustomSettingsButton gOn,gOff, mOn,mOff,back;
	private JLabel GameSound,GameMusic;
	
	public WindowSettings(){
		
		setTitle("Settings");
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));
		
		JPanel HorizontalPanel1 = new JPanel();
		setLayout(FlowLayout);
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		 add(new PanelTitlePanel());
		 
		 HorizontalPanel1.setBorder(new EmptyBorder(150, 0, 0, 0));
		HorizontalPanel1.setLayout(new FlowLayout(1,40,30));
	    
	    GameSound = new JLabel("GameSound:");
	    GameSound.setForeground(new Color(255,255,255));
	    GameSound.setBackground(new Color(0,0,0));
	    GameSound.setFont(new Font(Font.MONOSPACED,Font.PLAIN,40));
	    
	    gOn = new CustomSettingsButton("   ON   ");
	    gOn.setButtonCommunicator(new ButtonHandler());
	    
	    gOff = new CustomSettingsButton("   OFF   ");
	    gOff.setButtonCommunicator(new ButtonHandler());
	   
	    HorizontalPanel1.add(GameSound);
	    HorizontalPanel1.add(gOn);
	    HorizontalPanel1.add(gOff);
	    HorizontalPanel1.setOpaque(false);
	    add(HorizontalPanel1);
	   
	    
	    JPanel HorizontalPanel2 = new JPanel();
	    HorizontalPanel2.setLayout(new FlowLayout(1,40,30));
	    
	    GameMusic = new JLabel("GameMusic:");
	    GameMusic.setForeground(new Color(255,255,255));
	    GameMusic.setBackground(new Color(0,0,0));
	    GameMusic.setFont(new Font(Font.MONOSPACED,Font.PLAIN,40));
	    
	    
	    mOn = new CustomSettingsButton("   ON   ");
	    mOn.setButtonCommunicator(new ButtonHandler());
	    
	    mOff = new CustomSettingsButton("   OFF   ");
	    mOff.setButtonCommunicator(new ButtonHandler());
	   
	   
	    
	    HorizontalPanel2.add(GameMusic);
	    HorizontalPanel2.add(mOn);
	    HorizontalPanel2.add(mOff);
	    HorizontalPanel2.setOpaque(false);
	    add(HorizontalPanel2);
		
	
	    JPanel HorizontalPanel3 = new JPanel();
	    HorizontalPanel3.setLayout(new FlowLayout(1,10,10));
	    
	    back = new CustomSettingsButton("   Back   ");
	    back.setButtonCommunicator(new CustomButtonCommunicator() {
			
			@Override
			public void buttonClicked(String userAnswer) {
				// TODO Auto-generated method stub
				setVisible(false);
				new WindowStartScreen();
				dispose();
			}
		});
	    HorizontalPanel3.add(back);
	    HorizontalPanel3.setOpaque(false);
	    add(HorizontalPanel3);
	    
	    setVisible(true);
		
	
	}
	
	class ButtonHandler implements CustomButtonCommunicator{

		@Override
		public void buttonClicked(String userAnswer) {
			// TODO Auto-generated method stub
			
			
			
		}
	
	
}
}
