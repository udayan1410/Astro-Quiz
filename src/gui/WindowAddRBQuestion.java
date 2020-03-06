package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.lang.String;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import database.DBhelper;
import interfaces.CustomButtonCommunicator;
import model.Questions;
import model.RadioButtonQuestions;

public class WindowAddRBQuestion extends JFrame{

	private JLabel Options,ans,typeDiff;
	private JTextArea enterQuestion;
	private JTextField op1,op2,op3,op4,answer,difficulty;
	private CustomButton submit,back;
	public WindowAddRBQuestion() {
	   
		//setTitle("Space Quiz");

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));

		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		
		typeDiff = new JLabel("Enter Difficulty");
		typeDiff.setForeground(new Color(255, 255, 255));
		typeDiff.setBackground(new Color(0, 0, 0));
		typeDiff.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		typeDiff.setHorizontalAlignment(SwingConstants.CENTER);
		typeDiff.setVerticalAlignment(SwingConstants.CENTER);
		typeDiff.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		difficulty = new JTextField();
		difficulty.setMinimumSize(new Dimension(260, 40));
		difficulty.setMaximumSize(new Dimension(260, 40));
		difficulty.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		
		
		enterQuestion = new JTextArea(1,20);
		enterQuestion.setVisible(true);
		enterQuestion.setMaximumSize(new Dimension(1000,70));
		enterQuestion.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		
		Options = new JLabel("Enter the Options");
		Options.setForeground(new Color(255, 255, 255));
		Options.setBackground(new Color(0, 0, 0));
		Options.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		Options.setHorizontalAlignment(SwingConstants.CENTER);
		Options.setVerticalAlignment(SwingConstants.CENTER);
		Options.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		op1 = new JTextField();
		op1.setMinimumSize(new Dimension(260, 40));
		op1.setMaximumSize(new Dimension(260, 40));
		op1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		
		op2 = new JTextField();
		op2.setMinimumSize(new Dimension(260, 40));
		op2.setMaximumSize(new Dimension(260, 40));
		op2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		
		op3 = new JTextField();
		op3.setMinimumSize(new Dimension(260, 40));
		op3.setMaximumSize(new Dimension(260, 40));
		op3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		
		op4 = new JTextField();
		op4.setMinimumSize(new Dimension(260, 40));
		op4.setMaximumSize(new Dimension(260, 40));
		op4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		
		ans = new JLabel("Enter the Answer");
		ans.setForeground(new Color(255, 255, 255));
		ans.setBackground(new Color(0, 0, 0));
		ans.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		ans.setHorizontalAlignment(SwingConstants.CENTER);
		ans.setVerticalAlignment(SwingConstants.CENTER);
		ans.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		answer = new JTextField();
		answer.setMinimumSize(new Dimension(260, 40));
		answer.setMaximumSize(new Dimension(260, 40));
		answer.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		
		submit = new CustomButton("Submit");
		submit.setButtonCommunicator(new CustomButtonCommunicator() {

			@Override
			public void buttonClicked(String userAnswer) {	
				Questions questions = new RadioButtonQuestions();
				questions.setQuestion(enterQuestion.getText());
				questions.setQuestionDifficulty(difficulty.getText());
				questions.setQuestionType("Radio Button");				
				
				String[] optionsArray = new String[4];
				optionsArray[0]=(op1.getText().equalsIgnoreCase(answer.getText())?answer.getText().toUpperCase():op1.getText())+"/";
				optionsArray[1]=(op2.getText().equalsIgnoreCase(answer.getText())?answer.getText().toUpperCase():op2.getText())+"/";
				optionsArray[2]=(op3.getText().equalsIgnoreCase(answer.getText())?answer.getText().toUpperCase():op3.getText())+"/";
				optionsArray[3]=(op4.getText().equalsIgnoreCase(answer.getText())?answer.getText().toUpperCase():op4.getText());
				((RadioButtonQuestions)questions).setOptionsArray(optionsArray);
				
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
		
		//add(new PanelTitlePanel());
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(enterQuestion);
		add(typeDiff);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(difficulty);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(Options);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(op1);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(op2);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(op3);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(op4);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(ans);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(answer);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(submit);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(back);
		

		setVisible(true);
	}
}
