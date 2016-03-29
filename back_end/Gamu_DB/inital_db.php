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
	
	//$db_connector = new PDO('mysql:charset=utf8mb4;host=localhost;dbname=berlioz_DB','root'); 
	$db_connector =  mysqli_connect("localhost","root","","berlioz_DB"); 
	if (!$db_connector) {
    echo "Error: Unable to connect to MySQL." . PHP_EOL;
    echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
    echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
    exit;
}
	mysqli_set_charset($db_connector,"utf8");
	
	//mysql_set_charset('utf8', $dbh);
    $composers = simplexml_load_file('compositores.xml');
	$pieces= simplexml_load_file('obras.xml');
	$instruments = simplexml_load_file('instrumentos.xml');
	$courses = simplexml_load_file('cursos.xml');
	$teachers = simplexml_load_file('professores.xml');
	$students = simplexml_load_file('alunos.xml');
	//Add composers to database
    
    foreach($composers->compositor as $c)
    {
        $id = normalize((string)$c['id']);
        $name = normalize((string)$c->nome);
        $bio = normalize((string)$c->bio);
        $epoch = normalize((string)$c->periodo);
        $insert = "INSERT INTO composers VALUES ('".$id."', '".$name."', '".$bio."','".(string)$c->dataNasc."','".(string)$c->dataObito."','".$epoch."');";
        //echo $insert."<br/>";
		//$db_connector->query($insert);
		if (!mysqli_query($db_connector, $insert)) {
        printf("Errormessage: %s.<br/>", mysqli_error($db_connector));
        }
    }
	
	
	
	foreach($pieces->obra as $o)
    {
		$name = normalize((string)$o->compositor );
		//print( $name."<br/>")  ;
		$get = "SELECT `composers`.`id` FROM composers WHERE (composers.name = '".$name."')";
		//echo $get;
		//$st = $db_connector->query($get);
		//$result=$db_connector->query($get);
		
		if (($result=mysqli_query($db_connector, $get))==NULL) {
        printf("Errormessage: %s.<br/>", mysqli_error($db_connector));
        }
        $row = mysqli_fetch_array($result);
		$id = $row["id"];
        //print($id."<br/>");
        //print($st->errorInfo());
        
		//echo $statement-> 
		
		//echo $name."///";
		//foreach ($db_connector->query($get) as $row) {
        //$id =  $row['id'];
        //echo $id."<br/>";
        //}
        //echo "-----------------------------------------<br/>";
		//$id = $statement->queryString;
		$idP = normalize((string)$o['id']);
        $name = normalize((string)$o->nome);
        $desc = normalize((string)$o->desc);
        $insert = "INSERT INTO pieces VALUES ('".$idP."', '".$name."', '".$desc."','".(string)$o->anoCriacao."','".(string)$o->duracao."','".$id."');";
       // $db_connector->query($insert);
       if (!mysqli_query($db_connector, $insert)) {
        printf("Errormessage: %s.<br/>", mysqli_error($db_connector));
        }
    }
    
    //end piece
    
    
    //begin add instrument to database
    
    $ind=1;
    foreach($instruments->instrumento as $i)
    {
        $id="I".$ind;
        $ind+=1;
        $name = normalize((string)$i);
        $insert = "INSERT INTO instruments VALUES ('".$id."', '".$name."');";
        if (!mysqli_query($db_connector, $insert)) {
        printf("Errormessage: %s.<br/>", mysqli_error($db_connector));
        }
    }
    //end 
    
    //begin add courses to db
    foreach($courses->curso as $c)
    {
        $instrument = normalize((string)$c->instrumento );
		$get = "SELECT `instruments`.`id` FROM instruments WHERE (instruments.name = '".$instrument."')";
		if (($result=mysqli_query($db_connector, $get))==NULL) {
        printf("Errormessage get instrument course: %s.<br/>", mysqli_error($db_connector));
        }
        $row = mysqli_fetch_array($result);
		$instrumentID = $row["id"];
		$id=normalize((string)$c['id']);
		$d=normalize((string)$c->designacao);
        $insert = "INSERT INTO courses VALUES ('".$id."', '".$d."', '".(string)$c->duracao."','".$instrumentID."');";
        if (!mysqli_query($db_connector, $insert)) {
        printf("Errormessage insert course: %s.<br/>", mysqli_error($db_connector));
        }
    
	}
	//end
	
	//begin add teachers to db
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
     //end
     
     //begin add students to db
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
     
     //end
	
	?>