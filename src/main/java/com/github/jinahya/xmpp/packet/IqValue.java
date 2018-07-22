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

import static java.util.Optional.ofNullable;
import org.xmpp.packet.IQ;

/**
 *
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
