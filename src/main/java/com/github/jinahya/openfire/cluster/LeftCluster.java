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

import static java.util.Arrays.copyOf;
import static java.util.Optional.ofNullable;

/**
 * An event represents
 * {@link org.jivesoftware.openfire.cluster.ClusterEventListener#leftCluster()}
 * or
 * {@link  org.jivesoftware.openfire.cluster.ClusterEventListener#leftCluster(byte[])}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class LeftCluster {

    /**
     * Returns the {@code nodeId} of this event.
     *
     * @return the {@code nodeId} of this event; {@code null} if this event
     * object represents
     * {@link org.jivesoftware.openfire.cluster.ClusterEventListener#leftCluster()}
     */
    public byte[] getNodeId() {
        return ofNullable(nodeId).map(v -> copyOf(v, v.length)).orElse(null);
    }

    // -------------------------------------------------------------------------
    private byte[] nodeId;
}
