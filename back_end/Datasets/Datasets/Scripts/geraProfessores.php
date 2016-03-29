
<?php
    
    $base = simplexml_load_file("../Originais/alunos.xml");
    $cursos = simplexml_load_file("../Finais/cursos.xml");
    $instrumentos = simplexml_load_file("../Finais/instrumentos.xml");
    
    $xmlstr = "<?xml version='1.0' encoding='UTF-8'?><professores/>";
    $professores = new SimpleXMLElement($xmlstr);

    $pcont = 1;
    foreach($base->aluno as $a)
    {
        $professor = $professores->addChild('professor');
        $professor->addAttribute('id',"P".$pcont);
        $professor->addChild('nome',$a->nome); 
        
        $ano = rand(1945,1992);
        $mes = rand(1,12);
        $dia = rand(1,28);
        $professor->addChild('dataNasc',$ano."-".$mes."-".$dia);
        
        $grau = rand(1,2);
        $inst = rand(1,22);
        $nInst = $instrumentos->xpath("//instrumento[".$inst."]")[0];
        
        if($grau == 1) 
        { 
            $professor->addChild('habilitacoes',"Licenciatura em ".(string)$nInst);
            $professor->addChild('curso',"Curso Básico de ".(string)$nInst);
        }
        else 
        {
            $professor->addChild('habilitacoes',"Mestrado em ".(string)$nInst);
            
            if(rand(1,2) == 1) $professor->addChild('curso',"Curso Básico de ".(string)$nInst);
            else $professor->addChild('curso',"Curso Supletivo de ".(string)$nInst);
        }
        
        $pcont++;
    }
    
    $professores->asXML("../Finais/professores.xml");
?>