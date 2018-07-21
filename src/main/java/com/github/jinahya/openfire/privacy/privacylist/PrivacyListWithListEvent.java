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
package com.github.jinahya.openfire.privacy.privacylist;

import com.github.jinahya.openfire.privacy.PrivacyListValue;
import java.util.function.Supplier;
import org.jivesoftware.openfire.privacy.PrivacyList;

public abstract class PrivacyListWithListEvent extends PrivacyListEvent {

    // -------------------------------------------------------------------------
    static <T extends PrivacyListWithListEvent> T of(final Supplier<T> supplier,
                                                     final PrivacyList list) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        if (list == null) {
            throw new NullPointerException("list is null");
        }
        final T instance = supplier.get();
        instance.setList(PrivacyListValue.of(list));
        return instance;
    }

    // -------------------------------------------------------------------- list
    public PrivacyListValue getList() {
        return list;
    }

    public void setList(final PrivacyListValue list) {
        this.list = list;
    }

    // -------------------------------------------------------------------------
    private PrivacyListValue list;
}
