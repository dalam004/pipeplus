package pipeplus.domain.net;

import pipeplus.domain.net.type.Type;

public class StringValue extends Value {

//  TODO:: Implement the hierarchy properly and configure serialization and deserialization
  public StringValue(String pValue) {
    super(pValue, Type.STRING.typeName());
  }

  @Override
  public String getType() {
    return Type.STRING.typeName();
  }

}
