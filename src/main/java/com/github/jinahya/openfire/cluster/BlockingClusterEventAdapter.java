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

import com.github.jinahya.openfire.BlockingEventAdapter;
import com.github.jinahya.openfire.Event;
import org.jivesoftware.openfire.cluster.ClusterEventListener;

import java.util.concurrent.BlockingQueue;

public class BlockingClusterEventAdapter extends BlockingEventAdapter<ClusterEventPayload>
        implements ClusterEventListener {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String NAMESPACE = "OPENFIRE_CLUSTER_CLUSTER";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param queue a queue to which events are offered.
     */
    public BlockingClusterEventAdapter(final BlockingQueue<Event<? super ClusterEventPayload>> queue) {
        super(NAMESPACE, queue);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void joinedCluster() {
        final boolean offered = offer(ClusterEventIdentifier.JOINED_CLUSTER, new ClusterEventPayloadJoinedCluster());
    }

    @Override
    public void joinedCluster(final byte[] nodeId) {
        final boolean offered = offer(ClusterEventIdentifier.JOINED_CLUSTER_WITH_NODE_ID,
                                      ClusterEventPayloadJoinedClusterWithNodeId.of(nodeId));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void leftCluster() {
        final boolean offered = offer(ClusterEventIdentifier.LEFT_CLUSTER, new ClusterEventPayloadLeftCluster());
    }

    @Override
    public void leftCluster(final byte[] nodeId) {
        final boolean offered = offer(ClusterEventIdentifier.LEFT_CLUSTER_WITH_NODE_ID,
                                      ClusterEventPayloadLeftClusterNode.of(nodeId));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void markedAsSeniorClusterMember() {
        final boolean offered = offer(ClusterEventIdentifier.MARKED_AS_SENIOR_CLUSTER_MEMBER,
                                      new ClusterEventPayloadMarkedAsSeniorClusterMember());
    }
}
