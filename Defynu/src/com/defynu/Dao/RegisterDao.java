package com.defynu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.defynu.Model.DatabaseUtilProperties;
import com.defynu.Model.User;

public class RegisterDao {
	
	private String result;
	public String isRegister(User user)
	{
	
	try {
		DatabaseUtilProperties dataSource=new DatabaseUtilProperties();
		Connection con=dataSource.getDBConfig();
		
          
		String query1 = "Select count(1) from Usr where username = ? ";
		PreparedStatement pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, user.getEmail());
		//pstmt.setString(2, user.getPassword());
		ResultSet resultSet = pstmt1.executeQuery();
		System.out.println(resultSet);
		if (resultSet.next() && resultSet.getInt(1)>0)
		result= "R"; //If USer is already Registered return 'R'
		else
		{
			String query2 = "Insert into Usr (username,password) values(?,?)";
				PreparedStatement pstmt2 = con.prepareStatement(query2);
				pstmt2.setString(1, user.getEmail());
				pstmt2.setString(2, user.getPassword());
			    pstmt2.executeQuery();	
				result = "N"; // New User Registered
				
	}
		con.close();
	}
	catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	return result;
	
	}
		
			

}
