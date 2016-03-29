<?php

if($_FILES['file']['error'] > 0)
    {
    echo "ERROR: ".$_FILES['file']['error']."<br/>";
    }
    else{
            
   move_uploaded_file($_FILES['file']['tmp_name'], "audition.txt");
    
   //echo $_FILES['file']['name'];
    }
    
    exec('java -jar "/var/www/html/BerliozManager/front_end/pages/Berlioz.jar" "/var/www/html/BerliozManager/back_end/Communication/audition.txt"', $output);
     
     echo json_encode($output);
        
?>