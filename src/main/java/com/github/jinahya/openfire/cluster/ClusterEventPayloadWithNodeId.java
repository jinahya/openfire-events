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
package com.github.jinahya.openfire.cluster;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.function.Supplier;

import static java.util.Arrays.copyOf;
import static java.util.Optional.ofNullable;

@XmlTransient
abstract class ClusterEventPayloadWithNodeId implements ClusterEventPayload {

    // -----------------------------------------------------------------------------------------------------------------
    static <T extends ClusterEventPayloadWithNodeId> T of(final Supplier<T> supplier, final byte[] nodeId) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = supplier.get();
        instance.setNodeId(ofNullable(nodeId).map(v -> copyOf(v, v.length)).orElse(null));
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------------- nodeId
    public byte[] getNodeId() {
        return ofNullable(nodeId).map(v -> copyOf(v, v.length)).orElse(null);
    }

    void setNodeId(final byte[] nodeId) {
        this.nodeId = ofNullable(nodeId).map(v -> copyOf(v, v.length)).orElse(null);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private byte[] nodeId;
}
