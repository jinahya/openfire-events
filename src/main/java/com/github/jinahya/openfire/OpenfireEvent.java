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

/**
 * An abstract class for openfire event.
 *
 * @param <E> identifier type parameter
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public abstract class OpenfireEvent<E extends Enum<E> & OpenfireEventIdentifier<E>> {

    // -----------------------------------------------------------------------------------------------------------------
    @Deprecated
    public OpenfireEvent() {
        this(OpenfireEventNamespace.UNUSED, "illegal");
    }

    public OpenfireEvent(final OpenfireEventNamespace namespace, final String identifier) {
        super();
        this.namespace = requireNonNull(namespace, "namespace is null");
        this.identifier = requireNonNull(identifier, "identifier is null");
        this.timestamp = System.nanoTime();
    }

    public <E extends Enum<E> & OpenfireEventIdentifier<E>> OpenfireEvent(final OpenfireEventNamespace namespace, final E identifier) {
        super();
        this.namespace = requireNonNull(namespace, "namespace is null");
        //this.identifier = requireNonNull(identifier, "identifier is null");
        this.identifier = null;
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
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(namespace);
        hash = 17 * hash + Objects.hashCode(identifier);
        hash = 17 * hash + (int) (timestamp ^ (timestamp >>> 32));
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OpenfireEvent other = (OpenfireEvent) obj;
        if (timestamp != other.timestamp) {
            return false;
        }
        if (!Objects.equals(identifier, other.identifier)) {
            return false;
        }
        if (namespace != other.namespace) {
            return false;
        }
        return true;
    }

    // ------------------------------------------------------------------------------------------------------- namespace
    public OpenfireEventNamespace getNamespace() {
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
    private final OpenfireEventNamespace namespace;

    @XmlElement(required = true)
    private final String identifier;

    @XmlElement(required = true)
    private final long timestamp;
}
