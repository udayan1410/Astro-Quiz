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

import model.Score;

public class WindowScoreScreen extends JFrame {

	Score score;
	private PanelHighScorePanel highScorePanel;
	private PanelStatsPanel statsPanel;

	public WindowScoreScreen(Score score) {
		this.score = score;
/*
		// piedataset
		PieDataset dataset = createDataset();

		JFreeChart chart = createChart(dataset, "Sample Title");
			
		ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        //setContentPane(chartPanel);
		

		JPanel panel = new JPanel();
		panel.add(chartPanel);
  */
		
		//High Score Panel		
		highScorePanel = new PanelHighScorePanel(score);
		statsPanel = new PanelStatsPanel(score);
				
		// Creating window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());

		add(highScorePanel,BorderLayout.WEST);
		add(statsPanel,BorderLayout.CENTER);
	}
	
	

	public PieDataset createDataset() {
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Linux", 29);
		result.setValue("Windows", 10);
		result.setValue("Mac", 30);
		return result;
	}

	public JFreeChart createChart(PieDataset dataset, String title) {
		JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}

}
