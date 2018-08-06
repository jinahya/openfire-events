/*
 * Copyright 2018 Jin Kwon &lt;onacit at gmail.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.openfire;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

import static java.util.Objects.requireNonNull;


public abstract class Event {

    // -----------------------------------------------------------------------------------------------------------------
    private Event() {
        this(null, null);
    }

    protected Event(final String namespace, final String identifier) {
        super();
        this.namespace = requireNonNull(namespace, "namespace is null");
        this.identifier = requireNonNull(identifier, "identifier is null");
        this.timestamp = System.nanoTime();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "{"
               + "namespace=" + namespace
               + ",identifier=" + identifier
               + ",timestamp=" + timestamp
               + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, identifier, timestamp);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return timestamp == event.timestamp &&
               Objects.equals(namespace, event.namespace) &&
               Objects.equals(identifier, event.identifier);
    }

    // ------------------------------------------------------------------------------------------------------- namespace
    public String getNamespace() {
        return namespace;
    }

    // ------------------------------------------------------------------------------------------------------ identifier
    public String getIdentifier() {
        return identifier;
    }

    // ------------------------------------------------------------------------------------------------------- timestamp
    public long getTimestamp() {
        return timestamp;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement(required = true)
    private final String namespace;

    @XmlElement(required = true)
    private final String identifier;

    @XmlElement(required = true)
    private final long timestamp;
}
