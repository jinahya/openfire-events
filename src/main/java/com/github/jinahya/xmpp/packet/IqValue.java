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

import org.xmpp.packet.IQ;

import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class IqValue {

    // -------------------------------------------------------------------------
    public static IqValue of(final IQ object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final IqValue value = new IqValue();
        value.setType(
                ofNullable(object.getType()).map(IQ.Type::name).orElse(null));
        value.setRequest(object.isRequest());
        value.setResponse(object.isResponse());
        return value;
    }

    // -------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "{"
               + "type=" + type
               + ",request=" + request
               + ",response=" + response
               + "}";
    }

    // -------------------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(type);
        hash = 47 * hash + (request ? 1 : 0);
        hash = 47 * hash + (response ? 1 : 0);
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
        final IqValue other = (IqValue) obj;
        if (request != other.request) {
            return false;
        }
        if (response != other.response) {
            return false;
        }
        if (!Objects.equals(type, other.type)) {
            return false;
        }
        return true;
    }

    // -------------------------------------------------------------------- type
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    // ----------------------------------------------------------------- request
    public boolean isRequest() {
        return request;
    }

    public void setRequest(final boolean request) {
        this.request = request;
    }

    // ---------------------------------------------------------------- response
    public boolean isResponse() {
        return response;
    }

    public void setResponse(final boolean response) {
        this.response = response;
    }

    // -------------------------------------------------------------------------
    private String type;

    private boolean request;

    private boolean response;
}
