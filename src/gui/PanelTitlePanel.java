package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utilities.Utils;

import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

public class PanelTitlePanel extends JPanel {

	JLabel label;

	public PanelTitlePanel() {	
	    setBackground(new Color(40,15,122));
		label = new JLabel(" A S T R O  Q U I Z ", SwingConstants.CENTER);
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 70);
		label.setForeground(new Color(255, 218, 54));		
		label.setFont(font);
		setMaximumSize(new Dimension(Utils.DIMENSION.width,100));
		add(label);
	}

	/*@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
		Graphics2D g2d = (Graphics2D) grphcs;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 0, new Color(241, 39, 17), 0, 180, new Color(245, 175, 25));

		// GradientPaint gPaint = new GradientPaint(0,new Color(115,3,192))

		g2d.setPaint(gp);
		g2d.fillRect(0, 0, getWidth(), getHeight());

	}*/

}