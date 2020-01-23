package pipeplus.domain.net.arc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ArcPoint {
  private int mX;
  private int mY;
  private int mSequence;
  private boolean mCurvePoint = false;

  @JsonCreator
  public ArcPoint(@JacksonXmlProperty(localName = "x", isAttribute = true) final int pX,
                  @JacksonXmlProperty(localName = "y", isAttribute = true) final int pY) {
    mX = pX;
    mY = pY;
  }

  public ArcPoint(final int pSequence, final int pX, final int pY, final boolean pCurvePoint) {
    this(pX, pY);
    mSequence = pSequence;
    mCurvePoint = pCurvePoint;
  }

  public int getX() {
    return mX;
  }

  public void setX(final int pX) {
    mX = pX;
  }

  public int getY() {
    return mY;
  }

  public void setY(final int pY) {
    mY = pY;
  }

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  public int getSequence() {
    return mSequence;
  }

  public void setSequence(final int pSequence) {
    mSequence = pSequence;
  }

  @JacksonXmlProperty(localName = "curvePoint", isAttribute = true)
  public boolean isCurvePoint() {
    return mCurvePoint;
  }

  public void setCurvePoint(final boolean pCurvePoint) {
    mCurvePoint = pCurvePoint;
  }

}
