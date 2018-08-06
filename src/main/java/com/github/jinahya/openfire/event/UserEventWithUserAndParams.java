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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

@XmlTransient
abstract class UserEventWithUserAndParams extends UserEvent {

    // -----------------------------------------------------------------------------------------------------------------
    static <T extends UserEventWithUserAndParams> T of(final Supplier<T> supplier, final User user,
                                                       final Map<String, Object> params) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = supplier.get();
        instance.setUser(ofNullable(user).map(UserValue::of).orElse(null));
        ofNullable(params).ifPresent(
                v -> params.entrySet().stream().map(UserEventParameter::of).forEach(instance.getParameters()::add));
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public UserEventWithUserAndParams(final UserEventIdentifier identifier) {
        super(identifier);
    }

    // ------------------------------------------------------------------------------------------------------------ user
    public UserValue getUser() {
        return user;
    }

    void setUser(final UserValue user) {
        this.user = user;
    }

    // ------------------------------------------------------------------------------------------------------ parameters
    public List<UserEventParameter> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<>();
        }
        return parameters;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private UserValue user;

    @XmlElement(name = "parameter")
    private List<UserEventParameter> parameters;
}
