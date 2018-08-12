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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.function.Supplier;

@XmlTransient
abstract class MucEventPayloadWithRoomUserAndNickname extends MucEventPayloadWithRoomAndUser {

    // -----------------------------------------------------------------------------------------------------------------
    static <T extends MucEventPayloadWithRoomUserAndNickname> T of(final Supplier<T> supplier,
                                                                   final JID room, final JID user,
                                                                   final String nickname) {
        final T instance = of(supplier, room, user);
        instance.setNickname(nickname);
        return instance;
    }

    // -------------------------------------------------------------------------------------------------------- nickname
    public String getNickname() {
        return nickname;
    }

    void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private String nickname;
}
