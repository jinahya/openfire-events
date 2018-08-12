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

import com.github.jinahya.openfire.group.GroupValue;
import org.jivesoftware.openfire.group.Group;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

@XmlTransient
abstract class GroupEventPayloadWithGroupAndParams implements GroupEventPayload {

    // -----------------------------------------------------------------------------------------------------------------
    static <T extends GroupEventPayloadWithGroupAndParams> T of(final Supplier<T> supplier, final Group group,
                                                                final Map params) {
        final T instance = supplier.get();
        instance.setGroup(ofNullable(group).map(GroupValue::of).orElse(null));
        instance.setParams(params);
        return instance;
    }

    // ----------------------------------------------------------------------------------------------------------- group
    public GroupValue getGroup() {
        return group;
    }

    void setGroup(final GroupValue group) {
        this.group = group;
    }

    // ---------------------------------------------------------------------------------------------------------- params
    public Map getParams() {
        return params;
    }

    void setParams(final Map params) {
        this.params = params;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private GroupValue group;

    private Map params;
}
