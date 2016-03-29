<?php 

   function normalize($string)
    {
        $res="";
        $length= strlen($string);
        for( $i = 0; $i <= $length; $i++ ) {
            $char = substr( $string, $i, 1 );
            if( $char == "'" ) {
                $res .="'";
                }
            $res.= $char;
        }
        return $res;
    
        }
        
    
    
    if($_FILES['file']['error'] > 0)
    {
    echo "ERROR: ".$_FILES['file']['error']."<br/>";
    }
    else{
            

            move_uploaded_file($_FILES['file']['tmp_name'], $_FILES['file']['name']);
           // echo "<p> <a href='Enviados/".$_FILES['ficheiro']['name']."'>Ficheiro</a> gravado na pasta enviados.</p>";
        
    $db_connector =  mysqli_connect("localhost","root","","berlioz_DB"); 
	if (!$db_connector) {
    echo "Error: Unable to connect to MySQL." . PHP_EOL;
    echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
    echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
    exit;
    }
    
    mysqli_set_charset($db_connector,"utf8");
     $teachers = simplexml_load_file($_FILES['file']['name']);
     
     foreach($teachers->professor as $t)
    {
        $course = normalize((string)$t->curso );
        $get = "SELECT `courses`.`id` FROM courses WHERE (courses.designation = '".$course."')";
        if (($result=mysqli_query($db_connector, $get))==NULL) {
        printf("Errormessage get Course/Teachers: %s.<br/>", mysqli_error($db_connector));
        }
        $row = mysqli_fetch_array($result);
        $courseID = $row["id"];
        $id=normalize((string)$t['id']);
        $name=normalize((string)$t->nome);
        $q = normalize((string)$t->habilitacoes);
        $insert = "INSERT INTO teachers VALUES ('".$id."', '".$name."', '".(string)$t->dataNasc."','".$q."','".$courseID."');";
        if (!mysqli_query($db_connector, $insert)) {
        printf("Errormessage insert Teachers: %s.<br/>", mysqli_error($db_connector));
        }
     }
     
    }
    
    

?>