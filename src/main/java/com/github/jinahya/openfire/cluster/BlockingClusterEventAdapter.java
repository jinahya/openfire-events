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
import com.github.jinahya.openfire.cluster.cluster.ClusterEvent;
import com.github.jinahya.openfire.cluster.cluster.JoinedCluster;
import com.github.jinahya.openfire.cluster.cluster.JoinedClusterWithNode;
import com.github.jinahya.openfire.cluster.cluster.LeftCluster;
import com.github.jinahya.openfire.cluster.cluster.LeftClusterWithNode;
import com.github.jinahya.openfire.cluster.cluster.MarkedAsSeniorClusterMember;
import java.util.concurrent.BlockingQueue;
import org.jivesoftware.openfire.cluster.ClusterEventListener;

public class BlockingClusterEventAdapter
        extends BlockingEventAdapter<ClusterEvent>
        implements ClusterEventListener {

    // -------------------------------------------------------------------------
    public BlockingClusterEventAdapter(
            final BlockingQueue<? super ClusterEvent> queue) {
        super(queue);
    }

    // ----------------------------------------------------------- joinedCluster
    @Override
    public void joinedCluster() {
        final boolean offered = offer(new JoinedCluster());
    }

    @Override
    public void joinedCluster(final byte[] nodeId) {
        final boolean offered = offer(JoinedClusterWithNode.of(nodeId));
    }

    // ------------------------------------------------------------- leftCluster
    @Override
    public void leftCluster() {
        final boolean offered = offer(new LeftCluster());
    }

    @Override
    public void leftCluster(final byte[] nodeId) {
        final boolean offered = offer(LeftClusterWithNode.of(nodeId));
    }

    // --------------------------------------------- markedAsSeniorClusterMember
    @Override
    public void markedAsSeniorClusterMember() {
        final boolean offer = offer(new MarkedAsSeniorClusterMember());
    }
}
