<?php
	
	$id = $_POST['id-html'];
	
	$logs = simplexml_load_file('xml/audition'.$id.'.xml');

	$xslt = new XSLTProcessor();
	$XSL = new DOMDocument();
	$XSL->load('to_html.xsl',LIBXML_NOCDATA);
	$xslt->importStylesheet($XSL);

	
	$audicaoHTML = fopen('xml/audition'.$id.'.html','w');
	fwrite($audicaoHTML,$xslt->transformToXML($logs));
	//fclose($auditionHTML);

	header('Location: xml/audition'.$id.'.html');

	//$filename = "auditionX.html";
	// header('Content-Type: application/download');
 //    header('Content-Disposition: attachment; filename='.$filename);
 //    header("Content-Length: " . filesize($filename));
 //    $fp = fopen($filename, "r");
 //    fpassthru($fp);
 //    fclose($fp);

?>