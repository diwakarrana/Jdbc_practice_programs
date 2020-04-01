package com.rana.callable_statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class SquareProcedure {
	public static void main(String[] args) {
	Connection con = null;
	CallableStatement cs = null;
	Scanner sc = null;
	int x =0, result =0;
	
	//taking input from user
	System.out.println("enter number::");
	sc = new Scanner(System.in);
	x = sc.nextInt();
	
		try {
			//register jdbc driver software
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//creating connection to the underlying database software
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##rana","rana123");
			
		//creating callable statement
			cs = con.prepareCall("{call square(?,?)}");
			
			//registering out parameters 
			cs.registerOutParameter(2,	Types.INTEGER);
			
			//setting inputs 
			cs.setInt(1, x);
			//executing the statement 
			cs.execute();
			//gather the result
			result = cs.getInt(2);
			System.out.println("Square of"+x+" is "+result);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			//close jdbc objects
			try {
				if(cs!=null)
					cs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//end of finally
	
}// end of main method
}//end of class