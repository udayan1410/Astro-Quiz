package interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DBhelper;
import model.QuestionCategory;
import model.Questions;

public interface QuestionListMaker {
	DBhelper dBhelper = DBhelper.getReference();
	Map<Integer,QuestionCategory> map = new HashMap();
	public void populateMap();
	public List<Questions> getQuestionsList();
}
