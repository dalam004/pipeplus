package pipeplus.domain.net;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.commons.lang.builder.HashCodeBuilder;
import pipeplus.domain.net.type.Type;

public class Value {
  private final String mValue;
  private final String mType;

  private final Double mDoubleValue;
  private int mHashCode = -1;

  @JsonCreator
  public Value(@JsonProperty("value") final String pValue,
               @JsonProperty("type") final String pType) {
    mValue = pValue;
    mType = pType;
    if (Type.NUMBER.typeName().equals(mType)) {
      mDoubleValue = Double.parseDouble(mValue);
    } else {
      mDoubleValue = null;
    }
  }

  @JacksonXmlProperty(localName = "value")
  public String getValue() {
    return mValue;
  }

  @JacksonXmlProperty(localName = "type", isAttribute = true)
  public String getType() {
    return mType;
  }

  public Number numberValue() {
    if (Type.NUMBER.typeName().equals(mType)) {
      return mDoubleValue;
    }

    throw new IllegalStateException("This is not a number value");
  }

  @Override
  public int hashCode() {

    if (mHashCode == -1) {
      mHashCode =  new HashCodeBuilder().append(mType).append(mValue).hashCode();
    }

    return mHashCode;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Value)) return false;

    Value other = (Value) obj;
    return mType.equals(other.mType) && mValue.equals(other.mValue);

  }
}
