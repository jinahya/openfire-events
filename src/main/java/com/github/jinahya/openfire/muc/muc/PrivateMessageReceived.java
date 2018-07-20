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
package com.github.jinahya.openfire.muc.muc;

import com.github.jinahya.xmpp.packet.JidValue;
import com.github.jinahya.xmpp.packet.MessageValue;
import org.xmpp.packet.JID;
import org.xmpp.packet.Message;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class PrivateMessageReceived extends MUCEvent {

    // -------------------------------------------------------------------------
    public static PrivateMessageReceived of(final JID toJID, final JID fromJID,
                                            final Message message) {
        final PrivateMessageReceived instance = new PrivateMessageReceived();
        instance.setToJID(JidValue.of(toJID));
        instance.setFromJID(JidValue.of(fromJID));
        instance.setMessage(MessageValue.of(message));
        return instance;
    }

    // ------------------------------------------------------------------- toJID
    public JidValue getToJID() {
        return toJID;
    }

    public void setToJID(final JidValue toJID) {
        this.toJID = toJID;
    }

    // ----------------------------------------------------------------- fromJID
    public JidValue getFromJID() {
        return fromJID;
    }

    public void setFromJID(final JidValue fromJID) {
        this.fromJID = fromJID;
    }

    // ----------------------------------------------------------------- message
    public MessageValue getMessage() {
        return message;
    }

    public void setMessage(final MessageValue message) {
        this.message = message;
    }

    // -------------------------------------------------------------------------
    private JidValue toJID;

    private JidValue fromJID;

    private MessageValue message;
}
