package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Image;
import java.awt.Toolkit;

public class PanelTitlePanel extends JPanel{

	JLabel label;
	
	
	public PanelTitlePanel() {
		Dimension dimension = getPreferredSize();
		dimension.height = 120;
		setPreferredSize(dimension);
		
				
		setBackground(new Color(0,0,0));
		
		label = new JLabel(" A S T R O  Q U I Z ");		
		Font font = new Font(Font.MONOSPACED,Font.BOLD , 60);		
		label.setForeground(new Color(255,255,255));
		label.setBorder(new EmptyBorder(20,10,10,10));		
		label.setFont(font);
			
		
		add(label);
		
	}
	
}
