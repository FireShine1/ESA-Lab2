<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
			<head>
				<meta charset="UTF-8"/>
				<title>Restaurants</title>
				<link href="https://fonts.googleapis.com/css2?family=Open+Sans&amp;display=swap" rel="stylesheet"/>
				<link rel="stylesheet" href="/css/main.css"/>
			</head>
            <body>
				<div class="buttongroup">
					<button class="btn" onclick="location.href='/dishes'">Dishes</button>
					<button class="btn" onclick="location.href='/restaurants'">Restaurants</button>
					<button class="btn" onclick="location.href='dishes'">XML dishes</button>
					<button class="btn" onclick="location.href='restaurants'">XML restaurants</button>
				</div>
				<table>
					<tr>
						<th>ID</th> <th>Name</th> <th>Type</th> <th>Address</th> <th>Dishes</th>
					</tr>
					<tbody>
						<xsl:for-each select="ArrayList/item">
							<tr><td><xsl:value-of select="id"/></td>
							<td><xsl:value-of select="name"/></td>
							<td><xsl:value-of select="cookery"/></td>
							<td><xsl:value-of select="address"/></td>
							<td><xsl:value-of select="dishes[1]/dishes/name"/>
								<xsl:for-each select="dishes/dishes">
									<xsl:if test="position() > 1">
										, <xsl:value-of select="name"/>
									</xsl:if>
								</xsl:for-each>		
							</td></tr>
						</xsl:for-each>
					</tbody>
				</table>
            </body>
        </html>
	</xsl:template>
</xsl:stylesheet>