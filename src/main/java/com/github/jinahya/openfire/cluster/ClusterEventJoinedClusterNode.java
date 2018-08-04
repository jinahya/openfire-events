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

public class ClusterEventJoinedClusterNode extends ClusterEventWithNodeId {

    // -------------------------------------------------------------------------
    public static final String IDENTIFIER = "JOINED_CLUSTER_NODE";

    // -------------------------------------------------------------------------
    public static ClusterEventJoinedClusterNode of(final byte[] nodeId) {
        return of(ClusterEventJoinedClusterNode::new, nodeId);
    }

    // -------------------------------------------------------------------------
    public ClusterEventJoinedClusterNode() {
        super(IDENTIFIER);
    }
}
