
<?php
    $xml = simplexml_load_file("../Finais/obras.xml");
    $obras = $xml->xpath("//obra");
    
    foreach($obras as $o)
    {
        $o->desc = str_replace('"',"'",(string)$o->desc);
    }
    
    $xml->asXML("../Finais/obras.xml");
?>