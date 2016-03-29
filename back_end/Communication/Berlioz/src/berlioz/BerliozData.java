/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berlioz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel
 */
public class BerliozData {
    private final Connection conn;

    public Connection getCon(){
        
        Connection conn=null;
            try{
        String url = "jdbc:mysql://localhost:3306/berlioz_DB?useUnicode=yes&characterEncoding=UTF-8";
        String user = "root";
        String pass = "";
        
         conn = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex  ) {
        System.out.println("Error connectingto database"+ex.getMessage());
    }
            return conn;
    }

    public BerliozData() {
        this.conn = getCon();

    }
    
    public boolean exitsStudentID(String id){
        boolean exists=false;
        ResultSet rs=null;
        //String newID = id.substring(1, id.length()-1);
        try {
           
            try (Statement st = conn.createStatement()) {
                rs = st.executeQuery("SELECT * FROM `students` WHERE `ID` LIKE '"+id+"';");
                if(rs.first())
            {
                exists=true;
            }
                rs.close();
            }   
        } catch (Exception ex) {
            System.out.println("Error on verifying sudent's existence :"+ex);
        }
        
        return exists;
    }
    
    
    public boolean exitsTeacherID(String id){
        boolean exists=false;
        ResultSet rs=null;
        //String newID = id.substring(1, id.length()-1);
        try {
           
            try (Statement st = conn.createStatement()) {
                rs = st.executeQuery("SELECT * FROM `teachers` WHERE `ID` LIKE '"+id+"';");
                if(rs.first())
            {
                exists=true;
            }
                rs.close();
            }   
        } catch (Exception ex) {
            System.out.println("Error on verifying teacher's existence :"+ex);
        }
        
        return exists;
    }
    
    public boolean exitsPieceID(String id){
        boolean exists=false;
        ResultSet rs=null;
        //String newID = id.substring(1, id.length()-1);
        try {
           
            try (Statement st = conn.createStatement()) {
                rs = st.executeQuery("SELECT * FROM `pieces` WHERE `ID` LIKE '"+id+"';");
                if(rs.first())
            {
                exists=true;
            }
                rs.close();
            }   
        } catch (Exception ex) {
            System.out.println("Error on verifying piece's existence :"+ex);
        }
        
        return exists;
    }
    
    public boolean exitsgroup( String groupI){
    boolean res = false;
    ResultSet rs=null;
    String group = groupI.substring(1, groupI.length()-1);
    try (Statement st = conn.createStatement()) {
               rs = st.executeQuery("SELECT * FROM `group` WHERE `name` LIKE '"+group+"';");
               if (rs.next()) {
                res=true;
               }
               
               rs.close();
    
    }   catch (Exception ex) {
            System.out.println("Error on verifying group's existence :"+ex);
        }
    
    
    return res;
    }
    
    public boolean isInGroup(String id, String groupI){
    boolean res= false;
    ResultSet rs=null;
    int idS = 0;
    String group = groupI.substring(1, groupI.length()-1);
    
    try (Statement st = conn.createStatement()) {
               rs = st.executeQuery("SELECT * FROM `group` WHERE `name` LIKE '"+group+"';");
               if (rs.next()) {
                idS = rs.getInt("id");
               }
                 rs.close();
                 
               rs = st.executeQuery("SELECT * FROM `group_students` WHERE studentsid = '"+id +"' AND groupi = "+ idS );  
               if (rs.next()) {
                res=true;
               }
                 rs.close();  
    }   catch (Exception ex) {
            System.out.println("Error on verifying student in group :"+ex);
        }
    
    return res;
    }
    
    
    public int pieceDuration(String id){
   
        ResultSet rs=null;
        //String newID = id.substring(1, id.length()-1);
        int time=0;
        String s="";
        try {
           
            try (Statement st = conn.createStatement()) {
               rs = st.executeQuery("SELECT * FROM `pieces` WHERE `ID` LIKE '"+id+"';");
               if (rs.next()) {
                s= rs.getString(5);
               }
               
               int h = Integer.parseInt(s.substring(0,2)) ;
               int m = Integer.parseInt(s.substring(3,5)) ;
               int seg = Integer.parseInt(s.substring(6,8));
               time = (h*60)+ m;
            
                rs.close();
            }   
        } catch (Exception ex) {
            System.out.println("Error on getting time existence :"+ex);
        }
        
        return time;
    }
    
     public void closeConn() 
            {
        try {
            if (conn != null) {
                conn.close(); 
                              }      
        } catch (Exception ex) {
            System.out.println(ex);
            ;
        }
            }
}
