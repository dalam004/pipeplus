package pipeplus.domain.net.arc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pipeplus.domain.net.NetObject;

import java.util.Arrays;
import java.util.List;

@JacksonXmlRootElement(localName = "arc")
@JsonPropertyOrder({"source", "target", "label", "type", "arcpath"})
public class Arc extends NetObject {
  private String mSource;
  private String mTarget;
  private String mLabel;
  private String mType;
  private String mDataTypeName;

  private ArcPath mArcPath;

  @JacksonXmlProperty(localName = "source")
  public String getSource() {
    return mSource;
  }

  public void setSource(final String pSource) {
    mSource = pSource;
  }

  @JacksonXmlProperty(localName = "target")
  public String getTarget() {
    return mTarget;
  }

  public void setTarget(final String pTarget) {
    mTarget = pTarget;
  }

  @JacksonXmlProperty(localName = "datatype", isAttribute = true)
  public String getDataTypeName() {
    return mDataTypeName;
  }

  public void setDataTypeName(final String pDataTypeName) {
    mDataTypeName = pDataTypeName;
  }

  @JacksonXmlProperty(localName = "label")
  public String getLabel() {
    return mLabel;
  }

  public void setLabel(final String pLabel) {
    mLabel = pLabel;
  }

  @JacksonXmlProperty(localName = "type")
  public String getType() {
    return mType;
  }

  public void setType(final String pType) {
    mType = pType;
  }

  @JacksonXmlElementWrapper(localName = "graphics")
  @JacksonXmlProperty(localName = "arcpath")
  public List<ArcPath> getArcPaths() {
    return Arrays.asList(mArcPath);
  }
  public void setArcPaths(final List<ArcPath> pArcPaths) {
    mArcPath = pArcPaths.get(0);
  }


  @JsonIgnore
  public ArcPath getArcPath() {
    return mArcPath;
  }

  public void setArcPath(final ArcPath pArcPath) {
    mArcPath = pArcPath;
  }
}
