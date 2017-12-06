/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_teamnhip4_minichat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author TANCONG
 */
public class SelectFromTableUser {
    
    public static void main(String[] args) {
        Connection con = null;
        Statement sttm = null;
  
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SQliteTeamNhip4.db");
            
            sttm =con.createStatement();
            
            String sql = "SELECT id, username, password FROM TblUser";
            ResultSet rs    = sttm.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("username") + "\t" +
                                   rs.getString("password"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}
