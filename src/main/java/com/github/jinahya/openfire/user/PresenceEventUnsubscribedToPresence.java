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

import com.github.jinahya.xmpp.packet.JidValue;
import org.xmpp.packet.JID;

import javax.xml.bind.annotation.XmlElement;

public class PresenceEventUnsubscribedToPresence extends PresenceEventWithTwoJids {

    public static PresenceEventUnsubscribedToPresence of(final JID unsubscriberJid, final JID recipientJid) {
        final PresenceEventUnsubscribedToPresence instance
                = of(PresenceEventUnsubscribedToPresence::new, unsubscriberJid, recipientJid);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public PresenceEventUnsubscribedToPresence() {
        super(PresenceEventIdentifier.UNSUBSCRIBED_TO_PRESENCE);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    public JidValue getUnsubscriberJid() {
        return super.getJid1();
    }

    public void setUnsubscriberJid(final JidValue unsubscriberJid) {
        super.setJid1(unsubscriberJid);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    public JidValue getRecipientJid() {
        return super.getJid2();
    }

    public void setRecipientJid(final JidValue recipientJid) {
        super.setJid2(recipientJid);
    }
}
