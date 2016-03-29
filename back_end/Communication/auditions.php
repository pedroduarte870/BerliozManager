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
    header('Content-type: text/html; charset=utf-8');    
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
       $title = normalize($_REQUEST["title"]);
	   $subtitle = normalize($_REQUEST["subtitle"]);
	   $subject = normalize($_REQUEST["subject"]);
	   $place = normalize($_REQUEST["place"]);
       $date = $_REQUEST["date"];
       $time = $_REQUEST["time"];
       $duration = $_REQUEST["duration"];
	   
       $get = "SELECT MAX('id') FROM auditions";
        if (($result=mysqli_query($db_connector, $get))==NULL) {
        echo "Error while fetching ID";
        }
        $row = mysqli_fetch_array($result);
        $auditionID = $row["id"];
	   
	   $insert = "INSERT INTO auditions VALUES ('".$id."', '".$title."', '".$subtitle."','".$subject."','".$place."','".$place."','".$date."','".$time."','".$duration."',);";
       if (!mysqli_query($db_connector, $insert)) {
        echo "That audition number is already in use, please check if it´s correct";
        }
	   else{
	   
	       echo "Audition inserted successfully";
	   }
       
    
    }
    
    if($request=="list") {
        
       
	   $q="SELECT * FROM `audition` ORDER BY `audition`.`date` ASC";
    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os auditions: %s.\n", mysqli_error($db_connector));
        }
        
        
        $auditions = array();
        $audition = array();
        while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $audition[0] = $row["id"];
            $audition[1] = $row["title"];
            $audition[2] = $row["subtitle"];
            $audition[3] = $row["subject"];
            $audition[4] = $row["place"];
            $audition[5] = $row["date"];
            $audition[6] = $row["time"];
            $audition[7] = $row["duration"];
            $idS = $row["id"];
            $p1 = '<button type="button" onclick="editaudition('.$idS.')" class="btn btn-warning">Edit</button>';
            $audition[8] = $p1;
            $p2 = '<button type="button" onclick="removeaudition('.$idS.')" class="btn btn-danger">Delete</button>';
            $audition[9] = $p2;
            $p3 = '<button type="button" onclick="consultaudition('.$idS.')" class="btn btn-info">Consult</button>';
            $audition[10] = $p3;



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
            $auditions[]=$audition;
        }
	   
	   echo json_encode($auditions);
    
    }
    
     if($request=="audition") {
        $id = $_REQUEST["id"];
       
       $q="SELECT * FROM `audition` WHERE (audition.id = '".$id."')";
       $qq="SELECT * FROM  `performances` WHERE  `audition` = '".$id."'";    
        if (($result=mysqli_query($db_connector, $q))==NULL) {
        printf("Error getting list os auditions: %s.\n", mysqli_error($db_connector));
        }       
       
        $audition = array();
            $row = $result->fetch_array(MYSQL_ASSOC);
            $audition[0] = $row["id"];
            $audition[1] = $row["title"];
            $audition[2] = $row["subtitle"];
            $audition[3] = $row["subject"];
            $audition[4] = $row["place"];
            $audition[5] = $row["date"];
            $audition[6] = $row["time"];
            $audition[7] = $row["duration"]; 

        

        if (($result2=mysqli_query($db_connector, $qq))==NULL) {
        printf("Error getting list os auditions: %s.\n", mysqli_error($db_connector));
        }     

        $performances = array();
        while($row = $result2->fetch_array(MYSQL_ASSOC)) {
            $performance = array();
            $performers = array();
           if($row["student"]==NULL){
                $q3 = "SELECT * FROM `group` WHERE (group.id = '".$row["group"]."')";
                $q5 = "SELECT students.name, students.id FROM students INNER JOIN group_students ON ( students.id = group_students.studentsid AND group_students.groupi = ".$row["group"].")"; 
                 if (($result1=mysqli_query($db_connector, $q3))==NULL) {
                printf("Error getting designation of groups: %s.\n", mysqli_error($db_connector));
                }

                $rowg = $result1->fetch_array(MYSQL_ASSOC);
                $performers[0] = $rowg["name"];

                if (($result3=mysqli_query($db_connector, $q5))==NULL) {
                printf("Error getting designation of names of the groups elements: %s.\n", mysqli_error($db_connector));
                }

                while($rown = $result3->fetch_array(MYSQL_ASSOC)) {


                    $performers[] = $rown["name"];

                }



           }
           else {
            $q4 = "SELECT * FROM  `students` WHERE  `id` = '".$row["student"]."'"; 
            if (($results=mysqli_query($db_connector, $q4))==NULL) {
            printf("Error getting list os students name: %s.\n", mysqli_error($db_connector));
            }   
           
            $rowg = $results->fetch_array(MYSQL_ASSOC);
            $performers[0] = $rowg["name"];
           }

           $teachers = array();
           $qteachers = "SELECT teachers.name, teachers.id FROM teachers INNER JOIN teachers_performances ON ( teachers.id = teachers_performances.teachersID AND teachers_performances.performancesid =".$row["id"].")";
           if (($resultst=mysqli_query($db_connector, $qteachers))==NULL) {
            printf("Error getting list os students name: %s.\n", mysqli_error($db_connector));
            }  

            while($rowt = $resultst->fetch_array(MYSQL_ASSOC)) {


                    $teachers[] = $rowt["name"];

                } 

            $pieces = array();
            $piece = array();
            $qpieces = "SELECT pieces. * , composers.name AS composern FROM pieces LEFT JOIN composers ON pieces.composer = composers.id INNER JOIN pieces_performances ON ( pieces.id = pieces_performances.piecesid AND pieces_performances.performancesid =".$row["id"].")";
            if (($resultsp=mysqli_query($db_connector, $qpieces))==NULL) {
            printf("Error getting list pieces name: %s.\n", mysqli_error($db_connector));
            }  

            while($rowp = $resultsp->fetch_array(MYSQL_ASSOC)) {

                    $piece [0] = $rowp["id"];
                    $piece [1] = $rowp["name"];
                    $piece [2] = $rowp["description"];
                    $piece [3] = $rowp["year"];
                    $piece [4] = $rowp["duration"];
                    $piece [5] = $rowp["composern"];

                    $pieces[] = $piece;

                } 




           $performance[0] = $performers;
           $performance[1] = $teachers;
           $performance[2] = $pieces;
           $performances[] = $performance;

        }

        $audition[8] = $performances;  


        
        
        


                  



       echo json_encode($audition);
    
    }
    
    
    if($request=="addAudition") {
    $locale='de_DE.UTF-8';
    setlocale(LC_ALL,$locale);
    putenv('LC_ALL='.$locale);
    exec('java -jar "C:\wamp\www\BerliozManager\front_end\pages\Berlioz.jar" "C:\wamp\www\BerliozManager\front_end\pages\testeGAMU.txt"', $output);
     
     echo json_encode($output);
    
    }
    
    if($request=="addBox") {
    $locale='de_DE.UTF-8';
    setlocale(LC_ALL,$locale);
    putenv('LC_ALL='.$locale);
    
    $text = $_REQUEST["box"];
    
    $myfile = fopen("audition.txt", "w") or die("Unable to open file!");
    fwrite($myfile, $text);
    fclose($myfile);

    
    exec('java -jar "/var/www/html/BerliozManager/front_end/pages/Berlioz.jar" "/var/www/html/BerliozManager/back_end/Communication/audition.txt"', $output);
     
    echo json_encode($output);
    
    }
    
    
    if($request=="removeA") {
    $id = $_REQUEST["id"];
    
             $q = "DELETE FROM `berlioz_DB`.`audition` WHERE `audition`.`id` =".$id;
            if (($result=mysqli_query($db_connector, $q))==NULL) {
            printf("Error deleting audition: %s.\n", mysqli_error($db_connector));
            }
   
    }

    if($request=="textUP") {
    
    $id = $_REQUEST["id"];
    $path = "export/txt/".$id.".txt";
    $myfile = fopen($path, "r") or die("Unable to open file!");
    echo fread($myfile,filesize($path));
    fclose($myfile);
    
    }

?>