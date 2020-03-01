import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import database.DBhelper;
import gui.WindowQuestionScreen;
import gui.WindowStartScreen;
import model.Questions;
import model.RadioButtonQuestions;
import model.Score;

public class Tester {
	public static Scanner scanner;
	
	
	public static void main(String args[]){			
		//new WindowStartScreen();
		new WindowQuestionScreen();
		/*Score score = new Score();
		scanner =new Scanner(System.in);
		
		while(score.hasNext()){
			Questions questions = score.getNextQuestion(); 			
			System.out.println(questions.getQuestion()); 			
			String op = scanner.nextLine();
			score.checkAnswer(questions.getAnswer(),op);
		}
		System.out.println(score.getFinalScore());*/
	}
	
	
}
