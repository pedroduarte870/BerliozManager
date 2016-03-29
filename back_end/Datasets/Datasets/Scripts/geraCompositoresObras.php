
<?php
    
    $obras = simplexml_load_file("../Finais/obras.xml");
    $compositores = simplexml_load_file("../Finais/compositores.xml");
    
    foreach($obras->obra as $obra)
    {
        $compositoresPorPeriodo = $compositores->xpath("//compositor[periodo ='".$obra->periodo."']");
        
        if(count($compositoresPorPeriodo) == 0) 
        {
            $id = "C".(rand(1,168)*2);
            $comp = $compositores->xpath("//compositor[@id='".$id."']")[0];
        }
        else $comp = $compositoresPorPeriodo[rand(1,count($compositoresPorPeriodo)) - 1];
        
        //não re-executar script com addChild mas com $elemento->filho = $filho para não estragar ficheiro
        //$obra->addChild('compositor',$comp->nome);
    }
    
    $obras->asXML("../Finais/obras.xml");
?>