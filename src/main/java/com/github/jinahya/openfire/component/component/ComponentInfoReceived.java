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
package com.github.jinahya.openfire.component.component;

import com.github.jinahya.xmpp.packet.IqValue;
import static java.util.Optional.ofNullable;
import org.xmpp.packet.IQ;

public class ComponentInfoReceived extends ComponentEvent {

    // -------------------------------------------------------------------------
    public static ComponentInfoReceived of(final IQ iq) {
        final ComponentInfoReceived instance = new ComponentInfoReceived();
        instance.setIq(ofNullable(iq).map(IqValue::of).orElse(null));
        return instance;
    }

    // ---------------------------------------------------------------------- iq
    public IqValue getIq() {
        return iq;
    }

    public void setIq(final IqValue iq) {
        this.iq = iq;
    }

    // -------------------------------------------------------------------------
    private IqValue iq;
}
