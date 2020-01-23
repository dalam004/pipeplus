package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;
import java.util.List;

@JacksonXmlRootElement(localName = "token")
public class Token {

  private Value[] mValues;

  @JacksonXmlProperty(localName = "data")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<? extends Value> getValues() {
    return Arrays.asList(mValues);
  }

  public void setValues(List<Value> pValues) {
    mValues = pValues.toArray(new Value[pValues.size()]);
  }

  public Value valueAtIndex(int pIndex) {
    if (pIndex < 0 || pIndex > mValues.length) {
      throw new IllegalArgumentException("Index , "+pIndex+", is out of bounds.");
    }

    return mValues[pIndex];
  }

  public Value setValueAtIndex(int pIndex, final Value pValue) {
    if (pIndex < 0 || pIndex > mValues.length) {
      throw new IllegalArgumentException("Index , "+pIndex+", is out of bounds.");
    }

    Value oldValue = mValues[pIndex];
    mValues[pIndex] = pValue;
    return oldValue;
  }
}
