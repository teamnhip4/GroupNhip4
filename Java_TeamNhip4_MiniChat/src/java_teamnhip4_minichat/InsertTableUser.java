/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_teamnhip4_minichat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author TANCONG
 */
public class InsertTableUser {
    
    public static void main(String[] args) {
        Connection con = null;
  
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SQliteTeamNhip4.db");

            
            String sql = "INSERT INTO TblUser(username,password) VALUES(?,?)";
           // String sql = "DELETE  FROM TblUser WHERE username =?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
           pstmt.setString(1,"nkbjkl");
           pstmt.setString(2, "teamnhip4");
           
           pstmt.executeUpdate();
          // pstmt.execute();
            System.out.println("Them Database Thanh Cong");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}
