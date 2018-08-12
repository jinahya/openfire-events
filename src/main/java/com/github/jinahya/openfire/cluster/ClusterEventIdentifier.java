package com.github.jinahya.openfire.cluster;

import com.github.jinahya.openfire.EventIdentifier;

public enum ClusterEventIdentifier implements EventIdentifier {

    // -----------------------------------------------------------------------------------------------------------------
    JOINED_CLUSTER,

    JOINED_CLUSTER_WITH_NODE_ID,

    // -----------------------------------------------------------------------------------------------------------------
    LEFT_CLUSTER,

    LEFT_CLUSTER_WITH_NODE_ID,

    // -----------------------------------------------------------------------------------------------------------------
    MARKED_AS_SENIOR_CLUSTER_MEMBER
}
