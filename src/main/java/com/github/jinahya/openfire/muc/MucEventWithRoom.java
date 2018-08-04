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

abstract class MucEventWithRoom extends MucEvent {

    // -----------------------------------------------------------------------------------------------------------------
    static <T extends MucEventWithRoom> T of(final Supplier<T> supplier, final JID room) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = supplier.get();
        instance.setRoom(ofNullable(room).map(JidValue::of).orElse(null));
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public MucEventWithRoom(final String identifier) {
        super(identifier);
    }

    // -------------------------------------------------------------------------
    public JidValue getRoom() {
        return room;
    }

    public void setRoom(final JidValue room) {
        this.room = room;
    }

    // -------------------------------------------------------------------------
    private JidValue room;
}
