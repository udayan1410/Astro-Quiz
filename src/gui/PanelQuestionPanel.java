package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.QuestionType;
import model.Questions;
import utilities.Utils;

public class PanelQuestionPanel extends JPanel{
	private Questions questions;
	private QuestionType questionType;
	
	
	public PanelQuestionPanel(int num){
		setBackground(new Color(100,70+num,200));
				
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		dimension.width -=200;
		dimension.height -= 200;
		setPreferredSize(dimension);
		
	}
	
	
}
