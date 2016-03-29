<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <xsl:result-document href="../Finais/obras.xml">
            <obras>
                <xsl:apply-templates select="//result">
                    <xsl:sort select="binding[@name = 'nome']/literal"/>    
                </xsl:apply-templates>
            </obras>
        </xsl:result-document>
    </xsl:template>
    
    <xsl:template match="result">
        <obra id="O{count(preceding-sibling::result) + 1}">
            <nome><xsl:value-of select="binding[@name = 'nome']/literal"/></nome>
            <desc><xsl:value-of select="binding[@name = 'desc']/literal"/></desc>
        </obra>
    </xsl:template>
    
</xsl:stylesheet>