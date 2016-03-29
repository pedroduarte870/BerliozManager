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
	   $birth = $_REQUEST["birth"];
	   $year = $_REQUEST["year"];
	   $course = $_REQUEST["course"];
	   
	    $get = "SELECT `courses`.`id` FROM courses WHERE (courses.designation = '".$course."')";
		if (($result=mysqli_query($db_connector, $get))==NULL) {
        echo "Error while fetching Course ID";
        }
        $row = mysqli_fetch_array($result);
		$courseID = $row["id"];
	   
	   $insert = "INSERT INTO students VALUES ('".$id."', '".$name."', '".$birth."','".$year."','".$courseID."');";
       if (!mysqli_query($db_connector, $insert)) {
        echo "That student number is already in use, please check if it´s correct";
        }
	   else{
	   
	       echo "Student inserted successfully";
	   }
       
    
    }

     if($request=="update") {
        
       $id = $_REQUEST["id"];
       $name = normalize($_REQUEST["name"]);
       $birth = $_REQUEST["birth"];
       $year = $_REQUEST["year"];
       $course = $_REQUEST["course"];
       
       
        $get = "SELECT `courses`.`id` FROM courses WHERE (courses.designation = '".$course."')";
        if (($result=mysqli_query($db_connector, $get))==NULL) {
        echo "Error while fetching Course ID";
        }
        $row = mysqli_fetch_array($result);
        $courseID = $row["id"];
        $update = "UPDATE  `berlioz_DB`.`students` SET  `name` =  '".$name."' ,`birthday` =  '".$birth."' ,`courseYear` =  '".$year."' ,`course` =  '".$courseID."' WHERE  `students`.`id` =  '".$id."';";
       
       if (!mysqli_query($db_connector, $update)) {
        printf("Error updating students: %s.\n", mysqli_error($db_connector));
        }
       else{
       
           echo "Student updated successfully";
       }
       
    
    }


    
    if($request=="list") {
        
       
	   $q="SELECT * FROM `students` ORDER BY `students`.`name` ASC";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os students: %s.\n", mysqli_error($db_connector));
        }
        
        
        $students = array();
        $student = array();
        while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $student[0] = $row["id"];
            $student[1] = $row["name"];
            $student[2] = $row["birthday"];
            $student[3] = $row["courseYear"];
            //get course designation
            $get = "SELECT * FROM courses WHERE (courses.id = '".$row["course"]."')";
		      if (($resultC=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Course designation";
                }
                $rowC = mysqli_fetch_array($resultC);
		          $courseD = $rowC["designation"];
		          $instrumentID =  $rowC["instrument"];
            
            ///
            $student[4] = $courseD;
            //get instrument name
            $get = "SELECT * FROM instruments WHERE (instruments.id = '".$instrumentID."')";
		      if (($resultI=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Instrument name";
                }
                $rowI = mysqli_fetch_array($resultI);
		          $instrumentN = $rowI["name"];
            //
            $student[5] = $instrumentN;
            $idS = substr($row["id"], 1);
            $p1 = '<button type="button" onclick="editstudent('.$idS.')" class="btn btn-warning">Edit</button>';
            $student[6] = $p1;
            $p2 = '<button type="button" onclick="removestudent('.$idS.')" class="btn btn-danger">Delete</button>';
            $student[7] = $p2;
            $students[]=$student;
        }
	   
	   echo json_encode($students);
    
    }


    if($request=="studentc") {

         $id = $_REQUEST["id"];
        
       
       $q="SELECT * FROM  `students`WHERE  `id` LIKE '".$id."'";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os students: %s.\n", mysqli_error($db_connector));
        }       
        
      
            $student = array();
            $row = $result->fetch_array(MYSQL_ASSOC); 
            $student[0] = $row["id"];
            $student[1] = $row["name"];
            $student[2] = $row["birthday"];
            $student[3] = $row["courseYear"];
            //get course designation
            $get = "SELECT * FROM courses WHERE (courses.id = '".$row["course"]."')";
              if (($resultC=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Course designation";
                }
                $rowC = mysqli_fetch_array($resultC);
                  $courseD = $rowC["designation"];
                  $instrumentID =  $rowC["instrument"];
            
            ///
            $student[4] = $courseD;
            //get instrument name
            $get = "SELECT * FROM instruments WHERE (instruments.id = '".$instrumentID."')";
              if (($resultI=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Instrument name";
                }
                $rowI = mysqli_fetch_array($resultI);
                  $instrumentN = $rowI["name"];
            //
            $student[5] = $instrumentN;
        
       
       echo json_encode($student);
    
    }


    
    


?>