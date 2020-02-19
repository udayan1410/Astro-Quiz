package model;

public class Questions {
	private Integer id;
	private String question;
	private String answer;
	private String questionType;
	private String questionDifficulty;
		
	public Questions(Integer id,String question,String answer,String questionType,String questionDifficulty){
		this.id = id;
		this.question = question;		
		this.questionType = questionType;
		this.questionDifficulty = questionDifficulty;
		setAnswer(answer);
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
		if(this.getQuestionType().equalsIgnoreCase("RB")){
			String strArr[] = answer.split("/");
			for(int i=0;i<strArr.length;i++){
				String string = strArr[i];
				string = string.trim();
				if(string.charAt(0)>=65 && string.charAt(0)<=90){
					this.answer = string;
					return;
				}
			}
		}
		this.answer = answer;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public void setQuestionDifficulty(String questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}



	


}
