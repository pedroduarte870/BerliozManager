<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output indent="yes"/>
    <xsl:strip-space elements="*"/>   
    <xsl:template match="/">
        <xsl:copy>
            <xsl:apply-templates/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template match="/auditions">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="my-page" page-width="8.5in" page-height="11in">
                    <fo:region-body margin="1in" margin-top="1.5in" margin-bottom="1.5in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="my-page">
                <fo:flow flow-name="xsl-region-body">
                    <xsl:apply-templates/>
                </fo:flow>
            </fo:page-sequence>
            
        </fo:root>
    </xsl:template>
    
    <xsl:template match="audition">
        <fo:block>
            <xsl:apply-templates/>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/metadata/title">
        <fo:block text-align="center" font-family="sans-serif" font-size="36px" color="#E45F56">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/metadata/subtitle">
        <fo:block text-align="center" font-family="sans-serif" font-size="30px" color="#35404F">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/metadata/subject">
        <fo:block text-align="center" font-family="sans-serif" font-size="24px" color="#A8B6BF">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/metadata/organizer">
        <fo:block text-align="center" font-family="sans-serif" font-size="20px">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    <xsl:template match="audition/metadata/place">
        <fo:block text-align="center" font-family="sans-serif" font-size="20px">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    <xsl:template match="audition/metadata/date">
        <fo:block text-align="center" font-family="sans-serif" font-size="20px">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    <xsl:template match="audition/metadata/time">
        <fo:block text-align="center" font-family="sans-serif" font-size="20px">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    <xsl:template match="audition/metadata/duration">
        <fo:block text-align="center" font-family="sans-serif" font-size="20px">
            <xsl:value-of select="."/>
        </fo:block>
        <fo:block line-height="5"> </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/metadata/performances">
        <fo:table background-color="#4AAAA5" margin-top="7%">
            <fo:table-body>
                <fo:table-row>
                    <xsl:apply-templates/>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
    </xsl:template>
    
    <xsl:template match="audition/metadata/performances/performance">
        <fo:table-cell>
            <xsl:apply-templates/>
        </fo:table-cell>
    </xsl:template>
    
    <xsl:template match="audition/performances/performance/performers">
        <fo:block>
            <xsl:apply-templates/>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/performances/performance/performers/performer">
        <fo:block text-align="center" font-family="sans-serif" font-size="18px">
            <fo:block font-family="sans-serif" font-size="18px" color="#E45F56">
                Performer:</fo:block><xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    <xsl:template match="audition/performances/performance/group">
        <fo:block text-align="center" font-family="sans-serif" font-size="18px">
            <fo:block font-family="sans-serif" font-size="18px" color="#E45F56">
                Group:</fo:block><xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    <xsl:template match="audition/performances/performance/leaders">
        <fo:block>
            <xsl:apply-templates/>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/performances/performance/leaders/leader">
        <fo:block text-align="center" font-family="sans-serif" font-size="18px">
            <fo:block font-family="sans-serif" font-size="18px" color="#E45F56">
                Leader: </fo:block><xsl:value-of select="."/>;
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/performances/performance/plays">
        <fo:block margin-bottom="40%">
            <xsl:apply-templates/>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="audition/performances/performance/plays/play">
        <fo:block text-align="center" font-family="sans-serif" font-size="18px">
            <fo:block font-family="sans-serif" font-size="18px" color="#E45F56">
                Piece: </fo:block><xsl:value-of select="."/>
        </fo:block>
    </xsl:template>
    
    
</xsl:stylesheet>