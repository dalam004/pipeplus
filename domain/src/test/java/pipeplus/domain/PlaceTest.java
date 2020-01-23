package pipeplus.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pipeplus.domain.net.Location;
import pipeplus.domain.net.NameLabel;
import pipeplus.domain.net.Place;

import java.io.IOException;

public class PlaceTest {

  @Test
  public void testPlaceSerialization() throws JsonProcessingException {
    Place place = new Place();
    place.setLocation(new Location(10.0, 20.0));
    place.setNameLabel(new NameLabel("P0", new Location(5.0, 10.0)));
    place.setDataTypeName("discrete");

    XmlMapper mapper = new XmlMapper();
    String serialized = mapper.writeValueAsString(place);
    System.out.println(serialized);
  }

  @Test
  public void testPlaceDeserialization() throws IOException {
    XmlMapper mapper = new XmlMapper();
    Place place = mapper.readValue(getClass().getResourceAsStream("/place.xml"), Place.class);

    Assert.assertEquals("AircraftA", place.getName());
    Assert.assertEquals(true, place.isContinuous());
    Assert.assertEquals(1, place.getInitialMarking().size());
    Assert.assertTrue(place.getCapacity()==1);
    Assert.assertTrue("ax1[1]=ax+0.5".equals(place.getFormula()));
    System.out.println(place.getInitialMarking().get(0).getValues());

    System.out.println(mapper.writeValueAsString(place));
  }
}
