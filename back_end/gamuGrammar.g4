/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar gamuGrammar;

@header{
        import java.util.*;
        import java.io.*;
}


gamu : 'BEGIN GAMU' audition+ 'END GAMU'
     ;

audition
    
    :
        'BEGIN AUDITION' metadata 'END AUDITION'
        
        ;

metadata
    :
        'METADATA' 'TITLE' title=STRING 'SUBTITLE' subtitle=STRING 'SUBJECT' subject=STRING
        'ORGANIZER' organizer=STRING 'PLACE' place=STRING 'DATE' d=date 'TIME' t=time 'DURATION' du=duration '.' 
        ;

date
    :
        day=NUMBER DATE_SEP month=NUMBER DATE_SEP year=NUMBER
    ;

time:
        hour=NUMBER TIME_SEP  min=NUMBER ('m')?   
    ;

duration:
         (hour=NUMBER TIME_SEP )? min=NUMBER ('m')?    
        ;






//-------------------------LEXER------------------------------------//

fragment
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

WS       :   [ \t\r\n]  -> skip
             
         ;
