<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <paises>
            <xsl:apply-templates/>
        </paises>
    </xsl:template>       
    <xsl:template match="museo">
        <ciudad>
            <pais>
                <xsl:attribute name="nombre"><xsl:value-of select="pais"/></xsl:attribute>
                <museo>
                    <xsl:attribute name="museo"><xsl:value-of select="nombre"/></xsl:attribute>
                    <xsl:attribute name="ciudad"><xsl:value-of select="ciudad"/></xsl:attribute>
                </museo>
                
            </pais>
            <museo><xsl:value-of select="nombre"/></museo>
        </ciudad>
    </xsl:template>
</xsl:stylesheet>