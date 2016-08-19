package com.defynu.Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtilProperties {
	public Connection  getDBConfig(){
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			// step1 load the driver class
			System.out.println("OKAY WORKING");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			

			// step2 create the connection object
			 con = DriverManager.getConnection(
					"jdbc:oracle:thin:@defynutest.co45mggbu9uw.us-west-2.rds.amazonaws.com:1521:ORCL", "defynutest", "defynutest");
			System.out.println("okay");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

}
