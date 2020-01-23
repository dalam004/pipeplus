package pipeplus.domain;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Assert;
import org.junit.Test;
import pipeplus.domain.net.NetModel;
import pipeplus.domain.net.type.DataType;

import java.io.IOException;
import java.util.Collection;

public class NetTest {

  @Test
  public void testNet() throws IOException {
    XmlMapper mapper = new XmlMapper();
    mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
    NetModel model = mapper.readValue(getClass().getResourceAsStream("/net.xml"), NetModel.class);

    Collection<DataType> datatypes = model.getNets().get(0).getDataTypes();
    Assert.assertEquals(2, datatypes.size());
  }
}
