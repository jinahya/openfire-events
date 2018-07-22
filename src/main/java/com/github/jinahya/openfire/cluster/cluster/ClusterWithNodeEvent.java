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
package com.github.jinahya.openfire.cluster.cluster;

import static java.util.Arrays.copyOf;
import static java.util.Optional.ofNullable;
import java.util.function.Supplier;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
abstract class ClusterWithNodeEvent extends ClusterEvent {

    // -------------------------------------------------------------------------
    static <T extends ClusterWithNodeEvent> T of(final Supplier<T> supplier,
                                                 final byte[] node) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = supplier.get();
        instance.setNode(
                ofNullable(node).map(v -> copyOf(v, v.length)).orElse(null));
        return instance;
    }

    // -------------------------------------------------------------------------
    public byte[] getNode() {
        return node;
    }

    public void setNode(final byte[] node) {
        this.node = node;
    }

    // -------------------------------------------------------------------------
    private byte[] node;
}
