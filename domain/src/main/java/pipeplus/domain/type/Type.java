package pipeplus.domain.type;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public enum Type {

  STRING("string"),
  NUMBER("number");

  private String mTypeName;
  private Type(final String pTypename) {
    mTypeName = pTypename;
  }

  public String typeName() {
    return mTypeName;
  }

  public static Type of(final String pTypeName) {
    valueOf(pTypeName.toUpperCase());
    return STRING.mTypeName.equals(pTypeName) ? STRING : NUMBER;
  }
}
