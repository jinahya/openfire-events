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
package com.github.jinahya.openfire.component;

import com.github.jinahya.openfire.BlockingEventAdapter;
import com.github.jinahya.openfire.Event;
import org.jivesoftware.openfire.component.ComponentEventListener;
import org.xmpp.packet.IQ;
import org.xmpp.packet.JID;

import java.util.concurrent.BlockingQueue;

/**
 * A blocking event adapter implements {@link ComponentEventListener}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class BlockingComponentEventAdapter extends BlockingEventAdapter<ComponentEventPayload>
        implements ComponentEventListener {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String NAMESPACE = "OPENFIRE_COMPONENT_COMPONENT";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param queue a queue to which event are offered.
     */
    public BlockingComponentEventAdapter(final BlockingQueue<Event<? super ComponentEventPayload>> queue) {
        super(NAMESPACE, queue);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void componentInfoReceived(final IQ iq) {
        final boolean offered = offer(ComponentEventIdentifier.COMPONENT_INFO_RECEIVED,
                                      ComponentEventComponentInfoReceived.of(iq));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void componentRegistered(final JID componentJid) {
        final boolean offered = offer(ComponentEventIdentifier.COMPONENT_REGISTERED,
                                      ComponentEventPayloadComponentRegistered.of(componentJid));
    }

    @Override
    public void componentUnregistered(final JID componentJid) {
        final boolean offered = offer(ComponentEventIdentifier.COMPONENT_UNREGISTERED,
                                      ComponentEventComponentUnregistered.of(componentJid));
    }
}
