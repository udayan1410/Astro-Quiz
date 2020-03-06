package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

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

import interfaces.CustomButtonCommunicator;

public class WindowAddRBQuestion extends JFrame{

	private JLabel Options,ans,typeDiff;
	private JTextArea enterQuestion;
	private JTextField op1,op2,op3,op4,answer,type;
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
		
		type = new JTextField();
		type.setMinimumSize(new Dimension(260, 40));
		type.setMaximumSize(new Dimension(260, 40));
		type.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		
		
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
		
		//add(new PanelTitlePanel());
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(enterQuestion);
		add(typeDiff);
		add(Box.createRigidArea(new Dimension(0, 13)));
		add(type);
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
