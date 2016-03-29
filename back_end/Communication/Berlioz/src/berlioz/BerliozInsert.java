/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berlioz;

import static com.sun.corba.se.impl.presentation.rmi.StubConnectImpl.connect;
import static com.sun.jmx.remote.internal.IIOPHelper.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.rmi.PortableRemoteObject.connect;

/**
 *
 * @author Emanuel
 */




public class BerliozInsert {
    
    
    private final Connection conn;
    private String title;
    private String subt;
    private String subj;
    private String place;
    private String date;
    private String time;
    private String duration;
    private ArrayList<Performance> performances = new ArrayList<Performance>() ;
    private String organizer;
    
   
    
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

    public BerliozInsert() {
        this.conn = getCon();

    }
    
    public void addPerformance(Performance p){
        this.performances.add(p);
    }
    
    public void metadata(String title, String subt, String subj,String organizer,String place,String date ,String time ,String duration){
        this.title = title.substring(1, title.length()-1);
        this.subt = subt.substring(1, subt.length()-1);
        this.subj=subj.substring(1, subj.length()-1);
        this.place = place.substring(1, place.length()-1);
        this.date = date;
        this.time = time;
        this.duration=duration;
        this.organizer = organizer.substring(1, organizer.length()-1);
        
        
    }
    
    public void insertMeta(){
        
        
            try  {
                String q = "INSERT INTO `audition` ( title, subtitle, subject, place, date, time, duration, organizer) VALUES (?,?,?,?,?,?,?,?)"; //, '"+this.title+"`, `"+this.subt+"`, `"+this.subj+"`, `"+this.place+"`, `"+this.date+"`, `"+this.time+"`, `"+this.duration+"')";
                PreparedStatement preparedStatement = 
                conn.prepareStatement(q);
               
                preparedStatement.setString(1, this.title);
                preparedStatement.setString(2, this.subt);
                preparedStatement.setString(3, this.subj);
                preparedStatement.setString(4, this.place);
                preparedStatement.setString(5, this.date);
                preparedStatement.setString(6, this.time);
                preparedStatement.setString(7, this.duration);
                preparedStatement.setString(8, this.organizer);
               
                preparedStatement.execute();
        } catch (Exception ex) {
            System.out.println("Error on adding metadata :"+ex);
        }
        
    }
    
    
    public void insertPerformances(){
       ResultSet rs=null;
        
        int id=0;
        String audition="";
        String s="";
        try {
           
            try (Statement st = conn.createStatement()) {
               rs = st.executeQuery("SELECT MAX(id) FROM audition;");
               if (rs.next()) {
                id=rs.getInt(1);
               }
               
               audition=""+id;
               
              rs.close();
            }   
        } catch (Exception ex) {
            System.out.println("Error on getting AuditionID:"+ex);
        }
            
        int i;
        for(i=0; i< this.performances.size();i++)
        {
            Performance p = this.performances.get(i);
            
            try  {
                String q="";
                if(p.group){
                    
                    int idG=0;
                    String sidG="";
                    
                    
                    try {
           
            try (Statement st = conn.createStatement()) {
               rs = st.executeQuery("SELECT * FROM `group` WHERE `name` LIKE '"+p.designation+"';");
               if (rs.next()) {
                idG=rs.getInt(1);
               }
               
               sidG=""+idG;
               
              rs.close();
            }   
        } catch (Exception ex) {
            System.out.println("Error on getting group ID:"+ex);
        }
                    
                    
                
                 q = "INSERT INTO `performances` ( audition, `group`) VALUES (?,?)";
                  PreparedStatement preparedStatement = 
                  conn.prepareStatement(q);
               
                preparedStatement.setString(1,audition);
                //preparedStatement.setString(2,"NULL");
                preparedStatement.setString(2,sidG);
                preparedStatement.execute();
                }
                else
                {
                q = "INSERT INTO `performances` ( audition, student) VALUES (?,?)";
                 PreparedStatement preparedStatement = 
                conn.prepareStatement(q);
               
                preparedStatement.setString(1, audition);
                preparedStatement.setString(2, p.student);
                preparedStatement.execute();
                }
               
                try {
           
            try (Statement st = conn.createStatement()) {
               rs = st.executeQuery("SELECT MAX(id) FROM performances;");
               if (rs.next()) {
                id=rs.getInt(1);
               } 
               s=""+id;
              rs.close();
            }   
        } catch (Exception ex) {
            System.out.println("Error on getting ID P:"+ex);
        }
          
                int i2=0;
                int lLength = p.leaders.size();
                int perLength =p.students.size();
                int pLength= p.pieces.size();
                for(i2=0;i2<lLength;i2++){
                   String leader = p.leaders.get(i2);
                   q = "INSERT INTO `teachers_performances` ( teachersID, performancesid) VALUES (?,?)";
                    PreparedStatement preparedStatement = 
                    conn.prepareStatement(q);
               
                    preparedStatement.setString(1,leader);
                    preparedStatement.setString(2, s);
                    preparedStatement.execute();
                }/*
                for(i2=0;i2<perLength;i2++){
                   String performer = p.students.get(i2);
                   q = "INSERT INTO `group_students` ( teachersID, performancesid) VALUES (?,?)";
                    PreparedStatement preparedStatement = 
                    conn.prepareStatement(q);
               
                    preparedStatement.setString(1,performer);
                    preparedStatement.setString(2, s);
                    preparedStatement.execute();
                }*/
                for(i2=0;i2<pLength;i2++){
                   String piece = p.pieces.get(i2);
                   q = "INSERT INTO `pieces_performances` ( piecesid, performancesid) VALUES (?,?)";
                    PreparedStatement preparedStatement = 
                    conn.prepareStatement(q);
                    preparedStatement.setString(1,piece);
                    preparedStatement.setString(2, s);
                    preparedStatement.execute();
                }
                
                
        } catch (Exception ex) {
            System.out.println("Error on adding Piece performance :"+ex);
        }
            
        }
        
        
        
    }
    
    
}
