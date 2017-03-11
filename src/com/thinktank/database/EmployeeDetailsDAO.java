package com.thinktank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thinktank.VO.*;

public class EmployeeDetailsDAO {
	public List<EmployeeDetailsVO> display(){
		List<EmployeeDetailsVO> ls = new ArrayList<EmployeeDetailsVO>();
		try{
				Class.forName("com.amazon.redshift.jdbc41.Driver");
				Connection con = DriverManager.getConnection("jdbc:redshift://cloudservice.cupqfkw2nsiw.us-west-1.redshift.amazonaws.com:5439/thinktank", "thinktank","cloudService123#");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * from employees_test");
				while(rs.next()){
					EmployeeDetailsVO edvo = new EmployeeDetailsVO();
					edvo.setEmployeeNo(rs.getInt("employeenumber"));
					edvo.setFirstname(rs.getString("firstname"));;
					edvo.setLastname(rs.getString("lastname"));
					edvo.setEmail(rs.getString("email"));
					ls.add(edvo);
				}
		}
		catch(Exception e){
				e.printStackTrace();
		}
		return ls;		
	}
	
}
