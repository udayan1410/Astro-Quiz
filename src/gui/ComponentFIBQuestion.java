package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interfaces.CustomButtonCommunicator;
import interfaces.QuestionType;
import model.Questions;

public class ComponentFIBQuestion extends PanelQuestionPanel implements QuestionType {

	private Questions questions;
	private JTextField textField;
	private CustomButton submitFIB;

	public ComponentFIBQuestion(Questions questions) {

		this.questions = questions;
		displayQuestion(questions);
				
		submitFIB = new CustomButton("SUBMIT");
		textField = new JTextField();
		
		
		//Adding textField
		textField.setActionCommand("FIBAnswer");
		textField.setMinimumSize(new Dimension(460, 60));
		textField.setMaximumSize(new Dimension(460, 60));
		textField.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,25));
		
		
		submitFIB.setButtonCommunicator(new CustomButtonCommunicator() {
			
			@Override
			public void buttonClicked(String userAnswer) {
				RBclicked(textField.getText());
			}
		} );
		
		add(textField);		
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(submitFIB);
	}

}
