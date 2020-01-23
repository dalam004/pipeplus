package pipeplus.domain.net.type;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DataTypeTest {

  @Test
  public void datatypeDeSerializerTest() throws IOException {
    XmlMapper mapper = new XmlMapper();
    mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
    DataType datatype = mapper.readValue(getClass().getResourceAsStream("/datatype.xml"), DataType.class);

    Assert.assertEquals(datatype.getName(), "dyn");
    Assert.assertEquals(datatype.isDefined(), true);
    Assert.assertEquals(datatype.isPowerSet(), false);
    Assert.assertEquals(datatype.isContinuous(), true);
    Assert.assertEquals(datatype.getFields().size(), 2);

    System.out.println(mapper.writer().writeValueAsString(datatype));

    DataType datatype2 = mapper.readValue(mapper.writer().writeValueAsString(datatype), DataType.class);
    Assert.assertEquals(datatype.getName(), datatype2.getName());
    Assert.assertEquals(datatype.isDefined(), datatype2.isDefined());
    Assert.assertEquals(datatype.isPowerSet(), datatype2.isPowerSet());
    Assert.assertEquals(datatype.isContinuous(), datatype2.isContinuous());
    Assert.assertEquals(datatype.getFields().size(), datatype2.getFields().size());
  }
}
