package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilities.Utils;

public class PanelInteractivePanel extends JPanel {
	
	private JLabel bgLabel;
	
	public PanelInteractivePanel() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		
		setLayout(new GridLayout());
		
		//Background Label
		bgLabel = new JLabel();
		bgLabel.setPreferredSize(new Dimension(200,300));
		Image icon = new ImageIcon(this.getClass().getResource("./assets/bg.jpeg")).getImage();
		Image scaledIconImage = icon.getScaledInstance(dimension.width,dimension.height,Image.SCALE_SMOOTH);
		bgLabel.setIcon(new ImageIcon(scaledIconImage));						
		
		setPreferredSize(dimension);
		setBackground(Color.white);
		
		CustomButton gButton = new CustomButton("");
		gButton.setImage("mercury.jpg");
		CustomButton gButton2 = new CustomButton("asdasad");
		CustomButton gButton3 = new CustomButton("asdasad");
		CustomButton gButton4 = new CustomButton("asdaqwe");
		CustomButton gButton5 = new CustomButton("asdaqwe");							
		
		add(gButton);	
		//add(gButton2);
		add(gButton3);
		add(gButton4);
		add(gButton5);
		
	}
}
