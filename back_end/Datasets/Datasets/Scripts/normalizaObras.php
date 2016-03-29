
<?php
    $compositores = simplexml_load_file("../Normalizados/compositors.xml");
    $periodos = simplexml_load_file("../Normalizados/periodos.xml");
    $obras = simplexml_load_file("../Finais/obras.xml");
    
    foreach($obras->obra as $o)
    {
        $periodo = $o->periodo;
        $idPeriodo = $periodos->xpath("//periodo[. = '".$periodo."']/@id")[0];
        
        $o->periodo = $idPeriodo;
        
        $compositor = $o->compositor;
        $idCompositor = $compositores->xpath("//compositor[nome = '".$compositor."']/@id")[0];
        
        if($idCompositor != null)
            $o->compositor = $idCompositor;
        else {
            print $o['id']."<br/>";
            print $o->compositor."<br/>";
            }
    }
    
    $obras->asXML("../Normalizados/obras.xml");
?>