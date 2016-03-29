<?php
   
    $db_connector =  mysqli_connect("localhost","root","","berlioz_DB"); 
	if (!$db_connector) {
    echo "Error: Unable to connect to MySQL." . PHP_EOL;
    echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
    echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
    exit;
    }
	mysqli_set_charset($db_connector,"utf8");
	
    $request = $_REQUEST["request"];
    if($request=="deisgnation") {        
    $q="SELECT `designation` FROM `courses` ORDER BY `courses`.`designation` ASC";
    
    if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Errormessage get Course/Teachers: %s.<br/>", mysqli_error($db_connector));
        }
   
        $myArray = array();
        while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $myArray[] = $row["designation"];
        }

        echo json_encode($myArray);
    }

      
      //$rows =  mysqli_fetch_all($result);
      //echo json_encode($rows);
      //}
        
?>