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
import com.github.jinahya.openfire.Event;
import org.jivesoftware.openfire.event.GroupEventListener;
import org.jivesoftware.openfire.group.Group;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class BlockingGroupEventAdapter extends BlockingEventAdapter<GroupEventPayload> implements GroupEventListener {

    // -----------------------------------------------------------------------------------------------------------------
    public BlockingGroupEventAdapter(final BlockingQueue<Event<? super GroupEventPayload>> queue) {
        super(GroupEventPayload.NAMESPACE, queue);
    }

    // ----------------------------------------------------------------------------------------------------------- admin
    @Override
    public void adminAdded(final Group group, final Map params) {
        final boolean offered = offer(GroupEventIdentifier.ADMIN_ADDED, GroupEventPayloadAdminAdded.of(group, params));
    }

    @Override
    public void adminRemoved(final Group group, final Map params) {
        final boolean offered = offer(GroupEventIdentifier.ADMIN_REMOVED,
                                      GroupEventPayloadAdminRemoved.of(group, params));
    }

    // ----------------------------------------------------------------------------------------------------------- group
    @Override
    public void groupCreated(final Group group, final Map params) {
        final boolean offered = offer(GroupEventIdentifier.GROUP_CREATED,
                                      GroupEventPayloadGroupCreated.of(group, params));
    }

    @Override
    public void groupDeleting(final Group group, final Map params) {
        final boolean offered = offer(GroupEventIdentifier.GROUP_DELETING,
                                      GroupEventPayloadGroupDeleting.of(group, params));
    }

    @Override
    public void groupModified(final Group group, final Map params) {
        final boolean offered = offer(GroupEventIdentifier.GROUP_MODIFIED,
                                      GroupEventPayloadGroupModified.of(group, params));
    }

    // ---------------------------------------------------------------------------------------------------------- member
    @Override
    public void memberAdded(final Group group, final Map params) {
        final boolean offfered = offer(GroupEventIdentifier.MEMBER_ADDED,
                                       GroupEventPayloadMemberAdded.of(group, params));
    }

    @Override
    public void memberRemoved(final Group group, final Map params) {
        final boolean offered = offer(GroupEventIdentifier.MEMBER_REMOVED,
                                      GroupEventPayloadMemberRemoved.of(group, params));
    }
}
