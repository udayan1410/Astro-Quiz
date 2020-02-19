package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import interfaces.QuestionListMaker;


public class Score {
	private List<Questions> questionsList = new ArrayList();
	private int correctAnswers,currentQuestion;	
	private QuestionListMaker listMaker; 
	
	public Score() {		
		correctAnswers = 0;
		currentQuestion = 1;				
		initializeList();
	}	
	
	public boolean check(String userAnswer,String actualAnswer){
		currentQuestion+=1;
		
		if(currentQuestion==11)
			updateList();					
		
		if(userAnswer.equalsIgnoreCase(actualAnswer)){
			correctAnswers+=1;						
			return true;
		}	
		return false;
	}
	
	private void updateList(){
		questionsList.clear();
		if(correctAnswers<5)
			listMaker = new CategoryEasy();
			
		else if(correctAnswers>=5 && correctAnswers<=7)
			listMaker= new CategoryMedium();
		 
		else if(correctAnswers>7)
			listMaker= new CategoryHard();			
		questionsList = listMaker.getQuestionsList();
	}
	
	private void initializeList(){
		listMaker = new CategoryFirstHalf();
		questionsList = listMaker.getQuestionsList();
	}
	
	public Questions getNextQuestion(){
		return questionsList.get(currentQuestion);
	}
	
}
