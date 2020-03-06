package model;

public class RadioButtonQuestions extends Questions {	
	private String[] optionsArray; 	
	
	
	public String getOptionsArray() {
		String str="";
		for(int i=0;i<optionsArray.length;i++)
			str+=optionsArray[i];		
		return str;
	}

	public void setOptionsArray(String[] optionsArray) {
		this.optionsArray = optionsArray;
		for(int i=0;i<optionsArray.length;i++){
			optionsArray[i]= optionsArray[i].trim();
			if(optionsArray[i].charAt(0)>=65 && optionsArray[i].charAt(0)<=90){
				this.setAnswer(optionsArray[i].toUpperCase());				
				break;
			}
		}		
	}
	
	public String[] getOptionsArray(int num){
		return this.optionsArray;
	}

	
	
}
