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
	   
	   $insert = "INSERT INTO courses VALUES ('".$id."', '".$name."', '".$birthday."','".$qualifications."','".$courseID."');";
       if (!mysqli_query($db_connector, $insert)) {
        echo "That composer number is already in use, please check if it´s correct";
        }
	   else{
	   
	       echo "Teacher inserted successfully";
	   }
       
    
    }
    
    if($request=="list") {
        
       
	   $q="SELECT * FROM `courses` ORDER BY `courses`.`designation` ASC";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os courses %s.\n", mysqli_error($db_connector));
        }
        
        
        $courses = array();
        $course = array();
        while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $course[0] = $row["id"];
            $course[1] = $row["designation"];
            $course[2] = $row["duration"];
            //get instrument designation
            $get = "SELECT * FROM instruments WHERE (instruments.id = '".$row["instrument"]."')";
              if (($resultC=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Instrument designation";
                }
                $rowC = mysqli_fetch_array($resultC);
                  $instrumentD = $rowC["name"];
            
            ///
            $course[3] = $instrumentD;
            $idS = substr($row["id"], 1);
            $p1 = '<button type="button" onclick="editcourse('.$idS.')" class="btn btn-warning">Edit</button>';
            $course[4] = $p1;
            $p2 = '<button type="button" onclick="removecourse('.$idS.')" class="btn btn-danger">Delete</button>';
            $course[5] = $p2;            
            $courses[]=$course;
        }
	   
	   echo json_encode($courses);
    
    }
    
    


?>
