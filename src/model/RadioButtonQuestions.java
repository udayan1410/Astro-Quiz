package model;

public class RadioButtonQuestions extends Questions {	
	private String[] optionsArray; 	
	
	public String[] getOptionsArray() {
		return optionsArray;
	}

	public void setOptionsArray(String[] optionsArray) {
		for(int i=0;i<optionsArray.length;i++){
			optionsArray[i]= optionsArray[i].trim();
			if(optionsArray[i].charAt(0)>=65 && optionsArray[i].charAt(0)<=90){
				this.setAnswer(optionsArray[i].toUpperCase());				
				break;
			}
		}
		this.optionsArray = optionsArray;
	}

	
	
}
