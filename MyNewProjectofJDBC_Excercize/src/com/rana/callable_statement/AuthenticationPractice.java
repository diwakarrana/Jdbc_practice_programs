package com.rana.callable_statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class AuthenticationPractice {

	public static void main(String[] args) throws Exception {
		System.out.println("input username::");
		Scanner scan = new Scanner(System.in);
		String user = scan.nextLine();
		System.out.println("input password::");
		String pass = scan.nextLine();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##rana","rana123");
		CallableStatement cs = con.prepareCall("{call auth(?,?,?)}");
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.setString(1, user);
		cs.setString(2, pass);
		cs.execute();
	String result = cs.getString(3);
		System.out.println("this user having  "+result);
	}
}
