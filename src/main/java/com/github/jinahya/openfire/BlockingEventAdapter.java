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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static java.lang.String.format;
import static java.lang.invoke.MethodHandles.lookup;
import static java.util.Objects.requireNonNull;
import static java.util.logging.Logger.getLogger;

public abstract class BlockingEventAdapter<T extends OpenfireEvent> {

    private static final Logger logger
            = getLogger(lookup().lookupClass().getName());

    // -------------------------------------------------------------------------
    public BlockingEventAdapter(final BlockingQueue<? super T> queue) {
        super();
        this.queue = requireNonNull(queue, "queue is null");
    }

    // -------------------------------------------------------------------------
    protected boolean offer(final T e) {
        if (e == null) {
            throw new NullPointerException("e is null");
        }
        final boolean offered = queue.offer(e);
        if (!offered) {
            logger.severe(() -> format("failed to offer %1$s", e));
        }
        return offered;
    }

    protected boolean offer(final T e, final long timeout, final TimeUnit unit)
            throws InterruptedException {
        if (e == null) {
            throw new NullPointerException("e is null");
        }
        final boolean offered = queue.offer(e, timeout, unit);
        if (!offered) {
            logger.severe(() -> format(
                    "failed to offer %1$s in %2$d(%3$s)", e, timeout, unit));
        }
        return offered;
    }

    // -------------------------------------------------------------------------
    private final BlockingQueue<? super T> queue;
}
