<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="catalog">
        <html>
        <body>
            <table border="1">
                <tr style="background-color: #ADD8E6; text-align: left">
                    <th>Common</th>
                    <th>Botanical</th>
                </tr>
                <xsl:apply-templates select="/catalog/plant[zone > 2]"/>
            </table>
        </body>
        </html>
    </xsl:template>
    <xsl:template match="plant">
        <tr>    
            <td><xsl:value-of select="common"/></td>
            <td><xsl:value-of select="botanical"/></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
