package com.rana.btachUpdation;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManagement {

	public static void main(String[] args) {
		int amt =0, srcAcc = 0, desAcc = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter source account");
		srcAcc = scan.nextInt();
		System.out.println("enter destination account");
		desAcc = scan.nextInt();
		System.out.println("enter money amount to be transfer ");
		amt = scan.nextInt();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##rana","rana123");
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			//st.execute("create table transaction( accno number(4), name varchar2(15), balance number(6))");
			System.out.println(srcAcc  +"    "+desAcc+"     "+amt);
			//withdraw money...
			
			String q1 = "update transaction set balance = balance -"+ amt +" where accno = "+srcAcc;
			String q2 = "update transaction set balance = balance + "+ amt + " where accno = "+ desAcc;
			System.out.println(q1);
			System.out.println(q2);
			st.addBatch(q1);
			st.addBatch(q2);
			
			int[] result  =  st.executeBatch();
			boolean flag = false;
			
			for(int i : result) {
				if(i == 0) {
					flag = true;
				break;
				}
			}
		
			if(flag) {
				con.rollback();
				System.out.println("something went wrong and trasaction could not complete");
			}
			else {
				con.commit();
				System.out.println("transaction happen successful");
			}
		}catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
