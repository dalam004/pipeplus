package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "transition")
public class Transition extends NetNode {
  private String mFormula;

  @JacksonXmlProperty(localName = "formula")
  public String getFormula() {
    return mFormula;
  }

  public void setFormula(String pFormula) {
    mFormula = pFormula;
  }
}
