package model;

public class Questions {
	private Integer id;
	private String question;
	private String answer;
	private String questionType;
	private String questionDifficulty;
		
	
	public Questions() {
	}
	
	public Questions(Integer id,String question,String answer,String questionType,String questionDifficulty){
		this.id = id;
		this.question = question;		
		this.questionType = questionType;
		this.questionDifficulty = questionDifficulty;
		this.answer = answer;
	}


	public Integer getId() {
		return id;
	}
	
	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestionType() {
		return questionType;
	}
	public String getQuestionDifficulty() {
		return questionDifficulty;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setAnswer(String answer) {		
		this.answer = answer;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public void setQuestionDifficulty(String questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}
	
	public String toString(){
		return this.question+" "+this.answer+" "+this.questionType+" "+this.questionDifficulty+" \n";
		
	}

}
