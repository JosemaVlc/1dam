<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
    
      <body>
        <h1>
          <xsl:attribute name="@nombre">
        </h1>
        <xsl:apply-templates/>
      </body>
    </html></xsl:attribute>
  </xsl:template>
  <xsl:template match="ciclo">
    <p><xsl:value-of select="nombre"/></p>
  </xsl:template>
</xsl:stylesheet>