package pipeplus.domain.net.arc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "arcpath")
public class ArcPath  {

  private List<ArcPoint> mArcPoints = new ArrayList<>(2);


  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "arcpoint")
  public List<ArcPoint> getArcPoints() {
    return mArcPoints;
  }

  public void setArcPoints(final List<ArcPoint> pArcPoints) {
    mArcPoints.clear();
    mArcPoints.addAll(pArcPoints);
  }

  public void addArcPoints(final List<ArcPoint> pArcPoints) {
    mArcPoints.addAll(pArcPoints);
  }

  public void addArcPoint(final ArcPoint pArcPoint) {
    mArcPoints.add(pArcPoint);
  }

  public void insertArcPoint(final int pIndex, final ArcPoint pArcPoint) {
    mArcPoints.add(pIndex, pArcPoint);
  }

  public void removeArcPoint(final ArcPoint pArcPoint) {
    mArcPoints.remove(pArcPoint);
  }

  public void addArcPoint(final int pIndex) {
    mArcPoints.remove(pIndex);
  }
}
