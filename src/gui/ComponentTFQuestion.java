package gui;

import javax.swing.JPanel;

import interfaces.QuestionType;
import model.Questions;

public class ComponentTFQuestion extends PanelQuestionPanel implements  QuestionType{
	private Questions questions;

	public ComponentTFQuestion(Questions questions) {
		super(40);
		this.questions = questions;
		System.out.println("in Tf");
	}
}
