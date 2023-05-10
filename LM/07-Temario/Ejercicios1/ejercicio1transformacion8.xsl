<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="ies">
        <ies>
            <nombre><xsl:value-of select="@nombre"/></nombre>
            <web><xsl:value-of select="@web"/></web>
            <ciclos>
                <xsl:apply-templates/>
            </ciclos>
        </ies>
    </xsl:template>
    <xsl:template match="ciclo">
        <ciclo><xsl:attribute name="id"><xsl:value-of select="@id"/></xsl:attribute>
            <nombre><xsl:value-of select="nombre"/></nombre>
            <grado><xsl:value-of select="grado"/></grado>
            <decretoTitulo><xsl:attribute name="año"><xsl:value-of select="decretoTitulo/@año"/></xsl:attribute></decretoTitulo>            
        </ciclo>
    </xsl:template>
</xsl:stylesheet>