
<?php
    $alunos = simplexml_load_file("../Finais/alunos.xml");
    $instrumentos = simplexml_load_file("../Normalizados/instrumentos.xml");
    
    foreach($alunos->aluno as $a)
    {
        $inst = $a->instrumento;
        $idInst = $instrumentos->xpath("//instrumento[. = '".$inst."']/@id")[0];
        
        $a->instrumento = $idInst;
    }
    
    $alunos->asXML("../Normalizados/alunos.xml");
?>