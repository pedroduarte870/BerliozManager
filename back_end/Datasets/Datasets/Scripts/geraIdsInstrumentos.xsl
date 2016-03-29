<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <xsl:result-document href="instrumentos.xml">
            <instrumentos>
                <xsl:apply-templates/>
            </instrumentos>
        </xsl:result-document>
    </xsl:template>
    
    <xsl:template match="instrumento">
        <instrumento id="I{count(preceding-sibling::*) + 1}"><xsl:value-of select="."/></instrumento>
    </xsl:template>
</xsl:stylesheet>