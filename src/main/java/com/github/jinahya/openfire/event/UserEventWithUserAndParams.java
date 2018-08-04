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
package com.github.jinahya.openfire.event;

import com.github.jinahya.openfire.user.UserValue;
import org.jivesoftware.openfire.user.User;

import java.util.Map;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

abstract class UserEventWithUserAndParams extends UserEvent {

    // -------------------------------------------------------------------------
    static <T extends UserEventWithUserAndParams> T of(final Supplier<T> supplier, final User user,
                                                       final Map<String, Object> params) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = supplier.get();
        instance.setUser(ofNullable(user).map(UserValue::of).orElse(null));
        instance.setParams(params);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public UserEventWithUserAndParams(final String identifier) {
        super(identifier);
    }

    // -------------------------------------------------------------------- user
    public UserValue getUser() {
        return user;
    }

    void setUser(final UserValue user) {
        this.user = user;
    }

    // ------------------------------------------------------------------ params
    public Map<String, Object> getParams() {
        return params;
    }

    void setParams(final Map<String, Object> params) {
        this.params = params;
    }

    // -------------------------------------------------------------------------
    private UserValue user;

    private Map<String, Object> params;
}
