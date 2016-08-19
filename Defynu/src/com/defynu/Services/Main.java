package com.defynu.Services;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.defynu.Model.DatabaseUtilProperties;


import com.defynu.Model.Shirt;

import oracle.sql.BLOB;

public class Main {
  public String AddtoCart(Shirt shirt,String uname) throws Exception {
    String WRITE_OBJECT_SQL = "BEGIN "
        + "  INSERT INTO java_objects(object_id, object_value) "
        + "  VALUES (?, empty_blob()) " + "  RETURN object_value INTO ?; " + "END;";
    String READ_OBJECT_SQL = "SELECT object_value FROM java_objects WHERE object_id = ?";

    
		DatabaseUtilProperties dataSource=new DatabaseUtilProperties();
		Connection con=dataSource.getDBConfig();
		con.setAutoCommit(false);
    List<Shirt> list = new ArrayList<Shirt>();
    list.add(shirt);
  
    // write object to Oracle
    String id = uname;
   // String className = list.getClass().getName();
    CallableStatement cstmt = con.prepareCall(WRITE_OBJECT_SQL);

    cstmt.setString(1,id);
    //cstmt.setString(2, className);

    cstmt.registerOutParameter(2, java.sql.Types.BLOB);

    cstmt.executeUpdate();
    BLOB blob = (BLOB) cstmt.getBlob(2);
    OutputStream os = blob.getBinaryOutputStream();
    ObjectOutputStream oop = new ObjectOutputStream(os);
    oop.writeObject(list);
    oop.flush();
    oop.close();
    os.close();
    con.commit();
    // de-serialize list a java object from a given objectID
    // List resultList = (List) object;
   //  System.out.println("[After De-Serialization] list=" + resultList);
   //  System.out.println(list.get(0).getBody());
     
    
   // con.commit();
    con.close();
    
     String y = "Y";
     return y;
    
 }
    public ArrayList<Shirt> ShowCart(String uname) throws Exception {
 
        String READ_OBJECT_SQL = "SELECT object_value FROM java_objects WHERE object_id = ?";
        String id = uname;
        
    		DatabaseUtilProperties dataSource=new DatabaseUtilProperties();
    		Connection con=dataSource.getDBConfig();
    		con.setAutoCommit(false);
        List<Shirt> list = new ArrayList<Shirt>();
    // Read object from oracle
    PreparedStatement pstmt = con.prepareStatement(READ_OBJECT_SQL);
    pstmt.setString(1, id);
    ResultSet rs = pstmt.executeQuery();
    ArrayList<Shirt> resultList = new ArrayList<Shirt>();
    while (rs.next()) {
    	 InputStream is = rs.getBlob(1).getBinaryStream();
    	 ObjectInputStream oip = new ObjectInputStream(is);
    	    Object object = oip.readObject();
    	   // object1=(Shirt) object;
    	    System.out.println(object);
            resultList.addAll((Collection<? extends Shirt>) object);
    
    oip.close();
    is.close();
    }
    rs.close();
    pstmt.close();
    con.commit();
    
    // de-serialize list a java object from a given objectID
   // List resultList = (List) object;
    System.out.println("[After De-Serialization] list=" + resultList);
   // System.out.println(list.get(0).getBody());
    con.close();
    System.out.println(resultList);
    return (ArrayList<Shirt>) resultList;
   
}
}

   