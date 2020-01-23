package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pipeplus.domain.net.type.DataType;

import java.util.*;

@JacksonXmlRootElement(localName = "net")
public class Net {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private String mId;

    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String mNetType;

    private Map<String, DataType> mDataTypesMap = new HashMap<>();
    private Map<String, Place> mPlacesMap = new HashMap<>();

    public void addDataType(final DataType pDataType) {
        Objects.requireNonNull(pDataType, "The datatype object should not be null");
        String name = pDataType.getName();
        if (mDataTypesMap.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Datatype with name '%s' already exists. Please choose a different name"));
        }
        mDataTypesMap.put(pDataType.getName(), pDataType);
    }

    public DataType replaceDataType(final DataType pDataType) {
        return mDataTypesMap.put(pDataType.getName(), pDataType);
    }

    public DataType dataTypeByName(final String pName) {
        return mDataTypesMap.get(pName);
    }

    @JacksonXmlElementWrapper(localName = "datatypes")
    @JacksonXmlProperty(localName = "datatype")
    public Collection<DataType> getDataTypes() {
        return mDataTypesMap.values();
    }

    public void setDataTypes(final List<DataType> pDataTypes) {
        for (DataType dataType : pDataTypes) {
            addDataType(dataType);
        }
    }

    public Place addPlace(final Place pPlace) {
        return mPlacesMap.put(pPlace.getId(), pPlace);
    }




}
