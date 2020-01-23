package pipeplus.domain;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;
import pipeplus.domain.net.NetModel;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ReFormatterTest {

  @Test
  public void testReformatting() throws TransformerException, IOException {
    StreamSource template = new StreamSource(getClass().getResourceAsStream("/xsl/reformat.xsl"));
    Transformer transformer = TransformerFactory.newInstance().newTransformer(template);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    transformer.transform(new StreamSource(getClass().getResourceAsStream("/old_format.xml")), new StreamResult(System.out));
    transformer.transform(new StreamSource(getClass().getResourceAsStream("/old_format.xml")), new StreamResult(outputStream));

    XmlMapper mapper = new XmlMapper();
    NetModel netModel = mapper.readValue(new ByteArrayInputStream(outputStream.toByteArray()), NetModel.class);
    System.out.println(netModel.getName());
  }

  @Test
  public void testLoadingExistingNets() throws IOException {
    XmlMapper mapper = new XmlMapper();
    try {
      NetModel netModel = mapper.readValue(getClass().getResourceAsStream("/old_format.xml"), NetModel.class);
      Assert.assertEquals(1, netModel.getNets().size());
      Assert.fail();
    }
    catch (JsonParseException | JsonMappingException ex) {
      System.out.println("ERROR:: " + ex.getCause());
    }


  }
}
