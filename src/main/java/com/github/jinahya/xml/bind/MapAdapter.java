package com.github.jinahya.xml.bind;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public class MapAdapter extends XmlAdapter<MapEntry[], Map<String, String>> {

    @Override
    public MapEntry[] marshal(final Map<String, String> bound) throws Exception {
        if (bound == null) {
            return null;
        }
        return bound.entrySet().stream().map(MapEntry::of).toArray(MapEntry[]::new);
    }

    @Override
    public Map<String, String> unmarshal(final MapEntry[] value) throws Exception {
        if (value == null) {
            return null;
        }
        return stream(value).collect(toMap(MapEntry::getKey, MapEntry::getValue));
    }
}
