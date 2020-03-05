package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.stage.ScreenHelper;
import com.sun.rowset.internal.InsertRow;

import database.DBhelper;
import interfaces.CustomButtonCommunicator;
import model.PlayerInfo;
import model.Score;

public class WindowHighScore extends JFrame {
	private List<PlayerInfo> playerInfoList;
	private Score score = new Score();;
	private PlayerInfo info;
	private JPanel listPanel;
	private int i;

	public WindowHighScore() {
		loadDataFromDB();

		setTitle("HighScore Player Names");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		
		//Name Heading
		JLabel headingLabel = new JLabel("NAME");
		headingLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		headingLabel.setForeground(Color.white);

		//Score Heading
		JLabel resultLabel = new JLabel("SCORE");
		resultLabel .setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		resultLabel .setForeground(Color.white);
				
		//Panel to add Headings
		listPanel = new JPanel();
		listPanel.setMaximumSize(new Dimension(800, 50));
		listPanel.setMinimumSize(new Dimension(800, 50));
		listPanel.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
		listPanel.setOpaque(false);
		listPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 220, 0));
		listPanel.add(headingLabel);
		listPanel.add(resultLabel);

		//BackButton Panel
		CustomButton backButton = new CustomButton("BACK");
		backButton.setSize(new Dimension(500,60));
		backButton.setButtonCommunicator(new CustomButtonCommunicator() {		
			@Override
			public void buttonClicked(String userAnswer) {
				setVisible(false);
				new WindowStartScreen();
				dispose();
			}
		});
		JPanel backPanel = new JPanel();
		backPanel.setBorder(new EmptyBorder(new Insets(50,0,0,0)));
		backPanel.setOpaque(false);
		backPanel.add(backButton);
		
		
		//Adding all data to UI
		add(new PanelTitlePanel());
		add(Box.createRigidArea(new Dimension(20, 20)));
		add(listPanel);
		addDataListToPanel();
		add(backPanel);
		setVisible(true);
	}

	public void loadDataFromDB() {
		playerInfoList = DBhelper.getReference().getScoreData();
	}

	public void addDataListToPanel() {
		CustomButton[] customButtons = new CustomButton[playerInfoList.size()];
		JPanel[] panels = new JPanel[playerInfoList.size()];
		for (int i = 0; i < playerInfoList.size(); i++) {

			panels[i] = new JPanel();
			panels[i].setMaximumSize(new Dimension(800, 50));
			panels[i].setMinimumSize(new Dimension(800, 50));
			panels[i].setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
			panels[i].setOpaque(false);
			panels[i].setLayout(new FlowLayout(FlowLayout.CENTER, 300, 0));

			customButtons[i] = new CustomButton(playerInfoList.get(i).getPlayerName());
			customButtons[i].setBorder(new EmptyBorder(0, 0, 0, 0));
			customButtons[i].setButtonCommunicator(new ButtonClickHandler());
			panels[i].add(customButtons[i]);
			JLabel scoreLabel = new JLabel();
			scoreLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
			scoreLabel.setForeground(Color.white);
			scoreLabel.setText(String.valueOf(playerInfoList.get(i).getFinalScoreValue()));
			panels[i].add(scoreLabel);
			add(panels[i]);
		}
	}

	class ButtonClickHandler implements CustomButtonCommunicator{

		@Override
		public void buttonClicked(String userAnswer) {
			callScoreWindow(userAnswer);
		}
		
	}
	
	public void callScoreWindow(String playerName) {
		for (int i = 0; i < playerInfoList.size(); i++) {
			PlayerInfo info = playerInfoList.get(i);
			if (playerInfoList.get(i).getPlayerName().equalsIgnoreCase(playerName)) {
				score.answerCalculator.rbQuestion = info.getRbQuestion();
				score.answerCalculator.fibQuestion = info.getFibQuestion();
				score.answerCalculator.tfQuestion = info.getTfQuestion();
				score.answerCalculator.intQuestion = info.getIntQuestion();
				score.setFirstHalfResult(info.getFirstHalfResults());
				score.setCorrectAnswers(info.getCorrectAnswers());
				score.setFinalScoreValue(info.getFinalScoreValue());
				score.setChangeFlag();
				break;
			}
		}
		setVisible(false);
		new WindowScoreScreen(score);
		dispose();
	}
	
	

}
