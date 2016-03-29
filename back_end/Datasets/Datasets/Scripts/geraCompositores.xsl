<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <xsl:result-document href="../Finais/compositores.xml">
            <compositores>
                <xsl:apply-templates select="//result[(count(preceding-sibling::result) + 1) mod 2 = 0]">
                    <xsl:sort select="binding[@name = 'nome']/literal"/>    
                </xsl:apply-templates>
            </compositores>
        </xsl:result-document>
    </xsl:template>
    
    <xsl:template match="result">
        <compositor id="C{count(preceding-sibling::result) + 1}">
            <nome><xsl:value-of select="binding[@name = 'nome']/literal"/></nome>
            <bio><xsl:value-of select="binding[@name = 'desc']/literal"/></bio>
            <dataNasc><xsl:value-of select="binding[@name = 'bdate']/literal"/></dataNasc>
            <dataObito><xsl:value-of select="binding[@name = 'ddate']/literal"/></dataObito>
        </compositor>
    </xsl:template>
    
</xsl:stylesheet>