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
package com.github.jinahya.openfire.privacy;

import com.github.jinahya.openfire.BlockingEventAdapter;
import com.github.jinahya.openfire.privacy.privacylist.PrivacyListCreated;
import com.github.jinahya.openfire.privacy.privacylist.PrivacyListDeleting;
import com.github.jinahya.openfire.privacy.privacylist.PrivacyListEvent;
import com.github.jinahya.openfire.privacy.privacylist.PrivacyListModified;
import org.jivesoftware.openfire.privacy.PrivacyList;
import org.jivesoftware.openfire.privacy.PrivacyListEventListener;

import java.util.concurrent.BlockingQueue;

public class BlockingPrivacyListEventAdapter
        extends BlockingEventAdapter<PrivacyListEvent>
        implements PrivacyListEventListener {

    // -------------------------------------------------------------------------
    public BlockingPrivacyListEventAdapter(
            final BlockingQueue<? super PrivacyListEvent> queue) {
        super(queue);
    }

    // -------------------------------------------------------------------------
    @Override
    public void privacyListCreated(final PrivacyList list) {
        final boolean offered = offer(PrivacyListCreated.of(list));
    }

    @Override
    public void privacyListDeleting(final String listName) {
        final boolean offered = offer(PrivacyListDeleting.of(listName));
    }

    @Override
    public void privacyListModified(final PrivacyList list) {
        final boolean offer = offer(PrivacyListModified.of(list));
    }
}
