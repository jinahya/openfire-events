package com.github.jinahya.openfire.user;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import java.util.Map;

public class UserValueProperty {

    static UserValueProperty of(final String key, final String value) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        final UserValueProperty instance = new UserValueProperty();
        instance.setKey(key);
        instance.setValue(value);
        return instance;
    }

    static UserValueProperty of(Map.Entry<String, String> entry) {
        if (entry == null) {
            throw new NullPointerException("entry is null");
        }
        return of(entry.getKey(), entry.getValue());
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
    @XmlAttribute
    //@XmlElement
    private String key;

    //@XmlElement
    //@XmlMixed
    @XmlValue
    private String value;
}
