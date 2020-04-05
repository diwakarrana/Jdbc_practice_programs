package com.rana.callable_statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class EmpNameStartingWithCharacter {

	public static void main(String[] args) throws Exception {
		boolean flag = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("input initial character");
		String char1 = scan.next();
		char1 = char1+"%";
		System.out.println("you put data : "+char1);
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##rana","rana123");
		CallableStatement cs = con.prepareCall("{call p(?, ?)}");
		cs.registerOutParameter(2, OracleTypes.CURSOR);
		cs.setString(1, char1);
		cs.execute();
		ResultSet rs = (ResultSet) cs.getObject(2);
		
		while(rs.next()) {
			flag =true;
			System.out.println(rs.getString(1)+"    "+rs.getString(2)+"     "+rs.getString(3)+"     "+rs.getString(4)+"     "+rs.getString(5)+"     "+rs.getString(6)+"      "+rs.getString(7)+"     "+rs.getString(8));
		}
		if(!flag)
			System.out.println("no records found");
	}//end of main method
}//end of class
