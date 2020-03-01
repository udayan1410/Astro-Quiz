package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interfaces.CustomButtonCommunicator;
import interfaces.QuestionType;
import model.Questions;

public class ComponentTFQuestion extends PanelQuestionPanel implements QuestionType {
	private Questions questions;
	private CustomButton trueButton,falseButton;

	public ComponentTFQuestion(Questions questions) {		
		this.questions = questions;
		displayQuestion(questions);
		
		
		trueButton = new CustomButton("True");
		trueButton.setButtonCommunicator(new ButtonCommunicatorAdapter());
		falseButton = new CustomButton("False");
		falseButton.setButtonCommunicator(new ButtonCommunicatorAdapter());
		
		
		add(trueButton);
		add(Box.createRigidArea(new Dimension(0,13)));
		add(falseButton);
	}
	
	public class ButtonCommunicatorAdapter implements CustomButtonCommunicator{

		@Override
		public void buttonClicked(String userAnswer) {
			RBclicked(userAnswer);
		}
		
	}
}
