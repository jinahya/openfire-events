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
package com.github.jinahya.xmpp.packet;

import org.xmpp.packet.JID;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * A value type for {@link JID}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class JidValue {

    protected static <T extends JidValue> T of(final Supplier<T> supplier,
                                               final JID object) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final T value = supplier.get();
        value.setDomain(object.getDomain());
        value.setNode(object.getNode());
        value.setResource(object.getResource());
        return value;
    }

    public static JidValue of(final JID object) {
        return of(JidValue::new, object);
    }

    // -------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "{"
               + "domain=" + domain
               + ",node=" + node
               + ",resource=" + resource
               + "}";
    }

    // -------------------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(domain);
        hash = 59 * hash + Objects.hashCode(node);
        hash = 59 * hash + Objects.hashCode(resource);
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
        final JidValue other = (JidValue) obj;
        if (!Objects.equals(domain, other.domain)) {
            return false;
        }
        if (!Objects.equals(node, other.node)) {
            return false;
        }
        if (!Objects.equals(resource, other.resource)) {
            return false;
        }
        return true;
    }

    // -------------------------------------------------------------------------
    public String getDomain() {
        return domain;
    }

    public void setDomain(final String domain) {
        this.domain = domain;
    }

    // -------------------------------------------------------------------------
    public String getNode() {
        return node;
    }

    public void setNode(final String node) {
        this.node = node;
    }

    // -------------------------------------------------------------------------
    public String getResource() {
        return resource;
    }

    public void setResource(final String resource) {
        this.resource = resource;
    }

    // -------------------------------------------------------------------------
    private String domain;

    private String node;

    private String resource;
}
