<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
        
    <xsl:output method="xml" indent="yes"/>    
        
    <xsl:template match="/">
        <xsl:result-document href="../Normalizados/habilitacaos.xml">
            <habilitacoes>
                <xsl:apply-templates mode="a"/>
                <xsl:apply-templates/>
            </habilitacoes>
        </xsl:result-document>
    </xsl:template>
    
    <xsl:template match="instrumento" mode="a">
        <habilitacao id="HL{count(preceding-sibling::*) + 1}">Licenciatura em <xsl:value-of select="."/></habilitacao>
    </xsl:template>
    
    <xsl:template match="instrumento">
        <habilitacao id="HM{count(preceding-sibling::*) + 1}">Mestrado em <xsl:value-of select="."/></habilitacao>
    </xsl:template>
</xsl:stylesheet>