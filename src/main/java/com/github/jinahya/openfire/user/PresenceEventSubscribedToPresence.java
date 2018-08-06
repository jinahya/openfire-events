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

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class PresenceEventSubscribedToPresence extends PresenceEventWithTwoJids {

    public static PresenceEventSubscribedToPresence of(final JID subscriberJid, final JID authorizerJid) {
        final PresenceEventSubscribedToPresence instance
                = of(PresenceEventSubscribedToPresence::new, subscriberJid, authorizerJid);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public PresenceEventSubscribedToPresence() {
        super(PresenceEventIdentifier.SUBSCRIBED_TO_PRESENCE);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    public JidValue getSubscriberJid() {
        return super.getJid1();
    }

    void setSubscriberJid(final JidValue subscriberJid) {
        super.setJid1(subscriberJid);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    public JidValue getAuthorizerJid() {
        return super.getJid2();
    }

    public void setAuthorizerJid(final JidValue authorizerJid) {
        super.setJid2(authorizerJid);
    }
}
