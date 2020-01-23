package pipeplus.domain.net.type;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "field")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonPropertyOrder({"name", "type", "min", "max"})
public class Field {

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String mName;

    @JsonIgnore
    private Type mType;

    @JacksonXmlProperty(localName = "min", isAttribute = true)
    private Number mMinValue;

    @JacksonXmlProperty(localName = "max", isAttribute = true)
    private Number mMaxValue;

    public Field() {
//Note:: Empty by design
    }

    public Field(final String pName, final String pType){
        mName = pName;
        mType = Type.of(pType);
    }

    public Field(final String pName, final String pType, final double pMinValue, final double pMaxValue) {
        this(pName, pType);
        mMinValue = pMinValue;
        mMaxValue = pMaxValue;
    }

    public String getName() {
        return mName;
    }

    public void setName(String pName) {
        mName = pName;
    }

    public Type getType() {
        return mType;
    }

    @JacksonXmlProperty(localName = "type", isAttribute = true)
    public String getTypeName() {
        return mType.typeName();
    }

    @JsonSetter("type")
    public void setType(String pType) {
        mType = Type.of(pType);
    }

    public void setType(Type pType) {
        mType = pType;
    }

    @JsonIgnore
    public Number getMinValue() {
        return mMinValue;
    }

    public void setMinValue(Number pMinValue) {
        mMinValue = pMinValue;
    }

    @JsonIgnore
    public Number getMaxValue() {
        return mMaxValue;
    }

    public void setMaxValue(Number pMaxValue) {
        mMaxValue = pMaxValue;
    }

    public void setRange(final double pMinValue, final double pMaxValue) {
        mMinValue = pMinValue;
        mMaxValue = pMaxValue;
    }
}
