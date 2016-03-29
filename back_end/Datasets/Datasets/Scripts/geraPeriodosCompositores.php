
<?php
    
    $compositores = simplexml_load_file("../Finais/compositores.xml");

    foreach($compositores->compositor as $compositor)
    {
        $ano = intval(substr($compositor->dataNasc,0,4));
        //print intval($ano)."<br/>";
        
        if($ano >= 1300 && $ano < 1500) $periodo = "Medieval";
        else if($ano >= 1500 && $ano < 1650) $periodo = "Renascimento";
        else if($ano >= 1650 && $ano < 1750) $periodo = "Barroco";
        else if($ano >= 1750 && $ano < 1820) $periodo = "Clássico";
        else if($ano >= 1820 && $ano < 1900) $periodo = "Romântico";
        else if($ano >= 1900 && $ano < 2000) $periodo = "Século XX";
        else $periodo = "Contemporâneo";
        
        //não re-executar script com addChild mas com $elemento->filho = $filho para não estragar ficheiro
        //$compositor->addChild('periodo',$periodo);
    }
    
    $compositores->asXML("../Finais/compositores.xml");
?>