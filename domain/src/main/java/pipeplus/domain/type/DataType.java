package pipeplus.domain.type;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;
import java.util.List;

@JacksonXmlRootElement(localName = "datatype")
@JsonPropertyOrder({"name", "fields", "pow", "def", "continuous"})
public class DataType {

    @JacksonXmlProperty(localName = "name")
    private String mName;

    @JsonIgnore
    private Field[] mFields;

    @JacksonXmlProperty(localName = "pow")
    private boolean mPowerSet;

    @JacksonXmlProperty(localName = "def")
    private boolean mDefined;

    @JacksonXmlProperty(localName = "continuous")
    private boolean mContinuous;


    public DataType()
    {
//NOTE:: Empty by design
    }

    public DataType(final String pName) {
        mName = pName;
    }

    public DataType(final String pName, final String[] pTypes, final boolean pIsPow)
    {
        mName = pName;
        mPowerSet = pIsPow;
        defineType(pTypes);
    }

    public DataType(final String pName, final String[][] pFields) {
        this(pName, createFields(pFields));
    }

    public DataType(final String pName, final Field[] pFields) {
        this(pName);
        defineFields(pFields);
    }


    private static Field[] createFields(String[][] pFields) {
        Field[] fields = new Field[pFields.length];

        for (int i = 0; i<pFields.length; i++) {
            String[] descriptor = pFields[i];
            Field field = new Field(descriptor[0], descriptor[1]);
            if (!descriptor[2].isEmpty() && !descriptor[3].isEmpty()) {
                field.setRange(Double.parseDouble(descriptor[2]), Double.parseDouble(descriptor[3]));
            }

            fields[i] = field;
        }

        return fields;
    }

    private void defineFields(final Field[] pFields) {
        mFields = pFields;
        mDefined = true;
    }

    private void defineType(String[] t)
    {
        Field[] fields = new Field[t.length];
        for (int i = 0; i<t.length; i++) {
            fields[i] = new Field("Field"+i, t[i], 0.0, 0.0);
        }
        defineFields(fields);
    }

    public String getName() {
        return mName;
    }

    public void setName(String pName) {
        mName = pName;
    }

    @JsonGetter(value = "fields")
    public FieldsWrapper getField() {
//        FIX-ME: This trick is applied to
        return new FieldsWrapper(getFields());
    }

    @JsonIgnore
    public List<Field> getFields() {
        return Arrays.asList(mFields);
    }

    @JsonIgnore
    public Field[] getFieldsAsArray() {
        return mFields;
    }

    /**
     * This method sets the list of fields that defines the structure of the data. It does so, only if it is marked as
     * not defined. If it is defined, then an runtime exception will be thrown. Once the fields for the datatype is set,
     * it might be too risky to modify it because it may be used by places and arcs. Changing the fields may mean to
     * change the data held by those places.
     * @param pFields
     */
    @JsonSetter(value = "fields")
    public void setFields(List<Field> pFields) {
        if (isDefined()) {
            throw new IllegalStateException("The datatype named \""+mName+"\" is already defined. It accepts no more modification.");
        }
        mFields = pFields.toArray(new Field[pFields.size()]);
        mDefined = true;
    }

    @JsonIgnore
    public boolean isPowerSet() {
        return mPowerSet;
    }

    public void setPowerSet(boolean pPowerSet) {
        mPowerSet = pPowerSet;
    }

    @JsonIgnore
    public boolean isDefined() {
        return mDefined;
    }

    public void setDefined(boolean pDefined) {
        mDefined = pDefined;
    }

    public boolean isContinuous() {
        return mContinuous;
    }

    public void setContinuous(boolean pContinuous) {
        mContinuous = pContinuous;
    }
}
