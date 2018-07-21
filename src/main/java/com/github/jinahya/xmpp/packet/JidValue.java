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

import java.util.function.Supplier;
import org.xmpp.packet.JID;

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
