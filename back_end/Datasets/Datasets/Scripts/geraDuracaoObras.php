
<?php
    
    $obras = simplexml_load_file("../Finais/obras.xml");

    foreach($obras->obra as $obra)
    {
        $hor = sprintf('%02d',rand(0,1));
        $min = sprintf('%02d',rand(0,59));
        $seg = sprintf('%02d',rand(0,59));
        $obra->addChild('duracao',$hor.":".$min.":".$seg);
        
        $duracao = $hor.":".$min.":".$seg;
        $obra->addChild('duracao',$hor.":".$min.":".$seg);
        //não re-executar script com addChild mas com $elemento->filho = $filho para não estragar ficheiro
        $obra->addChild('duracao',$duracao);
    }
    
    $obras->asXML("../Finais/obras.xml");
?>