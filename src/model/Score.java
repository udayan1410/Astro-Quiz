package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import interfaces.QuestionListMaker;

public class Score {
	private List<Questions> questionsList = new ArrayList();
	private int correctAnswers, currentQuestion,firstHalfResult;
	private QuestionListMaker listMaker;

	public Score() {
		correctAnswers = 0;
		currentQuestion = 1;
		initializeList();
	}

	public boolean checkAnswer(String userAnswer, String actualAnswer) {
		currentQuestion += 1;

		if (currentQuestion == 11)
			updateList();

		if (userAnswer.equalsIgnoreCase(actualAnswer)) {
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
			System.out.println("Done with quiz");
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
			finalScore = (int)((correctAnswers - firstHalfResult)*0.70);
		}
		else if (listMaker instanceof CategoryMedium){			
			finalScore = correctAnswers;
		}
		else {					
			int secondHalfResult = correctAnswers-firstHalfResult;
			if(secondHalfResult<=8)
				secondHalfResult+=2;
			finalScore = secondHalfResult+firstHalfResult;
		}
		
		return finalScore;
	}
	
}
