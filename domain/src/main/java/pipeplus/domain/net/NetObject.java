package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class NetObject {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String mId = Long.toString(System.currentTimeMillis());

  @JacksonXmlProperty(localName = "container", isAttribute = true)
  private String mContainer = "main";

  public String getId() {
    return mId;
  }

  public void setId(String pId) {
    mId = pId;
  }

  public String getContainer() {
    return mContainer;
  }

  public void setContainer(String pContainer) {
    mContainer = pContainer;
  }
}
