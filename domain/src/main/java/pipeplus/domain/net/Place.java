package pipeplus.domain.net;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "place")
public class Place extends NetNode {

  private String mDataTypeName;
  private int mCapacity;
  private List<Token> mInitialMarking = new ArrayList<>(5);
  private boolean mContinuous;
  private String mFormula;


  @JacksonXmlProperty(localName = "datatype", isAttribute = true)
  public String getDataTypeName() {
    return mDataTypeName;
  }

  public void setDataTypeName(String pDataTypeName) {
    mDataTypeName = pDataTypeName;
  }

  @JacksonXmlProperty(localName = "capacity")
  public int getCapacity() {
    return mCapacity;
  }

  public void setCapacity(int pCapacity) {
    mCapacity = pCapacity;
  }

  @JacksonXmlElementWrapper(localName = "initialMarking")
  @JacksonXmlProperty(localName = "token")
  public List<Token> getInitialMarking() {
    return mInitialMarking;
  }

  public void setInitialMarking(List<Token> pInitialMarking) {
    mInitialMarking = pInitialMarking;
  }

  public boolean isContinuous() {
    return mContinuous;
  }

  public void setContinuous(boolean pContinuous) {
    mContinuous = pContinuous;
  }

  public String getFormula() {
    return mFormula;
  }

  public void setFormula(String pFormula) {
    mFormula = pFormula;
  }

  @JsonIgnore
  public String getName() {
    return getNameLabel().getName();
  }
}
