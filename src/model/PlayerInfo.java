package model;

import interfaces.QuestionListMaker;

public class PlayerInfo {
	
	private String playerName;
	private int rbQuestion;
	private int fibQuestion;
	private int tfQuestion;
	private int intQuestion;
	private int firstHalfResults;
	private int correctAnswers;
	private int finalScoreValue;
	
	
	
	public int getFinalScoreValue() {
		return finalScoreValue;
	}
	public void setFinalScoreValue(int finalScoreValue) {
		this.finalScoreValue = finalScoreValue;
	}
	public String getPlayerName() {
		return playerName;
	}
	public int getRbQuestion() {
		return rbQuestion;
	}
	public int getFibQuestion() {
		return fibQuestion;
	}
	public int getTfQuestion() {
		return tfQuestion;
	}
	public int getIntQuestion() {
		return intQuestion;
	}
	public int getFirstHalfResults() {
		return firstHalfResults;
	}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setRbQuestion(int rbQuestion) {
		this.rbQuestion = rbQuestion;
	}
	public void setFibQuestion(int fibQuestion) {
		this.fibQuestion = fibQuestion;
	}
	public void setTfQuestion(int tfQuestion) {
		this.tfQuestion = tfQuestion;
	}
	public void setIntQuestion(int intQuestion) {
		this.intQuestion = intQuestion;
	}
	public void setFirstHalfResults(int firstHalfResults) {
		this.firstHalfResults = firstHalfResults;
	}
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	
	
	
	
	
}
