package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.QuestionType;
import model.Questions;

public class ComponentFIBQuestion extends PanelQuestionPanel implements QuestionType{
	private JLabel label;
	private Questions questions;
	
	public ComponentFIBQuestion(Questions questions) {
		super(-50);
		this.questions = questions;
		System.out.println("in fib");
	}		
	

}
