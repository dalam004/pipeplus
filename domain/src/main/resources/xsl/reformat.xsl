
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:element name="pnml">
            <xsl:apply-templates select="pnml"/>
        </xsl:element>
    </xsl:template>

    <xsl:template match="pnml">
        <xsl:element name="net">
            <xsl:attribute name="id">
                <xsl:value-of select="net/@id"/>
            </xsl:attribute>
            <xsl:attribute name="type">
                <xsl:value-of select="net/@type"/>
            </xsl:attribute>
            <xsl:apply-templates select="net/datatypes">
                <xsl:sort select="@name" data-type="text"/>
            </xsl:apply-templates>
            <xsl:apply-templates select="net/place">
                <xsl:sort select="@id" data-type="text"/>
            </xsl:apply-templates>
            <xsl:apply-templates select="net/transition">
                <xsl:sort select="@id" data-type="text"/>
            </xsl:apply-templates>
            <xsl:apply-templates select="net/arc">
                <xsl:sort select="@id" data-type="text"/>
            </xsl:apply-templates>
        </xsl:element>
    </xsl:template>

    <xsl:template match="net/datatypes">
        <xsl:element name="datatypes">
            <xsl:for-each select="datatype">
                <xsl:call-template name="datatype"/>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>

    <xsl:template name="datatype">
        <xsl:element name="datatype">
            <xsl:element name="name">
                <xsl:value-of select="name/value"/>
            </xsl:element>
            <xsl:element name="fields">
                <xsl:for-each select="field">
                    <xsl:element name="field">
                        <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
                        <xsl:attribute name="type"><xsl:value-of select="@type"/></xsl:attribute>
                        <xsl:attribute name="min"><xsl:value-of select="@min"/></xsl:attribute>
                        <xsl:attribute name="max"><xsl:value-of select="@max"/></xsl:attribute>
                    </xsl:element>
                </xsl:for-each>
                <xsl:call-template name="types_to_fields">
                    <xsl:with-param name="input" select="types/value"/>
                </xsl:call-template>
            </xsl:element>
            <xsl:element name="pow">
                <xsl:value-of select="pow/value"/>
            </xsl:element>
            <xsl:element name="def">
                <xsl:value-of select="def/value"/>
            </xsl:element>
            <xsl:element name="continuous">
                <xsl:value-of select="continuous/value"/>
            </xsl:element>
        </xsl:element>
    </xsl:template>

    <xsl:template name="types_to_fields">
        <xsl:param name="input"/>
        <xsl:if test="string-length($input) &gt; 0">
            <xsl:element name="field">
                <xsl:attribute name="name">field<xsl:value-of select="string-length($input)"/></xsl:attribute>
                <xsl:choose>
                    <xsl:when test="contains($input, ',')">
                        <xsl:attribute name="type"><xsl:value-of select="normalize-space(substring-before($input, ','))"/></xsl:attribute>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:attribute name="type"><xsl:value-of select="normalize-space($input)"/></xsl:attribute>
                    </xsl:otherwise>
                </xsl:choose>

                <xsl:attribute name="min">0.0</xsl:attribute>
                <xsl:attribute name="max">0.0</xsl:attribute>
            </xsl:element>
            <xsl:call-template name="types_to_fields">
                <xsl:with-param name="input" select="substring-after($input, ',')"/>
            </xsl:call-template>
        </xsl:if>
    </xsl:template>


    <xsl:template match="net/place">
        <xsl:element name="place">
            <xsl:attribute name="id">
                <xsl:value-of select="@id"/>
            </xsl:attribute>
            <xsl:attribute name="datatype">
                <xsl:value-of select="@datatype"/>
            </xsl:attribute>
            <xsl:attribute name="container">
                <xsl:value-of select="@container"/>
            </xsl:attribute>

            <xsl:call-template name="place-transition"/>
            <xsl:element name="capacity">
                <xsl:value-of select="capacity/value"/>
            </xsl:element>

            <xsl:element name="initialMarking">
                <xsl:for-each select="token">
                    <xsl:copy-of select="."/>
                </xsl:for-each>
                <xsl:for-each select="abtoken/listToken/token">
                    <xsl:copy-of select="."/>
                </xsl:for-each>
            </xsl:element>

            <xsl:element name="continuous">
                <xsl:value-of select="continuous/value"/>
            </xsl:element>
        </xsl:element>

    </xsl:template>

    <xsl:template match="net/transition">
        <xsl:element name="transition">
            <xsl:attribute name="id">
                <xsl:value-of select="@id"/>
            </xsl:attribute>
            <xsl:attribute name="container">
                <xsl:value-of select="@container"/>
            </xsl:attribute>

            <xsl:call-template name="place-transition"/>
        </xsl:element>
    </xsl:template>

    <xsl:template name="place-transition">
        <xsl:copy-of select="graphics"/>
        <xsl:copy-of select="name"/>
        <xsl:element name="formula">
            <xsl:value-of select="formula/value"/>
        </xsl:element>
    </xsl:template>

    <xsl:attribute-set name="as_arcpoint">
        <xsl:attribute name="id"/>
        <xsl:attribute name="x"/>
        <xsl:attribute name="y"/>
        <xsl:attribute name="curvePoint"/>
    </xsl:attribute-set>

    <xsl:template match="net/arc">
        <xsl:element name="arc">
            <xsl:attribute name="id">
                <xsl:value-of select="@id"/>
            </xsl:attribute>
            <xsl:attribute name="container">
                <xsl:value-of select="@container"/>
            </xsl:attribute>
            <xsl:attribute name="datatype">
                <xsl:value-of select="@datatype"/>
            </xsl:attribute>
            <xsl:element name="source">
                <xsl:value-of select="@source"/>
            </xsl:element>
            <xsl:element name="target">
                <xsl:value-of select="@target"/>
            </xsl:element>
            <xsl:element name="label">
                <xsl:value-of select="@variable"/>
            </xsl:element>
            <xsl:element name="type">
                <xsl:value-of select="type/@value"/>
            </xsl:element>

            <xsl:element name="graphics">
                <xsl:element name="arcpath">
                    <xsl:for-each select="arcpath">
                        <xsl:element name="arcpoint">
                            <xsl:attribute name="id">
                                <xsl:value-of select="@id"/>
                            </xsl:attribute>
                            <xsl:attribute name="x">
                                <xsl:value-of select="@x"/>
                            </xsl:attribute><xsl:attribute name="y">
                            <xsl:value-of select="@y"/>
                        </xsl:attribute><xsl:attribute name="curvePoint">
                            <xsl:value-of select="@curvePoint"/>
                        </xsl:attribute>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>

            </xsl:element>
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>

