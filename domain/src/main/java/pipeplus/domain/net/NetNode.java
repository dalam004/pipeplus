package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public abstract class NetNode extends NetObject{

  private List<Location> mPosition = new ArrayList<>(1);
  private NameLabel mNameLabel;


// Fix-Me:: A hack is employed to have the xml structure <graphics><position x="" y=""/></graphics>. THere may be a better
//  idea to do it. If one could be found this hack should be replaced.

  @JacksonXmlElementWrapper(localName = "graphics")
  @JacksonXmlProperty(localName = "position")
  private List<Location> getPositions() {
    return mPosition;
  }

  private void setPosition(List<Location> pPosition) {
    setLocation(pPosition.get(0));
  }

  public Location getPosition() {
    return mPosition.isEmpty() ? null : mPosition.get(0);
  }

  public void setLocation(Location pPosition) {
    if (mPosition.isEmpty()) {
      mPosition.add(pPosition);
    }
    else  {
      mPosition.set(0, pPosition);
    }
  }

  @JacksonXmlProperty(localName = "name")
  public NameLabel getNameLabel() {
    return mNameLabel;
  }

  public void setNameLabel(NameLabel pNameLabel) {
    mNameLabel = pNameLabel;
  }

  public String name() {
    return mNameLabel.getName();
  }
}
