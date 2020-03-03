package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import interfaces.QuestionListMaker;

public class Score {
	private List<Questions> questionsList = new ArrayList();
	private int correctAnswers,firstHalfResult;
	public int currentQuestion;
	private QuestionListMaker listMaker;
	public AnswerCalculator answerCalculator = new AnswerCalculator();
	
	public Score() {
		correctAnswers = 0;
		currentQuestion = 1;
		initializeList();
	}

	public boolean checkAnswer(String actualAnswer, String userAnswer, Questions questions) {		
		currentQuestion += 1;		
		userAnswer = userAnswer.trim();		
		if (currentQuestion == 11)
			updateList();

		if (userAnswer.equalsIgnoreCase(actualAnswer)) {
			updateAnswerCounter(questions);
			correctAnswers += 1;
			return true;
		}
		return false;
	}

	private void updateList() {
		questionsList.clear();
		firstHalfResult = correctAnswers;
		if (correctAnswers < 5)
			listMaker = new CategoryEasy();

		else if (correctAnswers >= 5 && correctAnswers <= 7)
			listMaker = new CategoryMedium();

		else if (correctAnswers > 7)
			listMaker = new CategoryHard();
		questionsList = listMaker.getQuestionsList();
	}

	private void initializeList() {
		listMaker = new CategoryFirstHalf();
		questionsList = listMaker.getQuestionsList();
	}

	public Questions getNextQuestion() {
		if (questionsList.isEmpty()) {
			//System.out.println("Done with quiz");
			return null;
		}
		return questionsList.remove(0);
	}
	
	public boolean hasNext(){
		return questionsList.size()>0?true:false;
	}

	public int getFinalScore(){
		int finalScore=0;
		if(listMaker instanceof CategoryEasy){			
			finalScore =firstHalfResult+ (int)((correctAnswers - firstHalfResult)*0.70);
			//System.out.println("Second category = Easy");
		}
		
		else if (listMaker instanceof CategoryMedium){			
			finalScore = correctAnswers;
			//System.out.println("Second category = Medium");
		}
	
		else {					
			int secondHalfResult = correctAnswers-firstHalfResult;
			if(secondHalfResult<=8)
				secondHalfResult+=2;
			finalScore = secondHalfResult+firstHalfResult;
			//System.out.println("Second category = Hard");
		}
		
		return finalScore;
	}
	
	public void setFinalScore(int num){
		this.correctAnswers = num;
	}
	
	public int getFirstHalfResult(){
		return firstHalfResult;
	}
	
	public void updateAnswerCounter(Questions questions){
		switch(questions.getQuestionType()){
		case "RB":
			answerCalculator.rbQuestion+=1;
			break;
		case "TF":
			answerCalculator.tfQuestion+=1;
			break;
		case "FIB":
			answerCalculator.fibQuestion+=1;
			break;
		case "INT":
			answerCalculator.intQuestion+=1;
			break;
			
		}
	}
}
