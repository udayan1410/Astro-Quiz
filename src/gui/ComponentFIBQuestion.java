package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interfaces.QuestionType;
import model.Questions;

public class ComponentFIBQuestion extends PanelQuestionPanel implements QuestionType {
	
	private Questions questions;

	public ComponentFIBQuestion(Questions questions) {
		
		this.questions = questions;
		displayQuestion(questions);
	}

}
