package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class NameLabel {

  private String mName;
  private List<Location> mOffset = new ArrayList<>(1);

  public NameLabel() {

  }

  public NameLabel(final String pName) {
    mName = pName;
  }

  public NameLabel (final String pName, final Location pOffset) {
    mName = pName;
    updateOffset(pOffset);
  }

  public NameLabel(final String pName, final double pOffsetX, final double pOffsetY) {
    this(pName, new Location(pOffsetX, pOffsetY));
  }

  @JacksonXmlProperty(localName = "value")
  public String getName() {
    return mName;
  }

  public void setName(String pName) {
    mName = pName;
  }

  @JacksonXmlElementWrapper(localName = "graphics")
  @JacksonXmlProperty(localName = "offset")
  private List<Location> getOffsets() {
    return mOffset;
  }

  public void setOffset(List<Location> pOffsets) {
    updateOffset(pOffsets.get(0));
  }

  public Location getOffset() {
    return mOffset.isEmpty()? null : mOffset.get(0);
  }

  public void updateOffset(Location pOffset) {
    if (mOffset.isEmpty()) {
      mOffset.add(pOffset);
    }
    else {
      mOffset.set(0, pOffset);
    }
  }
}
