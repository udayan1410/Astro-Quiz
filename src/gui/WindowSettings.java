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

	private CustomSettingsButton GameSound,gOn,gOff,GameMusic,mOn,mOff;
	
	
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
		JPanel HorizontalPanel1 = new JPanel();
	    HorizontalPanel1.setLayout(new FlowLayout(1,60,20));
	    
	    GameSound = new CustomSettingsButton("Game Sound");
	    GameSound.setButtonCommunicator(new ButtonHandler());
	    
	    gOn = new CustomSettingsButton("ON");
	    gOn.setButtonCommunicator(new ButtonHandler());
	    
	    gOff = new CustomSettingsButton("OFF");
	    gOff.setButtonCommunicator(new ButtonHandler());
	    
	    
	    add(new PanelTitlePanel());
	    add(Box.createRigidArea(new Dimension(0,50)));
	    HorizontalPanel1.add(GameSound);
	    HorizontalPanel1.add(Box.createRigidArea(new Dimension(0,13)));
	    HorizontalPanel1.add(gOn);
	    HorizontalPanel1.add(Box.createRigidArea(new Dimension(0,13)));
	    HorizontalPanel1.add(gOff);
	    HorizontalPanel1.setOpaque(false);
	    add(HorizontalPanel1);
	   
	    
	    JPanel HorizontalPanel2 = new JPanel();
	    HorizontalPanel2.setLayout(new FlowLayout(1,60,20));
	    GameMusic = new CustomSettingsButton("Game Music");
	    mOn = new CustomSettingsButton("ON");
	    mOn.setButtonCommunicator(new ButtonHandler());
	    
	    mOff = new CustomSettingsButton("OFF");
	    mOff.setButtonCommunicator(new ButtonHandler());
	   
	    HorizontalPanel2.add(GameMusic);
	    HorizontalPanel2.add(mOn);
	    HorizontalPanel2.add(mOff);
	    HorizontalPanel2.setOpaque(false);
	    add(HorizontalPanel2);
		
	
	    setVisible(true);
		
	
	}
	
	class ButtonHandler implements CustomButtonCommunicator{

		@Override
		public void buttonClicked(String userAnswer) {
			// TODO Auto-generated method stub
			
			
			
		}
	
	
}
}
