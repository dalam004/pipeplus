package pipeplus.domain;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import pipeplus.domain.net.arc.Arc;

import java.io.IOException;

public class ArcTest {

  @Test
  public void testSerializationDeserializationArc() throws IOException {
    XmlMapper mapper = new XmlMapper();

    Arc arc = mapper.readValue(getClass().getResourceAsStream("/arc.xml"), Arc.class);

    System.out.println(mapper.writeValueAsString(arc));
  }
}
