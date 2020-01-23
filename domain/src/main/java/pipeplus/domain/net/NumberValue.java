package pipeplus.domain.net;

import pipeplus.domain.net.type.Type;

public class NumberValue extends Value {

  //  TODO:: Implement the hierarchy properly and configure serialization and deserialization

  public NumberValue(Number pValue) {
    super(pValue.toString(), Type.NUMBER.typeName());
  }

  @Override
  public String getType() {
    return Type.NUMBER.typeName();
  }
}
