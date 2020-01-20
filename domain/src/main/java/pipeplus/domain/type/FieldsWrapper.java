package pipeplus.domain.type;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class FieldsWrapper {
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<Field> field;

  public FieldsWrapper(List<Field> pFields) {
    field = pFields;
  }
}
