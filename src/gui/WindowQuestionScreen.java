package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import utilities.Utils;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import interfaces.CustomButtonCommunicator;
import interfaces.QuestionType;
import interfaces.TimeOut;
import model.Questions;
import model.Score;

public class WindowQuestionScreen extends JFrame {

	private Score score = new Score();
	private PanelQuestionPanel questionPanel;	
	private TimeOut timeOut;
	private PanelTimePanel timePanel;
	public Questions questions;

	public WindowQuestionScreen() {
		super("ASTRO QUIZ");

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		
		updatePanel();
	}

	public void updatePanel() {
		if (score.hasNext()) {
			
			timePanel = new PanelTimePanel();
			setTimeOut();			
			timePanel.setCurrentQuestion(score.currentQuestion);
			add(timePanel, BorderLayout.WEST);
			
			questions = score.getNextQuestion();
			questionPanel = Utils.getQuestionPanel(questions);
			questionPanel.setButtonCommunicator(new RBButtonCommunicator());			
			add(questionPanel, BorderLayout.CENTER);			
			
			validate();
			repaint();
			
		} else 
			System.out.println(score.getFinalScore());
		
	}

	public void callBackScreen(){
		remove(questionPanel);
		remove(timePanel);
		updatePanel();
	}
	
	
	public void setTimeOut() {
		timePanel.setTimeOut(new TimeOut() {
			@Override
			public void timeOver(PanelTimePanel context) {				
				if(timePanel == context){
					score.checkAnswer(questions.getAnswer(),"");
					callBackScreen();					
				}					
			}
		});
	}
	
	public class RBButtonCommunicator implements CustomButtonCommunicator{

		@Override
		public void buttonClicked(String userAnswer) {
			System.out.println("user answer = "+userAnswer+" actual = "+questions.getAnswer());
			score.checkAnswer(questions.getAnswer(),userAnswer);			
			callBackScreen();
		}
		
	}

}
