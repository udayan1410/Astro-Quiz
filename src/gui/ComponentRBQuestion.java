package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.QuestionType;
import model.Questions;
import model.RadioButtonQuestions;

public class ComponentRBQuestion extends PanelQuestionPanel implements QuestionType{
	private Questions questions;
	private JLabel label;
	
	public ComponentRBQuestion(Questions questions) {	
		super(180);
		this.questions = questions;		
		System.out.println("in rb");
	}
}
