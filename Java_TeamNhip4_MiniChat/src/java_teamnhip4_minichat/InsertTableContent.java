/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_teamnhip4_minichat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TANCONG
 */
public class InsertTableContent {
    
    public static void main(String[] args) {
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SQliteTeamNhip4.db");
            String sql = "INSERT INTO TblContent(sender,receiver,type,content,inComeTime,isDeliver) VALUES(?,?,?,?,?,?)";
            //String sql = "DELETE  FROM TblContent WHERE sender =?";
            PreparedStatement pstmt = con.prepareStatement(sql);
       
            SimpleDateFormat sdf = new SimpleDateFormat("y/M/d h:m:s");
            Date date = new Date();
            pstmt.setString(1, "luyt");
            pstmt.setString(2, "cong");
            pstmt.setString(3, "chat");
            pstmt.setString(4, "Dang choi Lol");
            pstmt.setString(5, sdf.format(date));
            pstmt.setString(6, "false");
            pstmt.executeUpdate();
            //pstmt.execute();
            System.out.println("Them Database Thanh Cong");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
