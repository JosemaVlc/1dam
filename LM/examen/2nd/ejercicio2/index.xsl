<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="ies">
    <html>
        <body>
           <xsl:apply-templates/>
           <xsl:for-each select="ciclos/ciclo">
                <p><xsl:value-of select="nombre"/></p>
           </xsl:for-each>
           <ul>
                <xsl:for-each select="ciclos/ciclo">
                        <li><xsl:value-of select="nombre"/> (<xsl:value-of select="grado"/>)</li>
                </xsl:for-each>
           </ul>
           <ol>
                <xsl:for-each select="ciclos/ciclo">
                        <xsl:sort select="nombre" order="descending"/>
                        <li><xsl:value-of select="nombre"/> (<xsl:value-of select="grado"/>)</li>
                </xsl:for-each>           
           </ol>
        </body>
    </html>
</xsl:template>
<xsl:template match="ciclo">
    <xsl:value-of select="nombre"/>
</xsl:template>               
</xsl:stylesheet>