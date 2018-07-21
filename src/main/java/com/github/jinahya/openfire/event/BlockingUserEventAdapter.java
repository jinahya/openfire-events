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

import com.github.jinahya.openfire.BlockingEventAdapter;
import com.github.jinahya.openfire.event.user.UserCreated;
import com.github.jinahya.openfire.event.user.UserDeleting;
import com.github.jinahya.openfire.event.user.UserEvent;
import com.github.jinahya.openfire.event.user.UserModified;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import org.jivesoftware.openfire.event.UserEventListener;
import org.jivesoftware.openfire.user.User;

public class BlockingUserEventAdapter extends BlockingEventAdapter<UserEvent>
        implements UserEventListener {

    private static final Logger logger
            = getLogger(lookup().lookupClass().getName());

    // -------------------------------------------------------------------------
    public BlockingUserEventAdapter(
            final BlockingQueue<? super UserEvent> queue) {
        super(queue);
    }

    @Override
    public void userCreated(final User user, final Map<String, Object> map) {
        final UserEvent event = UserCreated.of(user, map);
        final boolean offered = offer(event);
    }

    @Override
    public void userDeleting(final User user, final Map<String, Object> map) {
        final UserEvent event = UserDeleting.of(user, map);
        final boolean offered = offer(event);
    }

    @Override
    public void userModified(final User user, final Map<String, Object> map) {
        final UserEvent event = UserModified.of(user, map);
        final boolean offered = offer(event);
    }
}
