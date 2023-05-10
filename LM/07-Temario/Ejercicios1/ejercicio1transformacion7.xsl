<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="ies">
        <html>
        <body>
            <h1><xsl:value-of select="@nombre"/></h1>
            <p>Pagina Web: <a><xsl:attribute name="href"><xsl:value-of select="@web"/></xsl:attribute> <xsl:value-of select="@web"/></a></p>
            <table border="1">
                <tr>
                    <th>Nombre del ciclo</th>
                    <th>Grado</th>
                    <th>Año del titulo</th>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
        </html>
    </xsl:template>
    <xsl:template match="ciclo">
        <tr>
            <td><xsl:value-of select="nombre"/></td>
            <td><xsl:value-of select="grado"/></td>
            <td><xsl:value-of select="decretoTitulo/@año"/></td>            
        </tr>
    </xsl:template>
</xsl:stylesheet>