package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;

import interfaces.CustomButtonCommunicator;
import interfaces.QuestionType;
import model.Questions;
import utilities.Utils;

public class ComponentINTQuestion extends PanelQuestionPanel implements QuestionType {
	private Questions questions;
	private JLabel userOutputJLabel;
	private JPanel horizontalPanel;
	private CustomButton clearButton, submitButton;

	public ComponentINTQuestion(Questions questions) {

		this.questions = questions;
		displayQuestion(questions);

		// Creating and setting answer label
		userOutputJLabel = new JLabel("Answer : ");
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 35);
		userOutputJLabel.setFont(font);
		userOutputJLabel.setForeground(Color.white);
		userOutputJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userOutputJLabel.setVerticalAlignment(SwingConstants.CENTER);
		userOutputJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Shuffle a string
		String answerString = questions.getAnswer();
		String opString = answerString;
		while (answerString.equals(opString)) {
			opString = shuffledString(answerString);
		}

		answerString = opString.toUpperCase();
		CustomInteractiveButton[] customButtons = new CustomInteractiveButton[answerString.length()];

		for (int i = 0; i < customButtons.length; i++) {
			customButtons[i] = new CustomInteractiveButton("" + answerString.charAt(i));
		}

		// Add horizontal Panel
		horizontalPanel = new JPanel();
		horizontalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		horizontalPanel.setOpaque(false);
		for (int i = 0; i < customButtons.length; i++) {
			horizontalPanel.add(customButtons[i]);
			customButtons[i].setButtonCommunicator(new ButtomCommunicator());
		}

		//horizontalPanel.setBorder(BorderFactory.createEtchedBorder());
		horizontalPanel.setMinimumSize(new Dimension(1200, 120));
		horizontalPanel.setMaximumSize(new Dimension(1200, 120));
		horizontalPanel.setOpaque(false);

		// Clear Button
		clearButton = new CustomButton("CLEAR");
		clearButton.setButtonCommunicator(new CustomButtonCommunicator() {
			
			@Override
			public void buttonClicked(String userAnswer) {
				userOutputJLabel.setText("Answer :");
			}
		});

		// Submit
		submitButton = new CustomButton("SUBMIT");
		submitButton.setButtonCommunicator(new CustomButtonCommunicator() {
			
			@Override
			public void buttonClicked(String userAnswer) {
				String interactiveAnswer[] = userOutputJLabel.getText().split(":");
				String opString="";
				for(int i=0;i<interactiveAnswer.length;i++)
					 opString = interactiveAnswer[i];					
				opString = opString.trim();
				RBclicked(opString);
			}
		});
		
		add(userOutputJLabel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(horizontalPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(clearButton);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(submitButton);
		add(Box.createRigidArea(new Dimension(0, 20)));

	}

	public String shuffledString(String answerString) {
		List<String> letters = Arrays.asList(answerString.split(""));
			
		Collections.shuffle(letters);
		String shuffledString = "";
		for (String letter : letters) 
			shuffledString += letter;		
		return shuffledString;
	}

	public class ButtomCommunicator implements CustomButtonCommunicator {
		@Override
		public void buttonClicked(String userAnswer) {
			String prevString = userOutputJLabel.getText();
			prevString += userAnswer;
			userOutputJLabel.setText(prevString);
		}
	}
}
