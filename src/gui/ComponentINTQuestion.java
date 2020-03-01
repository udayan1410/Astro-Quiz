package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interfaces.QuestionType;
import model.Questions;

public class ComponentINTQuestion extends PanelQuestionPanel implements QuestionType {
	private Questions questions;
	
	
	public ComponentINTQuestion(Questions questions) {
		
		this.questions = questions;
		displayQuestion(questions);
	
		add(new PanelInteractivePanel());
	}
}
