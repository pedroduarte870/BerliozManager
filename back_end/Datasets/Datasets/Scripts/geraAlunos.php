
<?php

    $xmlstr = "<?xml version='1.0' encoding='UTF-8'?><alunos/>";
    $alunos = new SimpleXMLElement($xmlstr);

    if(($handle = fopen("../Originais/pp20203.csv","r")) !== FALSE)
    {
        $cursos = simplexml_load_file("../Finais/cursos.xml");
    
        while(($data = fgetcsv($handle, 1000, ";")) !== FALSE)
        {
            $aluno = $alunos->addChild('aluno');
            $aluno->addAttribute('id',"A".$data[0]);
            $aluno->addChild('nome',$data[1]); 
            
            $ano = rand(1996,2005);
            $mes = rand(1,12);
            $dia = rand(1,28);
            $aluno->addChild('dataNasc',$ano."-".$mes."-".$dia);
            
            if($ano < 2001) 
            { 
                $curso = "CS".rand(1,22); 
                $anoCurso = rand(6,8); 
                
                $aluno->addChild('curso',$curso);
                $aluno->addChild('anoCurso',$anoCurso);
            }
            else 
            { 
                $curso = "CB".rand(1,22); 
                $anoCurso = rand(1,5); 
                
                $aluno->addChild('curso',$curso);
                $aluno->addChild('anoCurso',$anoCurso);
            }
            
            $instrumento = $cursos->xpath("//curso[@id='".$curso."']/instrumento");
            $aluno->addChild('instrumento',$instrumento[0]);  
        }
        fclose($handle);
    }
    
    $alunos->asXML("../Finais/alunos.xml");
?>