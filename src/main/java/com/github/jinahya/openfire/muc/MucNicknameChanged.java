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

import org.xmpp.packet.JID;

public class MucNicknameChanged extends MucEventWithRoomAndUser {

    // -----------------------------------------------------------------------------------------------------------------
    public static MucNicknameChanged of(final JID room, final JID user, final String oldNickname,
                                        final String newNickname) {
        final MucNicknameChanged instance = of(MucNicknameChanged::new, room, user);
        instance.setOldNickname(oldNickname);
        instance.setNewNickname(newNickname);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public MucNicknameChanged() {
        super(MucEventIdentifier.NICKNAME_CHANGED.name());
    }

    // ----------------------------------------------------------------------------------------------------- oldNickname
    public String getOldNickname() {
        return oldNickname;
    }

    void setOldNickname(final String oldNickname) {
        this.oldNickname = oldNickname;
    }

    // ----------------------------------------------------------------------------------------------------- newNickname
    public String getNewNickname() {
        return newNickname;
    }

    void setNewNickname(final String newNickname) {
        this.newNickname = newNickname;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String oldNickname;

    private String newNickname;
}
