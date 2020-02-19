package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import interfaces.QuestionListMaker;

public class CategoryFirstHalf implements QuestionListMaker {

	public CategoryFirstHalf() {
		populateMap();
	}
	
	@Override
	public void populateMap() {
		map.put(1,new QuestionCategory("RB","EASY"));
		map.put(2,new QuestionCategory("TF","EASY"));
		map.put(3,new QuestionCategory("RB","EASY"));
		map.put(4,new QuestionCategory("RB","EASY"));
		map.put(5,new QuestionCategory("FIB","MEDIUM"));
		map.put(6,new QuestionCategory("TF","MEDIUM"));
		map.put(7,new QuestionCategory("RB","MEDIUM"));
		map.put(8,new QuestionCategory("RB","HARD"));
		map.put(9,new QuestionCategory("FIB","HARD"));
		map.put(10,new QuestionCategory("INT","HARD"));			
	}

	@Override
	public List<Questions> getQuestionsList() {		
		List<Questions> list = new ArrayList();				
		for(Map.Entry<Integer,QuestionCategory> entry:map.entrySet())
			list.add(dBhelper.getByTypeAndDifficulty(entry.getValue()));
		
		return list;
	}
	
}
