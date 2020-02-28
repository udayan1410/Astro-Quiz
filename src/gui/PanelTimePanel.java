package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import interfaces.TimeOut;
import utilities.Utils;

import java.util.Timer;

public class PanelTimePanel extends JPanel {

	private JLabel label,clockGIF,curQuestion;	
	private TimeOut timeOut;
	public int i = Utils.COUNTDOWN_INTEGER;

	public PanelTimePanel() {

		setLayout(new FlowLayout(FlowLayout.TRAILING));
		Dimension dimension = getPreferredSize();
		dimension.width = 250;
		setPreferredSize(dimension);
		setBackground(new Color(255,255,255));
		
		//Current question		
		dimension = new Dimension(250,100);
		Font font = new Font(Font.MONOSPACED,Font.BOLD,32);
		curQuestion = new JLabel("1",SwingConstants.CENTER);
		curQuestion.setPreferredSize(dimension);
		curQuestion.setForeground(new Color(0,0,0));
		curQuestion.setBackground(new Color(0,0,0));
		curQuestion.setFont(font);
		
		//Clock GIF
		clockGIF = new JLabel("",SwingConstants.CENTER);
		clockGIF.setPreferredSize(new Dimension(250,300));
		ImageIcon icon = new ImageIcon(PanelTimePanel.this.getClass().getResource("./assets/clock.gif"));
		clockGIF.setIcon(icon);		
		
		//Time Label
		font = new Font(Font.MONOSPACED,Font.PLAIN,60);
		label = new JLabel(""+i,SwingConstants.CENTER);
		label.setForeground(new Color(0,0,0));
		label.setBackground(new Color(0,0,0));
		label.setFont(font);
		
		//label.setBorder(BorderFactory.createEtchedBorder());
		label.setPreferredSize(new Dimension(250,100));
		
		//Timer Logic
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (i>=0) {
					label.setText("" + i);
					try {
						Thread.sleep(1000);						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					i -= 1;
					label.setText(""+Utils.COUNTDOWN_INTEGER);
				}
				timeOut.timeOver();
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
		curQuestion.setText("Q.No : "+currentQuestion+"/20");
	}
	
}
