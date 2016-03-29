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
        
    $db_connector =  mysqli_connect("localhost","root","","berlioz_DB"); 
	if (!$db_connector) {
    echo "Error: Unable to connect to MySQL." . PHP_EOL;
    echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
    echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
    exit;
    }
    
    mysqli_set_charset($db_connector,"utf8");
	
    $request = $_REQUEST["request"];
    if($request=="insert") {
        
       $id = $_REQUEST["id"];
       $name = normalize($_REQUEST["name"]);
	   $birthday = $_REQUEST["birthday"];
	   $qualifications = $_REQUEST["qualifications"];
	   $course = $_REQUEST["course"];
	   
	    $get = "SELECT `courses`.`id` FROM courses WHERE (courses.designation = '".$course."')";
		if (($result=mysqli_query($db_connector, $get))==NULL) {
        echo "Error while fetching Course ID";
        }
        $row = mysqli_fetch_array($result);
		$courseID = $row["id"];
	   
	   $insert = "INSERT INTO pieces VALUES ('".$id."', '".$name."', '".$birthday."','".$qualifications."','".$courseID."');";
       if (!mysqli_query($db_connector, $insert)) {
        echo "That piece number is already in use, please check if it´s correct";
        }
	   else{
	   
	       echo "Teacher inserted successfully";
	   }
       
    
    }
    
    if($request=="list") {
        
       
	   $q="SELECT * FROM `pieces` ORDER BY `pieces`.`name` ASC";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os pieces: %s.\n", mysqli_error($db_connector));
        }
        
        
        $pieces = array();
        $piece = array();
        while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $piece[0] = $row["id"];
            $piece[1] = $row["name"];
            $piece[2] = $row["description"];
            $piece[3] = $row["year"];
            $piece[4] = $row["duration"];
            
            //get composer designation
            $get = "SELECT * FROM composers WHERE (composers.id = '".$row["composer"]."')";
		      if (($resultC=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Composer designation";
                }
                $rowC = mysqli_fetch_array($resultC);
		          $composerD = $rowC["name"];
            
            ///
            $piece[5] = $composerD;
            $idP = substr($row["id"], 1);
            $p1 = '<button type="button" onclick="editpiece('.$idP.')" class="btn btn-warning">Edit</button>';
            $piece[6] = $p1;
            $p2 = '<button type="button" onclick="removepiece('.$idP.')" class="btn btn-danger">Delete</button>';
            $piece[7] = $p2;
            $pieces[]=$piece;
        }
	   
	   echo json_encode($pieces);
    
    }
    
    


?>
