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
package com.github.jinahya.openfire;

import org.jivesoftware.openfire.cluster.ClusterEventListener;

import static java.util.Objects.requireNonNull;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public enum OpenfireEventNamespace {

    @Deprecated
    UNUSED("unused"),
    /**
     * The namespace for events listenable via {@link ClusterEventListener}.
     */
    CLUSTER_CLUSTER("cluster.cluster"),
    COMPONENT_COMPONENT("component.component"),
    CONTAINER_PLUGIN("container.plugin"),
    EVENT_GROUP("event.group"),
    EVENT_USER("event.user"),
    FILETRANSFER_FILETRANSFER("filetransfer.filetransfer"),
    MUC_MUC("muc.muc");

    // -------------------------------------------------------------------------
    OpenfireEventNamespace(final String namespace) {
        this.namespace = requireNonNull(namespace, "namespace is null");
    }

    // -------------------------------------------------------------------------
    public String getNamespace() {
        return namespace;
    }

    // -------------------------------------------------------------------------
    private final String namespace;
}
