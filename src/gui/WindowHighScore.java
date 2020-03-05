package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.stage.ScreenHelper;

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

		listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500, 500));
		// listPanel.setOpaque(false);
		listPanel.setBackground(Color.BLUE);
		addDataListToPanel();

		add(new PanelTitlePanel());
		add(listPanel);

		setVisible(true);
	}

	public void loadDataFromDB() {
		playerInfoList = DBhelper.getReference().getScoreData();

		/*
		 * score.answerCalculator.rbQuestion=info.getRbQuestion();
		 * score.answerCalculator.fibQuestion=info.getFibQuestion();
		 * score.answerCalculator.tfQuestion=info.getTfQuestion();
		 * score.answerCalculator.intQuestion = info.getIntQuestion();
		 * score.setFirstHalfResult(info.getFirstHalfResults());
		 * score.setCorrectAnswers(info.getCorrectAnswers());
		 * score.setFinalScoreValue(info.getFinalScoreValue());
		 * score.setChangeFlag();
		 */
	}

	public void addDataListToPanel() {
		CustomButton[] customButtons = new CustomButton[playerInfoList.size()];

		for (int i = 0; i < playerInfoList.size(); i++) {
			customButtons[i] = new CustomButton(playerInfoList.get(i).getPlayerName());
			this.i = i;
			customButtons[i].setButtonCommunicator(new CustomButtonCommunicator() {

				@Override
				public void buttonClicked(String userAnswer) {
					callScoreWindow(userAnswer);
				}
			});
			listPanel.add(customButtons[i]);

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
