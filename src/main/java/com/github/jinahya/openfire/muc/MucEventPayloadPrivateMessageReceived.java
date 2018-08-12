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
package com.github.jinahya.openfire.muc;

import com.github.jinahya.xmpp.packet.JidValue;
import com.github.jinahya.xmpp.packet.MessageValue;
import org.xmpp.packet.JID;
import org.xmpp.packet.Message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static java.util.Optional.ofNullable;

@XmlRootElement
public class MucEventPayloadPrivateMessageReceived implements MucEventPayload {

    // -----------------------------------------------------------------------------------------------------------------
    public static MucEventPayloadPrivateMessageReceived of(final JID to, final JID from, final Message message) {
        final MucEventPayloadPrivateMessageReceived instance = new MucEventPayloadPrivateMessageReceived();
        instance.setTo(ofNullable(to).map(JidValue::of).orElse(null));
        instance.setFrom(ofNullable(from).map(JidValue::of).orElse(null));
        instance.setMessage(ofNullable(message).map(MessageValue::of).orElse(null));
        return instance;
    }

    // -------------------------------------------------------------------------------------------------------------- to
    public JidValue getTo() {
        return to;
    }

    void setTo(final JidValue to) {
        this.to = to;
    }

    // ------------------------------------------------------------------------------------------------------------ from
    public JidValue getFrom() {
        return from;
    }

    void setFrom(final JidValue from) {
        this.from = from;
    }

    // --------------------------------------------------------------------------------------------------------- message
    public MessageValue getMessage() {
        return message;
    }

    void setMessage(final MessageValue message) {
        this.message = message;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private JidValue to;

    @XmlElement
    private JidValue from;

    @XmlElement
    private MessageValue message;
}
