import java.util.List;

import database.DBhelper;
import model.Questions;

public class Tester {
	
	public static void main(String args[]){
		DBhelper dBhelper = DBhelper.getReference();
		
		List<Questions> qList = dBhelper.populateList();
		
		for(int i=0;i<qList.size();i++){
			Questions questions = qList.get(i);
			System.out.println(questions.getId()+" "+questions.getQuestion()+" "+questions.getAnswer()+" "+questions.getQuestionType()+" "+questions.getQuestionDifficulty());
		}
		
	}
	
}
