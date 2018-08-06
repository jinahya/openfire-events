package com.github.jinahya.openfire.cluster;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ClusterEventIdentifier implements OpenfireEventIdentifier<ClusterEventIdentifier> {

    JOINED_CLUSTER,

    JOINED_CLUSTER_NODE,

    LEFT_CLUSTER,

    LEFT_CLUSTER_NODE,

    MARKED_AS_SENIOR_CLUSTER_MEMBER;
}
