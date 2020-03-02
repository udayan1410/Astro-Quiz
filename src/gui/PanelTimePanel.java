package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import interfaces.TimeOut;
import utilities.Utils;



public class PanelTimePanel extends JPanel {

	private JLabel label,clockGIF,curQuestion;	
	private TimeOut timeOut;
	public int i = Utils.COUNTDOWN_INTEGER;
	private String currentQuestion;
	private final PanelTimePanel context;
	
	public PanelTimePanel() {
		this.context = this;
		
		setOpaque(false);
		//Layout and dimensions
		//setBorder(BorderFactory.createEtchedBorder(Color.white,Color.black));
		setLayout(new FlowLayout(FlowLayout.TRAILING));				
		Dimension dimension = getPreferredSize();
		dimension.width = 250;
		setPreferredSize(dimension);
		setBackground(new Color(255,255,255));
		
		//Current question		
		dimension = new Dimension(250,100);
		Font font = new Font(Font.MONOSPACED,Font.BOLD,34);
		curQuestion = new JLabel("1",SwingConstants.CENTER);
		curQuestion.setPreferredSize(dimension);
		curQuestion.setForeground(new Color(255,255,255));
		curQuestion.setBackground(new Color(0,0,0));
		curQuestion.setFont(font);
		
		//Clock GIF
		clockGIF = new JLabel("",SwingConstants.CENTER);
		clockGIF.setPreferredSize(new Dimension(250,430));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("./assets/transparent2.gif"));
		clockGIF.setIcon(icon);		
		
		//Time Label
		font = new Font(Font.MONOSPACED,Font.PLAIN,40);
		label = new JLabel("Time :"+i,SwingConstants.CENTER);
		label.setForeground(new Color(255,255,255));
		label.setBackground(new Color(0,0,0));
		label.setFont(font);
		
		//label.setBorder(BorderFactory.createEtchedBorder());
		label.setPreferredSize(new Dimension(250,100));
		
		//Timer Logic
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (i>=0) {
					label.setText("Time :" + i);
					try {
						Thread.sleep(1000);						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					i -= 1;
					label.setText("Time :"+Utils.COUNTDOWN_INTEGER);
				}
				timeOut.timeOver(context);
			}
		}).start();

		add(curQuestion);
		add(clockGIF);		
		add(label);	
	}

	
	public void setTimeOut(TimeOut timeOut){
		this.timeOut = timeOut;	
	}
	
	public void setCurrentQuestion(int currentQuestion){
		this.currentQuestion = String.valueOf(currentQuestion);		
		curQuestion.setText("Q.No : "+currentQuestion+"/20");
	}
	
	public String toString(){
		return currentQuestion;
	}
	
	
	@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
		Graphics2D g2d = (Graphics2D) grphcs;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 0, new Color(36, 11, 54), 0, 880, new Color(195, 20, 50));

		// GradientPaint gPaint = new GradientPaint(0,new Color(115,3,192))

		g2d.setPaint(gp);
		g2d.fillRect(0, 0, getWidth(), getHeight());

	}
	
	
}
