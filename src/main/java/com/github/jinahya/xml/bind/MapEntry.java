package com.github.jinahya.xml.bind;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.Map;

public class MapEntry {

    static MapEntry of(Map.Entry<String, String> entry) {
        final MapEntry instance = new MapEntry();
        instance.setKey(entry.getKey());
        instance.setValue(entry.getValue());
        return instance;
    }

    // ------------------------------------------------------------------------------------------------------------- key
    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    // ----------------------------------------------------------------------------------------------------------- value
    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private String key;

    @XmlElement
    private String value;
}
