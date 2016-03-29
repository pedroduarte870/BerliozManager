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
    if($request=="show") {

    	
		$myfile = fopen("a.txt", "r") or die("Unable to open file!");
		$id = fgets($myfile);
		fclose($myfile);

        
       $q="SELECT * FROM  `audition` WHERE  `id` ='".$id."'";
   
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting audition: %s.\n", mysqli_error($db_connector));
        }
        
        
        $audition = array();
        $row = mysqli_fetch_array($result);
            $audition[0] = $row["id"];
            $audition[1] = $row["title"];
            $audition[2] = $row["subtitle"];
            $audition[3] = $row["subject"];
            $audition[4] = $row["place"];
            $audition[5] = $row["date"];
            $audition[6] = $row["time"];
            $audition[7] = $row["duration"];

            //get course designation
            /*$get = "SELECT * FROM courses WHERE (courses.id = '".$row["course"]."')";
		      if (($resultC=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Course designation";
                }
                $rowC = mysqli_fetch_array($resultC);
		          $courseD = $rowC["designation"];
		          $instrumentID =  $rowC["instrument"];
            
            ///
            $audition[4] = $courseD;
            //get instrument name
            $get = "SELECT * FROM instruments WHERE (instruments.id = '".$instrumentID."')";
		      if (($resultI=mysqli_query($db_connector, $get))==NULL) {
                echo "Error while fetching Instrument name";
                }
                $rowI = mysqli_fetch_array($resultI);
		          $instrumentN = $rowI["name"];
            //
            $audition[5] = $instrumentN;*/
           
        
	   
	  echo json_encode($audition);
    }


    ?>