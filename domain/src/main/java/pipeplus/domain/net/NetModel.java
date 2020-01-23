package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "pnml")
public class NetModel {

  private String mName;
  private String mFileName;

  private List<Net> mNets;

  public String getName() {
    return mName;
  }

  public void setName(String pName) {
    mName = pName;
  }

  public String getFileName() {
    return mFileName;
  }

  public void setFileName(String pFileName) {
    mFileName = pFileName;
  }

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "net")
  public List<Net> getNets() {
    return mNets;
  }

  public void setNets(List<Net> pNets) {
    mNets = pNets;
  }
}
