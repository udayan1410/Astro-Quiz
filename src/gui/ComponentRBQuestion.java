package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import interfaces.CustomButtonCommunicator;
import interfaces.QuestionType;
import model.Questions;
import model.RadioButtonQuestions;

public class ComponentRBQuestion extends PanelQuestionPanel implements QuestionType{
	private Questions questions;
	private ButtonGroup buttonGroup;
	private CustomButton btnArray[];	
	
	
	public ComponentRBQuestion(Questions questions) {			
		this.questions = questions;		
		displayQuestion(questions);
		
		String optionsArray[] = ((RadioButtonQuestions)questions).getOptionsArray();
		btnArray = new CustomButton[optionsArray.length];
		
		for(int i=0;i<optionsArray.length;i++){
			btnArray[i] = new CustomButton(optionsArray[i]);	
			btnArray[i].setButtonCommunicator(new ButtonCommunicatorAdapter());
			add(btnArray[i]);
			add(Box.createRigidArea(new Dimension(0,13)));
		}				
		
	}
	
	
	public class ButtonCommunicatorAdapter implements CustomButtonCommunicator{

		@Override
		public void buttonClicked(String userAnswer) {
			RBclicked(userAnswer);
		}
		
	}
	
}
