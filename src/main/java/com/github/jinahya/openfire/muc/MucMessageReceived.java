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

import com.github.jinahya.xmpp.packet.MessageValue;
import org.xmpp.packet.JID;
import org.xmpp.packet.Message;

import static java.util.Optional.ofNullable;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class MucMessageReceived extends MucEventWithRoomUserAndNickname {

    public static final String IDENTIFIER = "MESSAGE_RECEIVED";

    // -------------------------------------------------------------------------
    public static MucMessageReceived of(final JID room, final JID user, final String nickname, final Message message) {
        final MucMessageReceived instance = of(MucMessageReceived::new, room, user, nickname);
        instance.setMessage(ofNullable(message).map(MessageValue::of).orElse(null));
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public MucMessageReceived() {
        super(IDENTIFIER);
    }

    // ----------------------------------------------------------------- message
    public MessageValue getMessage() {
        return message;
    }

    void setMessage(final MessageValue message) {
        this.message = message;
    }

    // -------------------------------------------------------------------------
    private MessageValue message;
}
