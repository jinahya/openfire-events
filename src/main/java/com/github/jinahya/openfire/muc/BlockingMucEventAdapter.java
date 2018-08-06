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

import com.github.jinahya.openfire.BlockingEventAdapter;
import org.jivesoftware.openfire.muc.MUCEventListener;
import org.xmpp.packet.JID;
import org.xmpp.packet.Message;

import java.util.concurrent.BlockingQueue;

public class BlockingMucEventAdapter extends BlockingEventAdapter<MucEvent> implements MUCEventListener {

    // -----------------------------------------------------------------------------------------------------------------
    public BlockingMucEventAdapter(final BlockingQueue<? super MucEvent> queue) {
        super(queue);
    }

    // --------------------------------------------------------------------------------------------------------- message
    @Override
    public void messageReceived(final JID room, final JID user, final String nickname, final Message message) {
        final boolean offered
                = offer(MucMessageReceived.of(room, user, nickname, message));
    }

    @Override
    public void privateMessageRecieved(final JID to, final JID from, final Message message) {
        final boolean offered = offer(MucPrivateMessageReceived.of(to, from, message));
    }

    // -------------------------------------------------------------------------------------------------------- occupant
    @Override
    public void occupantJoined(final JID room, final JID user, final String nickname) {
        final boolean offered = offer(MucOccupantJoined.of(room, user, nickname));
    }

    @Override
    public void occupantLeft(final JID room, final JID user) {
        final boolean offered = offer(MucOccupantLeft.of(room, user));
    }

    @Override
    public void nicknameChanged(final JID room, final JID user, final String oldNickname, final String newNickname) {
        final boolean offered = offer(MucNicknameChanged.of(room, user, oldNickname, newNickname));
    }

    // ------------------------------------------------------------------------------------------------------------ room
    @Override
    public void roomCreated(final JID room) {
        final boolean offered = offer(MucRoomCreated.of(room));
    }

    @Override
    public void roomDestroyed(final JID room) {
        final boolean offered = offer(MucRoomDestroyed.of(room));
    }

    @Override
    public void roomSubjectChanged(final JID room, final JID user, final String subject) {
        final boolean offered = offer(MucRoomSubjectChanged.of(room, user, subject));
    }
}
