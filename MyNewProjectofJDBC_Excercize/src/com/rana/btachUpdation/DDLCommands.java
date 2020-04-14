package com.rana.btachUpdation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DDLCommands {
private final static String query = "create table student1 (sname varchar2(20), sage number) ";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##rana","rana123");
		    Statement st = con.createStatement();
		    st.executeUpdate(query);
			   System.out.println("table is created ");
		    
		}
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("table is not created because same table already exist");
		}
	}
}
