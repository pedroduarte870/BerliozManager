/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar audition_grammar;


@header{
        import java.util.*;
        import java.io.*;
        import java.sql.*;
        import java.util.logging.Logger;
        import java.util.logging.Level;
        import java.lang.*;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

}




gamu
    @init{
          ArrayList<ArrayList<String>> errors = new ArrayList<ArrayList<String>>();
          int i=0;
          int i2=0;
          }
    : 
         
         'BEGIN GAMU'  (a1=audition{errors.add($a1.errorsOUT);})* 'END GAMU'
         {for(i=0;i<errors.size();i++){for(i2=0;i2<errors.get(i).size();i2++){ System.out.println(errors.get(i).get(i2)); }    } }
     ;

audition
    returns[ArrayList<String> errorsOUT]
    @init{int totalTime=0; int diff=0; BerliozInsert ber = new  BerliozInsert();}
    :
        'BEGIN AUDITION' metadata[ber] 'PERFORMANCES' {$errorsOUT =$metadata.errorsOUT; ber = $metadata.berOUT;}
        p1 = performance[$errorsOUT]{$errorsOUT = $p1.errorsOUT;totalTime+=$p1.pTtime;ber.addPerformance($p1.performanceOUT);} 
        (p2 = performance[$errorsOUT]{$errorsOUT = $p2.errorsOUT;totalTime+=$p2.pTtime;ber.addPerformance($p2.performanceOUT);})* 'END AUDITION'
        { if($metadata.durationA<totalTime){diff=totalTime-$metadata.durationA; $errorsOUT.add("Error : The expected duration isnt enough u need more: "+diff +" minutes");} 
        if($errorsOUT.size()==0){
            ber.insertMeta();
            ber.insertPerformances();
            }
        }
        
;



metadata
    [BerliozInsert berIN]
    returns[int durationA, ArrayList<String> errorsOUT, BerliozInsert berOUT]
@init{$errorsOUT = new ArrayList<String>() ;}
    :
        'METADATA' 'TITLE' title=STRING 'SUBTITLE' subtitle=STRING 'SUBJECT' subject=STRING
        'ORGANIZER' organizer=STRING 'PLACE' place=STRING 'DATE' date 'TIME' time 'DURATION' duration '.' 
        { $durationA = $duration.durationMin ; if($date.errorOUT.length() > 0){$errorsOUT.add($date.errorOUT);}
        $berOUT = $berIN; $berOUT.metadata($title.text,$subtitle.text,$subject.text,$organizer.text,$place.text,$date.formatDate,$time.formatTime,$duration.formatDuration);
        }
        ;

date
returns[String errorOUT, String formatDate]
@init{Calendar calendar = new GregorianCalendar();
        $errorOUT="";
      }
    
    :
        day=NUMBER DATE_SEP month=NUMBER DATE_SEP year=NUMBER 
        { if(($year.int >= calendar.get(Calendar.YEAR)) && ($year.int<=calendar.get(Calendar.YEAR)+5)){ if($year.int== calendar.get(Calendar.YEAR) && $month.int < calendar.get(Calendar.MONTH)+1 ){$errorOUT="Error in the date of the event: The month is wrong"; }
        else{if($year.int== calendar.get(Calendar.YEAR) && $month.int == (calendar.get(Calendar.MONTH)+1) && $day.int <= calendar.get(Calendar.DAY_OF_MONTH) ){$errorOUT="Error in the date of the event: The day is wrong (events can only be schedule for dates after today!)";}}
        }else{$errorOUT="Error in the date of the event: The year is wrong (range=5)";}
        $formatDate = $day.text+"/"+$month.text+"/"+$year.text; 
        }
    ;   

time
    returns[String formatTime]
    :
        hour=NUMBER TIME_SEP  min=NUMBER ('m')?
        {$formatTime = $hour.text + "h" + $min.text; }
        
    ;

duration
    returns[int durationMin, String formatDuration]
    @init{$formatDuration="";}
    :
         (hour=NUMBER TIME_SEP )? min=NUMBER ('m')?
            {if($hour!=null){$durationMin=$hour.int*60+$min.int; $formatDuration+=$hour.text+"h"; }else{$durationMin=$min.int;}
            $formatDuration+=$min.text+"m";
            }
        ;
/*
performances
    [ArrayList<String> errorsIN]
    returns[ArrayList<String> errorsOUT]
    :
            performance[$errorsIN]{$err} (performance[$performance])*
            ;*/

