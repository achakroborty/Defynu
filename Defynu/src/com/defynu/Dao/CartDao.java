package com.defynu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.defynu.Model.DatabaseUtilProperties;
import com.defynu.Model.Shirt;


public class CartDao {
	
	private String result;
	public String AddtoCart(Shirt shirt, String uname)
	{
	
	try {
		DatabaseUtilProperties dataSource=new DatabaseUtilProperties();
		Connection con=dataSource.getDBConfig();
		
          
	/*	String query1 = "Select count(1) from Usr where username = ? ";
		PreparedStatement pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, user.getEmail());
		//pstmt.setString(2, user.getPassword());
		ResultSet resultSet = pstmt1.executeQuery();
		System.out.println(resultSet);
		if (resultSet.next() && resultSet.getInt(1)>0)
		result= "R"; //If USer is already Registered return 'R'
		else
		{*/
			String query2 = "Insert into Cart (username,bodys,button,buttonplacket,innercollar,outercollar,innercuff,outercuff,outsidefastening) values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt2 = con.prepareStatement(query2);
				pstmt2.setString(1, uname);
				pstmt2.setString(2, shirt.getBody());
				pstmt2.setString(3, shirt.getButton());
				pstmt2.setString(4, shirt.getButtonplacket());
				pstmt2.setString(5, shirt.getInnercollar());
				pstmt2.setString(6, shirt.getOutercollar());
				pstmt2.setString(7, shirt.getInnercuff());
				pstmt2.setString(8, shirt.getOutercuff());
				pstmt2.setString(9, shirt.getOutsidefastening());
				
			    pstmt2.executeQuery();	
				result = "Y"; // New User Registered
				
	
		con.close();
	}
	catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	return result;
	
	}
		
			

}




