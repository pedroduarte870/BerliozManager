/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berlioz;

import java.util.ArrayList;

/**
 *
 * @author Emanuel
 */
public class Performance {
    public String student;
    public boolean group=false;
    public boolean studentAdded = false;
    public String designation;
    public ArrayList<String> students = new ArrayList<String>();
    public ArrayList<String> pieces = new ArrayList<String>();
    public ArrayList<String> leaders = new ArrayList<String>();
    
    Performance(){
        this.student="";
    }
    
    public void addStudent(String student){
        this.student= student;
        this.studentAdded=true;
    }
    
    public void addStudentGroup(String student){
        this.students.add(student);
    }
    
    public void addPiece(String piece){
        this.pieces.add(piece);
    }
    
    public void addLeader(String leader){
        this.leaders.add(leader);
    }
    
    public void addDesignation(String designation){
        this.designation= designation.substring(1, designation.length()-1);;
        this.group=true;
    }
    
    public boolean isGroup(){
        return this.group;
    }
    
    
    public boolean studentAdded(){
        return this.studentAdded;
    }
}
