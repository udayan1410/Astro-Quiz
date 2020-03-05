package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import demo.orsoncharts.PieChart3D2;
import model.Score;

public class PanelStatsPanel extends JPanel {
	private Score score;
	private JPanel panel1;
	private JPanel panel2;
	private ChartPanel pieChartPanel, barChartPanel;

	public PanelStatsPanel(Score score) {
		this.score = score;
		
		
		Dimension dimension = getToolkit().getScreenSize();
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setBackground(Color.black);

		// creating a barchart
		barChartPanel = createBarChart();
		barChartPanel.setPreferredSize(new Dimension(600, 310));

		// creating PieChart
		pieChartPanel = createPieChart();
		pieChartPanel.setPreferredSize(new Dimension(600, 310));

		// Creating 2 seperate Jpanels
		panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		Dimension panelDimension = getToolkit().getScreenSize();
		panelDimension.height /= 2;
		panel1.setMaximumSize(panelDimension);
		panel1.setMinimumSize(panelDimension);
		panel1.setPreferredSize(panelDimension);
		panel1.add(pieChartPanel);

		panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setMaximumSize(panelDimension);
		panel2.setMinimumSize(panelDimension);
		panel2.setPreferredSize(panelDimension);
		panel2.add(barChartPanel);

		add(panel1);
		add(panel2);
	}
	
	public ChartPanel createPieChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("RB", score.answerCalculator.rbQuestion);
		dataset.setValue("FIB", score.answerCalculator.fibQuestion);
		dataset.setValue("TF", score.answerCalculator.tfQuestion);
		dataset.setValue("INT", score.answerCalculator.intQuestion);

		JFreeChart chart = ChartFactory.createPieChart3D("Question Category", dataset, true, true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);

		return new ChartPanel(chart);
	}

	public ChartPanel createBarChart() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(score.getFirstHalfResult(), "First Section", "First Section");
		//System.out.println("Value 2 = "+(score.getFinalScoreValue()));
		dataset.addValue(score.getFinalScoreValue() - score.getFirstHalfResult(), "Second Section", "Second Section");

		JFreeChart barChart = ChartFactory.createBarChart("Performance In Sections", "Sections", "Score", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		return new ChartPanel(barChart);
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
		Graphics2D g2d = (Graphics2D) grphcs;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 0, new Color(36, 11, 54), 0, 900, new Color(195, 20, 50));
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, getWidth(), getHeight());

	}
}
