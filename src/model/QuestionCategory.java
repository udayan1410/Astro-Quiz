package model;

public class QuestionCategory {
	private String qType;
	private String qDifficulty;
	
	public QuestionCategory(String qTtpe,String qDifficulty){
		this.qType = qTtpe;
		this.qDifficulty = qDifficulty;
	}
	
	
	public String getqType() {
		return qType;
	}
	public String getqDifficulty() {
		return qDifficulty;
	}
	public void setqType(String qType) {
		this.qType = qType;
	}
	public void setqDifficulty(String qDifficulty) {
		this.qDifficulty = qDifficulty;
	}	
	
}
