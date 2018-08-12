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

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event<T extends EventPayload> {

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "{"
               + "namespace=" + namespace
               + ",identifier=" + identifier
               + ",timestamp=" + timestamp
               + "}";
    }

    // ------------------------------------------------------------------------------------------------------- namespace
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(final String namespace) {
        this.namespace = namespace;
    }

    public Event<T> namespace(final String namespace) {
        setNamespace(namespace);
        return this;
    }

    // ------------------------------------------------------------------------------------------------------ identifier
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    public Event<T> identifier(final String identifier) {
        setIdentifier(identifier);
        return this;
    }

    // ------------------------------------------------------------------------------------------------------- timestamp
    public long getTimestamp() {
        return timestamp;
    }

    void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public T getPayload() {
        return payload;
    }

    public void setPayload(final T payload) {
        this.payload = payload;
    }

    public Event<T> payload(final T payload) {
        setPayload(payload);
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement(required = true)
    private String namespace;

    @XmlElement(required = true)
    private String identifier;

    @XmlElement(required = true)
    private long timestamp;

    @XmlAnyElement(lax = true)
    private T payload;
}
