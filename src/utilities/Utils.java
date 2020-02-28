package utilities;

import gui.ComponentFIBQuestion;
import gui.ComponentINTQuestion;
import gui.ComponentRBQuestion;
import gui.ComponentTFQuestion;
import gui.PanelQuestionPanel;
import interfaces.QuestionType;
import model.Questions;

public class Utils {
	
	public static final Integer COUNTDOWN_INTEGER=2;
	
	public static PanelQuestionPanel getQuestionPanel(Questions questions){
		PanelQuestionPanel questionPanel=null;
		
		switch (questions.getQuestionType()) {
		case "RB":
			//System.out.println("in case RB");
			questionPanel = new ComponentRBQuestion(questions);
			break;
			
		case "FIB":
			//System.out.println("in case FIB");
			questionPanel = new ComponentFIBQuestion(questions);
			break;
			
		case "TF":
			//System.out.println("in case TF");
			questionPanel = new ComponentTFQuestion(questions);
			break;
		case "INT":
			//System.out.println("in case INT");
			questionPanel = new ComponentINTQuestion(questions);
			break;			
		}
		
		
		return questionPanel;
	}
	
}
