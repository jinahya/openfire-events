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
import org.xmpp.packet.JID;

import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
abstract class MucEventWithRoomAndUser extends MucEventWithRoom {

    // -----------------------------------------------------------------------------------------------------------------
    static <T extends MucEventWithRoomAndUser> T of(final Supplier<T> supplier, final JID room, final JID user) {
        final T instance = of(supplier, room);
        instance.setUser(ofNullable(user).map(JidValue::of).orElse(null));
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    MucEventWithRoomAndUser(final String identifier) {
        super(identifier);
    }

    // ------------------------------------------------------------------------------------------------------------ user
    public JidValue getUser() {
        return user;
    }

    void setUser(final JidValue user) {
        this.user = user;
    }

    // -------------------------------------------------------------------------
    private JidValue user;
}
