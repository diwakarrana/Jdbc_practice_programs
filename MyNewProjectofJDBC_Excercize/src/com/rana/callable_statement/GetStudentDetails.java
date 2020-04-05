/* create or replace procedure getStudentDetails(sno in number, name out student.name%type, total out student.total%type, avg out student.avg%type, result out student.result%type)
is 
begin
	select name , total , avg, result into name , total, avg, result from student where sno = sno;
end;
/
 */
//................................................above db script is given...............................................................
/*
 * 
 * declare 
	name student.name%type;
	total student.total%type;
	avg student.avg%type;
	result student.result%type;
begin 
	getStudentDetails(100,name,total,avg, result);
	dbms_output.put_line(name)
	dbms_output.put_line(total)
	dbms_output.put_line(avg)
	dbms_output.put_line(result)
end;
/
*/
//.........................................................................this one is for checking for procedure is working well or not...
package com.rana.callable_statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class GetStudentDetails {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//.............................................................................................................................................
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##rana", "rana123");
		CallableStatement cs = con.prepareCall("{call getStudentDetails(?,?,?,?,?)}");
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.registerOutParameter(3, Types.INTEGER);
		cs.registerOutParameter(4, Types.INTEGER);
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.setInt(1, 500);
		cs.execute();
		System.out.println(cs.getString(2));
		System.out.println(cs.getInt(3));
		System.out.println(cs.getInt(4));
		System.out.println(cs.getString(5));
		//.............................................................................................................................................
	}//end of main
}//end of class
