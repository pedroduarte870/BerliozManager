<?php
    $id = $_POST['id-pdf'];

	// Ignorar Warnings do XSL 
    error_reporting(E_ERROR | E_PARSE);

    //$idAudicao = $_REQUEST["idAudicao"];

    // Exportar audicao para XML
    //$outputxmlfile = Audicao::exportarAudicaoParaXML($idAudicao);

    $audicao = simplexml_load_file('xml/audition'.$id.'.xml');

	# LOAD XML FILE
	$xml = new DOMDocument();
	$xml->loadXML($audicao->asXML());

	# START XSLT
	$xslt = new XSLTProcessor();
	$XSL = new DOMDocument();
	$XSL->load( 'to_pdf.xsl', LIBXML_NOCDATA);
	$xslt->importStylesheet( $XSL );
	
	#PRINT
    $out = fopen("out.fo", 'w');
	fwrite($out, $xslt->transformToXML( $xml ));
    fclose($out);

    $pdfname = "xml/audition".$id.".pdf";

    exec("fop out.fo ".$pdfname);
    exec("rm out.fo");

    header('Location: xml/audition'.$id.'.pdf');

    //echo "../../../back_end/Communication/export/xml/".$pdfname;

    //header('Content-Type: application/download');
    //header('Content-Disposition: attachment; filename= xml/audition'.$id.'.pdf');
    //header("Content-Length: " . filesize('xml/audition'.$id.'.pdf'));

?>
