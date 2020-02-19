package database;

import java.sql.*;
import model.Questions;
import java.util.*;

public class DBhelper {
	private static DBhelper dbhelper;
	private Connection connection;
	private Statement statement;
	
	public DBhelper() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/space_quiz","root","");	
			statement = connection.createStatement();						
		}catch(Exception e){e.printStackTrace();}
	}
	
	public List<Questions> populateList(){
		List<Questions> qList = new ArrayList();
		try{
		ResultSet rs = statement.executeQuery("SELECT * FROM qnapool natural Join qinfo;");
		
		while(rs.next())			
			qList.add(new Questions(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));		
		
		}catch(Exception e){e.printStackTrace();}
		
		return qList;
	}
	
	
	public static DBhelper getReference(){
		if(dbhelper == null)
			dbhelper = new DBhelper();		
		return dbhelper;
	}
	
}
