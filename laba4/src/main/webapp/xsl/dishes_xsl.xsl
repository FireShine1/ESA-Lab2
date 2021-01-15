<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
			<head>
				<meta charset="UTF-8"/>
				<title>Dishes</title>
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
						<th>ID</th> <th>Name</th> <th>Type</th> <th>Calorie</th> <th>Ingredients</th> <th>Price</th> 
					</tr>
					<tbody>
						<xsl:for-each select="ArrayList/item">
							<tr><td><xsl:value-of select="id"/></td>
							<td><xsl:value-of select="name"/></td>
							<td><xsl:value-of select="cookery"/></td>
							<td><xsl:value-of select="calorie"/></td>
							<td><xsl:value-of select="ingredients"/></td>
							<td><xsl:value-of select="cost"/></td></tr>
						</xsl:for-each>
					</tbody>
				</table>
            </body>
        </html>
	</xsl:template>
</xsl:stylesheet>