
<?php
    $cursos = simplexml_load_file("../Finais/cursos.xml");
    $instrumentos = simplexml_load_file("../Finais/instrumentos.xml");
    
    foreach($cursos->curso as $c)
    {
        $inst = $c->instrumento;
        $idInst = $instrumentos->xpath("//instrumento[. = '".$inst."']/@id")[0];
        
        $c->instrumento = $idInst;
    }
    
    $cursos->asXML("../Normalizados/cursos.xml");
?>