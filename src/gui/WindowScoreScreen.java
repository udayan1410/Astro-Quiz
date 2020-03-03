package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.data.general.PieDataset;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import interfaces.CustomButtonCommunicator;
import model.Score;

public class WindowScoreScreen extends JFrame {
	private Score score;
	private PanelHighScorePanel highScorePanel;
	private PanelStatsPanel statsPanel;

	public WindowScoreScreen(Score score) {
		this.score = score;
		
		//High Score Panel		
		highScorePanel = new PanelHighScorePanel(this.score, new ButtonCommunicator());
		statsPanel = new PanelStatsPanel(this.score);
				
		// Creating window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		add(highScorePanel,BorderLayout.WEST);
		add(statsPanel,BorderLayout.CENTER);
	}
	
	
	class ButtonCommunicator implements CustomButtonCommunicator{
		@Override
		public void buttonClicked(String userAnswer) {
			setVisible(false);
			switch (userAnswer) {
			case "TRY AGAIN":			
				new WindowStartScreen();				
				break;				
			}	
			dispose();
		}
	}
	
	
	
}
