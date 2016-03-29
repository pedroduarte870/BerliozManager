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
	   
	    $get = "SELECT `group`.`id` FROM group WHERE (group.name = '".$group."')";
		if (($result=mysqli_query($db_connector, $get))==NULL) {
        echo "Error while fetching Group ID";
        }
        $row = mysqli_fetch_array($result);
		$groupID = $row["id"];
	   
	   $insert = "INSERT INTO groups VALUES ('".$id."', '".$name."');";
       if (!mysqli_query($db_connector, $insert)) {
        echo "That group number is already in use, please check if it´s correct";
        }
	   else{
	   
	       echo "Group inserted successfully";
	   }
       
    
    }
    
    if($request=="list") {
        
       
	   $q="SELECT * FROM `group` ORDER BY `group`.`name` ASC";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os groups: %s.\n", mysqli_error($db_connector));
        }
        
        
        $groups = array();
        $group = array();
        while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $group[0] = $row["id"];
            $group[1] = $row["name"];
            $groups[]=$group;
        }
	   
	   echo json_encode($groups);
    
    }
    
    


?>
