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
import static java.util.Optional.ofNullable;
import org.xmpp.packet.JID;
import org.xmpp.packet.Message;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class MessageReceived {

    // -------------------------------------------------------------------------
    public static MessageReceived of(final JID roomJID, final JID user,
                                     final String nickname,
                                     final Message message) {
        final MessageReceived instance = new MessageReceived();
        instance.setRoomJID(ofNullable(roomJID).map(JidValue::of).orElse(null));
        instance.setUser(ofNullable(user).map(JidValue::of).orElse(null));
        instance.setNickname(nickname);
        instance.setMessage(
                ofNullable(message).map(MessageValue::of).orElse(null));
        return instance;
    }

    // ----------------------------------------------------------------- roomJID
    public JidValue getRoomJID() {
        return roomJID;
    }

    public void setRoomJID(final JidValue roomJID) {
        this.roomJID = roomJID;
    }

    // -------------------------------------------------------------------- user
    public JidValue getUser() {
        return user;
    }

    public void setUser(final JidValue user) {
        this.user = user;
    }

    // ---------------------------------------------------------------- nickname
    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    // ----------------------------------------------------------------- message
    public MessageValue getMessage() {
        return message;
    }

    public void setMessage(final MessageValue message) {
        this.message = message;
    }

    // -------------------------------------------------------------------------
    private JidValue roomJID;

    private JidValue user;

    private String nickname;

    private MessageValue message;
}
