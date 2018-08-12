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

import org.jivesoftware.openfire.event.UserEventListener;
import org.jivesoftware.openfire.user.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

/**
 * An event for {@link UserEventListener#userCreated(org.jivesoftware.openfire.user.User, java.util.Map)}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@XmlRootElement
public class UserEventPayloadUserCreated extends UserEventPayloadWithUserAndParams {

    // -------------------------------------------------------------------------
    public static UserEventPayloadUserCreated of(final User user, final Map<String, Object> params) {
        final UserEventPayloadUserCreated instance = of(UserEventPayloadUserCreated::new, user, params);
        return instance;
    }
}
