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
	   
	   $insert = "INSERT INTO teachers VALUES ('".$id."', '".$name."', '".$birthday."','".$qualifications."','".$courseID."');";
       if (!mysqli_query($db_connector, $insert)) {
        echo "That teacher number is already in use, please check if it´s correct";
        }
	   else{
	   
	       echo "Teacher inserted successfully";
	   }
       
    
    }
    
    if($request=="list") {
        
       
	   $q="SELECT * FROM `teachers` ORDER BY `teachers`.`name` ASC";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os teachers: %s.\n", mysqli_error($db_connector));
        }
        
        
        $teachers = array();
        $teacher = array();
        while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $teacher[0] = $row["ID"];
            $teacher[1] = $row["name"];
            $teacher[2] = $row["birthday"];
            $teacher[4] = $row["qualifications"];
            //get course designation
            $get = "SELECT * FROM courses WHERE (courses.id = '".$row["course"]."')";
		      if (($resultC=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Course designation";
                }
                $rowC = mysqli_fetch_array($resultC);
		          $courseD = $rowC["designation"];
            
            ///
            $teacher[3] = $courseD;
            $idT = substr($row["ID"], 1);
            $p1 = '<button type="button" onclick="editteacher('.$idT.')" class="btn btn-warning">Edit</button>';
            $teacher[5] = $p1;
            $p2 = '<button type="button" onclick="removeteacher('.$idT.')" class="btn btn-danger">Delete</button>';
            $teacher[6] = $p2;
            $teachers[]=$teacher;
        }
	   
	   echo json_encode($teachers);
    
    }


    if($request=="teacherc") {

        $id = $_REQUEST["id"];
        
       
       $q="SELECT * FROM  `teachers`WHERE  `id` LIKE '".$id."'";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list teachers: %s.\n", mysqli_error($db_connector));
        }       
        
      
            $teacher = array();
            $row = $result->fetch_array(MYSQL_ASSOC); 
            $teacher[0] = $row["ID"];
            $teacher[1] = $row["name"];
            $teacher[2] = $row["birthday"];
            $teacher[4] = $row["qualifications"];
             //get course designation
            $get = "SELECT * FROM courses WHERE (courses.id = '".$row["course"]."')";
              if (($resultC=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Course designation";
                }
                $rowC = mysqli_fetch_array($resultC);
                  $courseD = $rowC["designation"];
            
            ///
            $teacher[3] = $courseD;        
       
       echo json_encode($teacher);
    
    }


        if($request=="update") {
        
       $id = $_REQUEST["id"];
       $name = normalize($_REQUEST["name"]);
       $birthday = $_REQUEST["birthday"];
       $course = $_REQUEST["course"];
       $qualifications = $_REQUEST["qualifications"];
       
       
        $get = "SELECT `courses`.`id` FROM courses WHERE (courses.designation = '".$course."')";
        if (($result=mysqli_query($db_connector, $get))==NULL) {
        echo "Error while fetching Course ID";
        }
        $row = mysqli_fetch_array($result);
        $courseID = $row["id"];
        $update = "UPDATE  `berlioz_DB`.`teachers` SET  `name` =  '".$name."' ,`birthday` =  '".$birthday."' ,`course` =  '".$courseID."' ,`qualifications` =  '".$qualifications."' WHERE  `teachers`.`id` =  '".$id."';";
       
       
       if (!mysqli_query($db_connector, $update)) {
        printf("Error updating teachers: %s.\n", mysqli_error($db_connector));
        }
       else{
       
           echo "teachers updated successfully";
       }
       
    
    }

    
    


?>
