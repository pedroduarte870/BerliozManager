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
     $students = simplexml_load_file($_FILES['file']['name']);
     
     foreach($students->aluno as $s)
    {
		$id=normalize((string)$s['id']);
		$name=normalize((string)$s->nome);
		$course = normalize((string)$s->curso);
        $insert = "INSERT INTO students VALUES ('".$id."', '".$name."', '".(string)$s->dataNasc."','".(string)$s->anoCurso."','".$course."');";
        if (!mysqli_query($db_connector, $insert)) {
        printf("Errormessage insert Student: %s.<br/>", mysqli_error($db_connector));
        }
        
     }	
     
    }
    
    

?>