package com.rana.btachUpdation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementBatchProcessing {
	private static final String QUERY = "INSERT INTO STUDENT1 VALUES (?, ?)";

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##rana", "rana123");
		    PreparedStatement ps = con.prepareStatement(QUERY);
		    ps.setString(1,  "Diwakar Rana");
		    ps.setInt(2, 23);
		    ps.addBatch();
		    
		    ps.setString(1,  "gayna gupta");
		    ps.setInt(2, 21);
		    ps.addBatch();
		    
		    ps.setString(1,  "Rakeshwar");
		    ps.setInt(2, 22);
		    ps.addBatch();
		    
		    int[] result = ps.executeBatch();
		    int TotalSuccessfulOperation=0;
		    for(int i : result) {
		    	if(i != 0)
		    		TotalSuccessfulOperation += i;
		    }
		    System.out.println("total successful operations are"+ TotalSuccessfulOperation);
		    
		}catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}//end of main function 
}//end of class
