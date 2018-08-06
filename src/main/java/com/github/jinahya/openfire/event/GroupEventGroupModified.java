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

import org.jivesoftware.openfire.group.Group;

import java.util.Map;

public class GroupEventGroupModified extends GroupEventWithGroupAndParams {

    // -----------------------------------------------------------------------------------------------------------------
    public static GroupEventGroupModified of(final Group group, final Map params) {
        final GroupEventGroupModified instance = of(GroupEventGroupModified::new, group, params);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public GroupEventGroupModified() {
        super(GroupEventIdentifier.GROUP_MODIFIED);
    }
}
