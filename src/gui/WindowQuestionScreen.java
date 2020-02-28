package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import utilities.Utils;
import javax.swing.JFrame;
import interfaces.QuestionType;
import interfaces.TimeOut;
import model.Questions;
import model.Score;

public class WindowQuestionScreen extends JFrame {

	private Score score = new Score();
	private PanelQuestionPanel questionPanel;
	private PanelTitlePanel titlePanel;
	private TimeOut timeOut;
	private PanelTimePanel timePanel;

	public WindowQuestionScreen() {
		super("ASTRO QUIZ");

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);

		titlePanel = new PanelTitlePanel();
		add(titlePanel,BorderLayout.NORTH);
		updatePanel();
	}

	public void updatePanel() {
		if (score.hasNext()) {
			timePanel = new PanelTimePanel();
			setTimeOut();		
			timePanel.setCurrentQuestion(score.currentQuestion);
			add(timePanel, BorderLayout.WEST);
			Questions questions = score.getNextQuestion();
			questionPanel = Utils.getQuestionPanel(questions);
			add(questionPanel, BorderLayout.CENTER);
			validate();
			repaint();
			score.checkAnswer(questions.getAnswer(), questions.getAnswer());			
		} else {
			System.out.println(score.getFinalScore());
		}
	}

	public void setTimeOut() {
		timePanel.setTimeOut(new TimeOut() {
			@Override
			public void timeOver() {
				remove(questionPanel);
				remove(timePanel);
				updatePanel();
			}
		});
	}

}
