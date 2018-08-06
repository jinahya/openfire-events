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
package com.github.jinahya.openfire.user;

import org.jivesoftware.openfire.session.ClientSession;
import org.jivesoftware.openfire.user.PresenceEventListener;
import org.xmpp.packet.Presence;

/**
 * An event for {@link PresenceEventListener#presenceChanged(ClientSession, Presence)}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class PresenceEventPresenceChanged extends PresenceEventWithSessionAndPresence {

    // -----------------------------------------------------------------------------------------------------------------
    public static PresenceEventPresenceChanged of(final ClientSession session, final Presence presence) {
        final PresenceEventPresenceChanged instance = of(PresenceEventPresenceChanged::new, session, presence);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public PresenceEventPresenceChanged() {
        super(PresenceEventIdentifier.PRESENCE_CHANGED);
    }
}
