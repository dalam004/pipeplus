package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Location {
  @JacksonXmlProperty(localName = "x", isAttribute = true)
  private double x;

  @JacksonXmlProperty(localName = "y", isAttribute = true)
  private double y;

  public Location() {

  }

  public Location(final double pX, final double pY) {
    x = pX;
    y = pY;
  }

  public double getX() {
    return x;
  }

  public void setX(double pX) {
    x = pX;
  }

  public double getY() {
    return y;
  }

  public void setY(double pY) {
    y = pY;
  }
}
