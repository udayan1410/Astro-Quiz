package gui;

import javax.swing.JPanel;

import interfaces.QuestionType;
import model.Questions;

public class ComponentINTQuestion extends PanelQuestionPanel implements QuestionType{
	private Questions questions;
	

	public ComponentINTQuestion(Questions questions) {
		super(100);
		this.questions = questions;	
		System.out.println("in int");
	}
}
