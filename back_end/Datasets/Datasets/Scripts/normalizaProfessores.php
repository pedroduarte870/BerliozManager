
<?php
    $cursos = simplexml_load_file("../Normalizados/cursos.xml");
    $habilitacoes = simplexml_load_file("../Normalizados/habilitacaos.xml");
    $professores = simplexml_load_file("../Finais/professors.xml");
    
    foreach($professores->professor as $p)
    {
        $curso = $p->curso;
        $idCurso = $cursos->xpath("//curso[designacao = '".$curso."']/@id")[0];
        
        $p->curso = $idCurso;
        
        $habilitacao = $p->habilitacoes;
        $idHabilitacao = $habilitacoes->xpath("//habilitacao[. = '".$habilitacao."']/@id")[0];
        
        $p->habilitacoes = $idHabilitacao;
    }
    
    $professores->asXML("../Normalizados/professors.xml");
?>