<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
          <html>
               <head>
                    <style type="text/css">
                         table.tfmt {
                         border: 1px ;
                         }
        
                         td.colfmt {
                         border: 1px ;
                         background-color: white;
                         color: black;
                         text-align:center;
                         }

                         th {
                         background-color: #00FF99;
                         color: white;
                         }
                    </style>
               </head>
               <body>
                    <table class="tfmt">
                         <tr>
                              <th style="width:100px">Player ID:</th>
                              <th style="width:350px">Full Name:</th>
                              <th style="width:200px">Country:</th>
                              <th style="width:100px">Score game 1:</th>
                              <th style="width:100px">Score game 2:</th>
                              <th style="width:100px">Score game 3:</th>
                              <th style="width:100px">Score Total:</th>
                         </tr>
                         <xsl:for-each select="Players/Player">
                               <tr>
                                    <td class="colfmt"><xsl:value-of select="playerid" /></td>
                                    <td class="colfmt"><xsl:value-of select="playername" /></td>
                                    <td class="colfmt"><xsl:value-of select="playercountry" /></td>
                                    <td class="colfmt"><xsl:value-of select="playerscore1" /></td>
                                    <td class="colfmt"><xsl:value-of select="playerscore2" /></td>
                                    <td class="colfmt"><xsl:value-of select="playerscore3" /></td>
                                    <td class="colfmt"><xsl:value-of select="playertotalscore" /></td>
                               </tr>
                         </xsl:for-each>
                    </table>
               </body>
          </html>
    </xsl:template>
</xsl:stylesheet>