performance
    [ArrayList<String> errorsIN]
    returns[ArrayList<String> errorsOUT , int pTtime, Performance performanceOUT]
    @init{HashSet<String> p = new HashSet<String>();
          HashSet<String> l = new HashSet<String>();
          HashSet<String> pl = new HashSet<String>();
          $performanceOUT = new Performance();
          $pTtime=0;
          $errorsOUT=$errorsIN;
          String group="";
        }
    :   
           
            'PERFORMANCE' (designation=STRING)? {if($designation==null){group="";}else{group=$designation.text;$performanceOUT.addDesignation($designation.text);} }
            'LEADERS' l1=leader[l,$errorsIN,$performanceOUT]{l = $l1.lOUT; $errorsOUT= $l1.errorsOUT; $performanceOUT = $l1.performanceOUT;} 
            (',' l2=leader[l,$errorsOUT,$performanceOUT ] {l = $l2.lOUT;$errorsOUT= $l2.errorsOUT;$performanceOUT = $l2.performanceOUT;})* 
            'PERFORMERS' p1=performer[p,$errorsOUT,group,$performanceOUT]{p = $p1.pOUT; $errorsOUT= $p1.errorsOUT;$performanceOUT = $p1.performanceOUT;} 
            (',' p2=performer[p,$errorsOUT,group,$performanceOUT]{p = $p2.pOUT;$errorsOUT= $p2.errorsOUT;$performanceOUT = $p2.performanceOUT;})* 
            'PLAYS' pl1=play [pl,$errorsIN,$performanceOUT]{pl = $pl1.plOUT; $errorsOUT= $pl1.errorsOUT;$pTtime+=$pl1.timeP;$performanceOUT = $pl1.performanceOUT;} ';' 
            (pl2=play[pl,$errorsOUT,$performanceOUT ] {pl = $pl2.plOUT;$errorsOUT= $pl2.errorsOUT;$pTtime+=$pl2.timeP;$performanceOUT = $pl2.performanceOUT;} ';')*  '.'
          
    ;

leader
    [HashSet<String> lIN , ArrayList<String> errorsIN ,Performance performanceIN ]
    returns[HashSet<String> lOUT, ArrayList<String> errorsOUT, Performance performanceOUT]
    @init{$lOUT=$lIN; $errorsOUT = $errorsIN; BerliozData conn = new BerliozData(); }
    :
         l=ID
         {if(!$lOUT.add($l.text)){$errorsOUT.add("Error adding leader: U already added "+$l.text +" to the performance...");}
          if(!conn.exitsTeacherID($l.text)){$errorsOUT.add("Error adding leader: the teacher "+$l.text +" doesnt exist");}
        conn.closeConn();
            $performanceOUT = $performanceIN; $performanceOUT.addLeader($l.text);
            }
      ;

performer
        [HashSet<String> pIN , ArrayList<String> errorsIN , String group, Performance performanceIN]
        returns[HashSet<String> pOUT, ArrayList<String> errorsOUT, Performance performanceOUT]
        @init{$pOUT=$pIN; $errorsOUT = $errorsIN; BerliozData conn = new BerliozData();}
        :
         p=ID
         {if(!$pOUT.add($p.text)){$errorsOUT.add("Error adding performer: U already added"+$p.text +" to the performance...");}
           if(!conn.exitsStudentID($p.text) && !conn.exitsTeacherID($p.text) ){$errorsOUT.add("Error adding performer: the performer"+$p.text +" doesnt exist...");}
           
           $performanceOUT = $performanceIN; if(!$performanceOUT.isGroup()){if(!$performanceOUT.studentAdded()){$performanceOUT.addStudent($p.text);}
            else{$errorsOUT.add("Error adding performer: performence lacks designation, so only one student can be added, so "+$p.text+ "can't be added "); }}
           else{ if(!conn.isInGroup($p.text,$group)){$errorsOUT.add("Error adding performer: performer "+$p.text+ " isn´t included in group "+$group );}  }
            conn.closeConn();
            }
         ;

play
    [HashSet<String> plIN , ArrayList<String> errorsIN, Performance performanceIN ]
    returns[HashSet<String> plOUT, ArrayList<String> errorsOUT, int timeP, Performance performanceOUT]
    @init{$plOUT=$plIN; $errorsOUT = $errorsIN; BerliozData conn = new BerliozData(); }
    :
       'PLAY' p=ID
       {if(!$plOUT.add($p.text)){$errorsOUT.add("Error adding piece: U already added "+$p.text +" to the performance...");}
       if(!conn.exitsPieceID($p.text)){$errorsOUT.add("Error adding piece: The piece "+$p.text +" doesnt exist...");}
       else{$timeP= conn.pieceDuration($p.text);}
        $performanceOUT = $performanceIN; $performanceOUT.addPiece($p.text);
        conn.closeConn();
        }
    ;










//-------------------------LEXER------------------------------------//


STRING
    :  '"' ( ESC_SEQ | ~('"') )* '"'
    ;
fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') 
    ;

NUMBER : ('0'..'9')+
       ;

DATE_SEP: ('/'| '-'| '.')
        ;

TIME_SEP: ('h'| 'H'| '.' | ':')
        ;
MINUTE_SEP:('m'| 'M'| '.' | ':')
          ;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-')*
    ;

WS       :   [ \t\r\n]  -> skip
             
         ;
