package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilities.Utils;

public class PanelInteractivePanel extends JPanel {
	
	public PanelInteractivePanel() {
		Dimension dimension = Utils.DIMENSION;
		dimension.height=300;
		dimension.width -=100;
		
		setLayout(new GridLayout());
		setPreferredSize(dimension);
		setBackground(Color.white);
		setBorder(new EmptyBorder(10,10,10,10));
		
		CustomButton gButton = new CustomButton("asda");
		CustomButton gButton2 = new CustomButton("asdasad");
		CustomButton gButton3 = new CustomButton("asdasad");
		CustomButton gButton4 = new CustomButton("asdaqwe");
		CustomButton gButton5 = new CustomButton("asdaqwe");
		
		add(gButton);
		add(gButton2);
		add(gButton3);
		add(gButton4);
		add(gButton5);
		
	}
}
