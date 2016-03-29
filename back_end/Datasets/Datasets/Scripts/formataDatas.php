
<?php
    $xml = simplexml_load_file("../Finais/alunos.xml");
    $alunos = $xml->xpath("//aluno");

    foreach($alunos as $a)
    {
        $d = date('Y-m-d',strtotime($a->dataNasc));
        //print $d."<br/>";
        $a->dataNasc = $d;
    }
    
    $xml->asXML("../Finais/alunos.xml");
    
    $xml = simplexml_load_file("../Finais/professors.xml");
    $professores = $xml->xpath("//professor");

    foreach($professores as $a)
    {
        $d = date('Y-m-d',strtotime($a->dataNasc));
        //print $d."<br/>";
        $a->dataNasc = $d;
    }
    
    $xml->asXML("../Finais/professors.xml");
?>


