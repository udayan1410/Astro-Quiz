package database;

import java.sql.*;

import model.PlayerInfo;
import model.QuestionCategory;
import model.Questions;
import model.RadioButtonQuestions;
import utilities.Utils;

import java.util.*;

public class DBhelper {
	private static DBhelper dbhelper;
	private Connection connection;
	private Statement statement;
	private static List<Questions> fullList = new ArrayList();

	private DBhelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/space_quiz", "root", "edengarden");
			statement = connection.createStatement();
			fullList = populateList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBhelper getReference() {
		if (dbhelper == null)
			dbhelper = new DBhelper();
		return dbhelper;
	}

	public List<Questions> populateList() {
		List<Questions> qList = new ArrayList();
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM qnapool natural Join qinfo;");

			while (rs.next()) {
				Integer id = Integer.parseInt(rs.getString(1));
				String question = rs.getString(2);
				String answer = rs.getString(3);
				String qType = rs.getString(4);
				String qDifficulty = rs.getString(5);
				if (qType.equalsIgnoreCase("RB")) {
					RadioButtonQuestions radioButtonQuestions = new RadioButtonQuestions();
					radioButtonQuestions.setOptionsArray(answer.split("/"));
					radioButtonQuestions.setId(id);
					radioButtonQuestions.setQuestion(question);
					radioButtonQuestions.setQuestionType(qType);
					radioButtonQuestions.setQuestionDifficulty(qDifficulty);

					qList.add(radioButtonQuestions);
				} else
					qList.add(new Questions(id, question, answer, qType, qDifficulty));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return qList;
	}

	public Questions getByTypeAndDifficulty(QuestionCategory category) {

		for (int i = 0; i < fullList.size(); i++) {
			Questions listQuestions = fullList.get(i);
			if (listQuestions.getQuestionType().equalsIgnoreCase(category.getqType())
					&& listQuestions.getQuestionDifficulty().equalsIgnoreCase(category.getqDifficulty())) {
				return fullList.remove(i);
			}
		}
		return null;
	}

	public void insertHighScore(PlayerInfo info) {
		try {
			String sqlString = "replace into highscore values('" + info.getPlayerName() + "'," + info.getRbQuestion()
					+ "," + info.getFibQuestion() + "," + info.getTfQuestion() + "," + info.getIntQuestion() + ","
					+ info.getCorrectAnswers() + "," + info.getFirstHalfResults() + "," + info.getFinalScoreValue()
					+ ");";

			statement.executeUpdate(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<PlayerInfo> getScoreData() {

		List<PlayerInfo> playerInfos = new ArrayList();
		try {
			ResultSet rSet = statement.executeQuery("SELECT * FROM highscore");
			while (rSet.next()) {
				PlayerInfo info = new PlayerInfo();
				info.setPlayerName(rSet.getString(1));
				info.setRbQuestion(Integer.parseInt(rSet.getString(2)));
				info.setFibQuestion(Integer.parseInt(rSet.getString(3)));
				info.setTfQuestion(Integer.parseInt(rSet.getString(4)));
				info.setIntQuestion(Integer.parseInt(rSet.getString(5)));
				info.setCorrectAnswers(Integer.parseInt(rSet.getString(6)));
				info.setFirstHalfResults(Integer.parseInt(rSet.getString(7)));
				info.setFinalScoreValue(Integer.parseInt(rSet.getString(8)));
				playerInfos.add(info);
			}
		} catch (Exception e) {
		}

		return playerInfos;
	}

	public void addQuestion(Questions questions) {

		String qTypeString = Utils.getQType(questions);
		List<Questions> qList = populateList();
		int currentID = qList.get(qList.size() - 1).getId() + 1;
		questions.setId(currentID);

		String insertIntoQnaPool = "";
		if (qTypeString.equalsIgnoreCase("RB")) {			
			insertIntoQnaPool = "Insert into qnapool values('" + questions.getId() + "','" + questions.getQuestion()
					+ "','" + ((RadioButtonQuestions) questions).getOptionsArray() + "');";
		} else {
			insertIntoQnaPool = "Insert into qnapool values('" + questions.getId() + "','" + questions.getQuestion()
					+ "','" + questions.getAnswer() + "');";
		}
		String insertIntoQinfo = "Insert into qinfo values('" + questions.getId() + "','" + qTypeString + "','"
				+ questions.getQuestionDifficulty() + "');";
		try {
			statement.executeUpdate(insertIntoQnaPool);
			statement.executeUpdate(insertIntoQinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
