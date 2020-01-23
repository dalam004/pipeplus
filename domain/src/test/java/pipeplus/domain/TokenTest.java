package pipeplus.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import pipeplus.domain.net.NumberValue;
import pipeplus.domain.net.StringValue;
import pipeplus.domain.net.Token;

import java.util.Arrays;

public class TokenTest {

  @Test
  public void testToken() throws JsonProcessingException {
    Token token = new Token();
    token.setValues(Arrays.asList(new StringValue("abc"), new NumberValue(10.0)));

    XmlMapper mapper = new XmlMapper();
    System.out.println(mapper.writeValueAsString(token));

    Token token1 = mapper.readValue(mapper.writeValueAsString(token), Token.class);
    token1.getValues().forEach(e -> System.out.println(String.format("%s, %s",e.getValue(), e.getType())));
  }
}
