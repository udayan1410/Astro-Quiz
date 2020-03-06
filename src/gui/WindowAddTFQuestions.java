package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.title.Title;

import database.DBhelper;
import interfaces.CustomButtonCommunicator;
import model.Questions;

public class WindowAddTFQuestions extends JFrame {

	private JLabel enterQuestion, enterAnswer, enterDifficulty;
	private JTextArea question;
	private JTextField answer, difficulty;
	private CustomButton submit, back;
	private  String questionType;

	public WindowAddTFQuestions(String questionType) {

		this.questionType = questionType;
		System.out.println(this.questionType);
		
		setTitle("Space Quiz");

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));

		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		enterQuestion = new JLabel("Enter Question");
		enterQuestion.setForeground(new Color(255, 255, 255));
		enterQuestion.setBackground(new Color(0, 0, 0));
		enterQuestion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		enterQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		enterQuestion.setVerticalAlignment(SwingConstants.CENTER);
		enterQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);

		question = new JTextArea(1, 20);
		question.setVisible(true);
		question.setMaximumSize(new Dimension(1000, 70));
		question.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

		enterDifficulty = new JLabel("Enter Difficulty");
		enterDifficulty.setForeground(new Color(255, 255, 255));
		enterDifficulty.setBackground(new Color(0, 0, 0));
		enterDifficulty.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		enterDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		enterDifficulty.setVerticalAlignment(SwingConstants.CENTER);
		enterDifficulty.setAlignmentX(Component.CENTER_ALIGNMENT);

		difficulty = new JTextField();
		difficulty.setMinimumSize(new Dimension(260, 40));
		difficulty.setMaximumSize(new Dimension(260, 40));
		difficulty.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

		enterAnswer = new JLabel("Enter the Answer");
		enterAnswer.setForeground(new Color(255, 255, 255));
		enterAnswer.setBackground(new Color(0, 0, 0));
		enterAnswer.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		enterAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		enterAnswer.setVerticalAlignment(SwingConstants.CENTER);
		enterAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);

		answer = new JTextField();
		answer.setMinimumSize(new Dimension(260, 40));
		answer.setMaximumSize(new Dimension(260, 40));
		answer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

		submit = new CustomButton("Submit");
		submit.setButtonCommunicator(new CustomButtonCommunicator() {

			@Override
			public void buttonClicked(String userAnswer) {
				
				Questions questions = new Questions();
				questions.setQuestion(question.getText());
				questions.setAnswer(answer.getText());
				questions.setQuestionDifficulty(difficulty.getText());
				questions.setQuestionType(questionType);
				
				DBhelper.getReference().addQuestion(questions);
				setVisible(false);
				new WindowAddQuestions();
				dispose();
			}
		});

		back = new CustomButton("Back");
		back.setButtonCommunicator(new CustomButtonCommunicator() {

			@Override
			public void buttonClicked(String userAnswer) {
				setVisible(false);
				new WindowAddQuestions();
				dispose();
			}
		});

		add(new PanelTitlePanel());
		add(Box.createRigidArea(new Dimension(0, 70)));
		add(enterQuestion);
		add(question);
		add(enterDifficulty);
		add(difficulty);
		add(enterAnswer);
		add(answer);
		add(Box.createRigidArea(new Dimension(0, 70)));
		add(submit);
		add(back);

		setVisible(true);


	private JTextField answer,difficulty;
	private CustomButton submit,back;
	
	public WindowAddTFQuestions() {
		// TODO Auto-generated constructor stub
	
	setTitle("Space Quiz");

	setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));

	this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

	enterQuestion = new JLabel("Enter Question");
	enterQuestion.setForeground(new Color(255, 255, 255));
	enterQuestion.setBackground(new Color(0, 0, 0));
	enterQuestion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
	enterQuestion.setHorizontalAlignment(SwingConstants.CENTER);
	enterQuestion.setVerticalAlignment(SwingConstants.CENTER);
	enterQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	question = new JTextArea(1,20);
	question.setVisible(true);
	question.setMaximumSize(new Dimension(1000,70));
	question.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
	
	enterDifficulty = new JLabel("Enter Difficulty");
	enterDifficulty.setForeground(new Color(255, 255, 255));
	enterDifficulty.setBackground(new Color(0, 0, 0));
	enterDifficulty.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
	enterDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
	enterDifficulty.setVerticalAlignment(SwingConstants.CENTER);
	enterDifficulty.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	difficulty = new JTextField();
	difficulty.setMinimumSize(new Dimension(260, 40));
	difficulty.setMaximumSize(new Dimension(260, 40));
	difficulty.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	
	enterAnswer = new JLabel("Enter the Answer");
	enterAnswer.setForeground(new Color(255, 255, 255));
	enterAnswer.setBackground(new Color(0, 0, 0));
	enterAnswer.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
	enterAnswer.setHorizontalAlignment(SwingConstants.CENTER);
	enterAnswer.setVerticalAlignment(SwingConstants.CENTER);
	enterAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	answer = new JTextField();
	answer.setMinimumSize(new Dimension(260, 40));
	answer.setMaximumSize(new Dimension(260, 40));
	answer.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	
	submit = new CustomButton("Submit");
	submit.setButtonCommunicator(new CustomButtonCommunicator() {

		@Override
		public void buttonClicked(String userAnswer) {
			
			
			
			setVisible(false);
			new WindowAddQuestions();
			dispose();
		}
	});
	
	back = new CustomButton("Back");
	back.setButtonCommunicator(new CustomButtonCommunicator() {

		@Override
		public void buttonClicked(String userAnswer) {
			// TODO Auto-generated method stub
			setVisible(false);
			new WindowAddQuestions();
			dispose();
		}
	});
	
	
	add(new PanelTitlePanel());
	add(Box.createRigidArea(new Dimension(0, 70)));
	add(enterQuestion);
	add(question);
	add(Box.createRigidArea(new Dimension(0, 13)));
	add(enterDifficulty);
	add(difficulty);
	add(Box.createRigidArea(new Dimension(0, 13)));
	add(enterAnswer);
	add(answer);
	add(Box.createRigidArea(new Dimension(0, 50)));
	add(submit);
	add(Box.createRigidArea(new Dimension(0, 13)));
	add(back);
	
	setVisible(true);
	
	
	
	}
}
