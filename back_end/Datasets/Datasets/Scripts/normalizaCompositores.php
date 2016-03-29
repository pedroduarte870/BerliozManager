
<?php
    $compositores = simplexml_load_file("../Finais/compositors.xml");
    $periodos = simplexml_load_file("../Normalizados/periodos.xml");
    
    foreach($compositores->compositor as $c)
    {
        $periodo = $c->periodo;
        $idPeriodo = $periodos->xpath("//periodo[. = '".$periodo."']/@id")[0];
        
        $c->periodo = $idPeriodo;
    }
    
    $compositores->asXML("../Normalizados/compositors.xml");
?>