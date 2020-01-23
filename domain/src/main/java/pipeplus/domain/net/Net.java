package pipeplus.domain.net;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pipeplus.domain.net.arc.Arc;
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
    private Map<String, Transition> mTransitionsMap = new HashMap<>();
    private Map<String, Arc> mArcsMap = new HashMap<>();

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

    public Place removePlace(final Place pPlace) {
        return removePlace(pPlace.getId());
    }

    public Place removePlace(final String pPlaceId) {
        return mPlacesMap.remove(pPlaceId);
    }

    @JacksonXmlProperty(localName = "place")
    @JacksonXmlElementWrapper(useWrapping = false)
    public Collection<Place> getPlaces() {
        return mPlacesMap.values();
    }

    public void setPlaces(Collection<Place> pPlaces) {
        mPlacesMap.clear();
        for (Place place : pPlaces) {
            mPlacesMap.put(place.getId(), place);
        }
    }


    @JacksonXmlProperty(localName = "transition")
    @JacksonXmlElementWrapper(useWrapping = false)
    public Collection<Transition> getTransitions() {
        return mTransitionsMap.values();
    }

    public void setTransitions(Collection<Transition> pTransitions) {
        mTransitionsMap.clear();
        for (Transition transition : pTransitions) {
            mTransitionsMap.put(transition.getId(), transition);
        }
    }


    @JacksonXmlProperty(localName = "arc")
    @JacksonXmlElementWrapper(useWrapping = false)
    public Collection<Arc> getArcs() {
        return mArcsMap.values();
    }

    public void setArcs(final Collection<Arc> pArcs) {
        mArcsMap.clear();
        for (Arc arc : pArcs) {
            mArcsMap.put(arc.getId(), arc);
        }
    }
}
