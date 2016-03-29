<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
        
    <xsl:output method="xml" indent="yes"/>    
        
    <xsl:template match="/">
        <xsl:result-document href="../Finais/cursos.xml">
            <cursos>
                <xsl:apply-templates/>
            </cursos>
        </xsl:result-document>
    </xsl:template>
    
    <xsl:template match="instrumento">
        <curso id="CB{count(preceding-sibling::*)+1}">
            <designacao>Curso Básico de <xsl:value-of select="."/></designacao>
            <duracao>5</duracao>
            <instrumento><xsl:value-of select="."/></instrumento>
        </curso>
        
        <xsl:element name="curso">
            <xsl:attribute name="id">CS<xsl:value-of select="count(preceding-sibling::*)+1"/></xsl:attribute>
            <xsl:element name="designacao">Curso Supletivo de <xsl:value-of select="."/></xsl:element>
            <xsl:element name="duracao">3</xsl:element>
            <xsl:element name="instrumento"><xsl:value-of select="."/></xsl:element>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>