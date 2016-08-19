package com.defynu.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

//import javax.sql.DataSource;

import com.defynu.Model.DatabaseUtilProperties;
import com.defynu.Model.User;


public class LoginDao {
	private boolean result=false;
	public boolean isValidUser(User user)
	{
	
	try {
		DatabaseUtilProperties dataSource=new DatabaseUtilProperties();
		Connection con=dataSource.getDBConfig();
		

			
			String query = "Select count(1) from Usr where username = ? and password = ?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, user.getEmail());
				pstmt.setString(2, user.getPassword());
				ResultSet resultSet = pstmt.executeQuery();				
				if (resultSet.next())
				result= (resultSet.getInt(1) > 0);
				else
				result= false;
				con.close();
	}
	catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	return result;
	
	}
		
				
}	
