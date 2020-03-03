package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Score;

public class PanelStatsPanel extends JPanel {
	private Score score;
	
	public PanelStatsPanel(Score score){
		this.score = score;
		Dimension dimension = getToolkit().getScreenSize();		
		
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setBackground(Color.BLUE);
	}

}
