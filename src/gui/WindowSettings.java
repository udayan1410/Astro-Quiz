package gui;


import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.WindowStartScreen.ButtonHandler;
import interfaces.CustomButtonCommunicator;

public class WindowSettings extends JFrame{

	

	private static final LayoutManager FlowLayout = null;

	private CustomButton GameSound,gOn,gOff,MusicSound,mon,moff;
	
	
	public WindowSettings(){
		
		setTitle("Settings");
		
		
setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));
		
		setLayout(FlowLayout);
	
		
		
		
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		JPanel HorizontalPanel = new JPanel();
	    HorizontalPanel.setLayout(new FlowLayout(1,60,20));
	    
	    GameSound = new CustomButton("GameSound");
	    GameSound.setButtonCommunicator(new ButtonHandler());
	    
	    gOn = new CustomButton("ON");
	    gOn.setButtonCommunicator(new ButtonHandler());
	    
	    gOff = new CustomButton("OFF");
	    gOff.setButtonCommunicator(new ButtonHandler());
	    
	    
	    add(new PanelTitlePanel());
	    
	    HorizontalPanel.add(GameSound);
	    HorizontalPanel.add(Box.createRigidArea(new Dimension(13,0)));
	    HorizontalPanel.add(gOn);
	    HorizontalPanel.add(Box.createRigidArea(new Dimension(13,0)));
	    HorizontalPanel.add(gOff);
	   // HorizontalPanel.add(Box.createRigidArea(new Dimension(0,1)));
	    HorizontalPanel.setOpaque(false);
	    //HorizontalPanel.add(Box.createRigidArea(new Dimension(0,13)));
	    add(HorizontalPanel);
	    
		
	
	    setVisible(true);
		
	
	}
	
	class ButtonHandler implements CustomButtonCommunicator{

		@Override
		public void buttonClicked(String userAnswer) {
			// TODO Auto-generated method stub
			
			
			
		}
	
	
}
}
