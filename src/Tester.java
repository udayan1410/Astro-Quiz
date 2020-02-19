import java.util.ArrayList;
import java.util.List;

import database.DBhelper;
import model.Questions;
import model.RadioButtonQuestions;



public class Tester {
	List<Questions> firstHalfList = new ArrayList();
	static DBhelper dBhelper;
	
	Tester(){
		dBhelper = DBhelper.getReference();		
	}
	
	public static void main(String args[]){					
		Tester tester = new Tester();
			
	}
	
}
