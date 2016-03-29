
<?php
    $xml = simplexml_load_file("../Finais/alunos.xml");
    $alunos = $xml->xpath("//aluno");

    foreach($alunos as $a)
    {
        $pals = explode(" ",$a->nome);
        $nome = array();
        foreach($pals as $p)
        {
            array_push($nome,ucfirst(strtolower((string)$p)));
        }
        $a->nome = implode(" ",$nome);  
    }
    
    $xml->asXML("../Finais/alunos.xml");
    
    $xml = simplexml_load_file("../Finais/professors.xml");
    $professors = $xml->xpath("//professor");

    foreach($professors as $a)
    {
        $pals = explode(" ",$a->nome);
        $nome = array();
        foreach($pals as $p)
        {
            array_push($nome,ucfirst(strtolower((string)$p)));
        }
        $a->nome = implode(" ",$nome);  
    }
    
    $xml->asXML("../Finais/professors.xml");
?>