package com.rana.btachUpdation;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchProcessing {
	private final static String INSERTQUERY = " INSERT INTO STUDENT1 (SNAME) VALUES('DIWAKAR RANA')";
	private final static String UPDATEQUERY = "UPDATE STUDENT1 SET SAGE = 23 WHERE SNAME = 'DIWAKAR RANA' ";
	private final static String DELETEQUERY = "DELETE FROM STUDENT1 WHERE SAGE = 23 ";
   
	public static void main(String[] args) {
		 int SuccessOperation = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##rana","rana123");
			Statement st = con.createStatement();
			st.addBatch(INSERTQUERY);
			st.addBatch(UPDATEQUERY);
			st.addBatch(DELETEQUERY);
			int[] result =st.executeBatch();
			
			for(int i : result) 
			{
				if(i!=0)
					SuccessOperation += i;
			}
			System.out.println("number of successful operation are "+ SuccessOperation);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
