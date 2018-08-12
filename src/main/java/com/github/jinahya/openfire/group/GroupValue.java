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
package com.github.jinahya.openfire.group;

import org.jivesoftware.openfire.group.Group;

import javax.xml.bind.annotation.XmlElement;

import static java.util.Optional.ofNullable;

/**
 * A value class for {@link Group}
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class GroupValue {

    // -----------------------------------------------------------------------------------------------------------------
    public static GroupValue of(final Group object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final GroupValue value = new GroupValue();
        value.setDescription(object.getDescription());
        value.setJid(ofNullable(object.getJID()).map(GroupJidValue::of).orElse(null));
        value.setName(object.getName());
        return value;
    }

    // ----------------------------------------------------------------------------------------------------- description
    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    // ------------------------------------------------------------------------------------------------------------- jid
    public GroupJidValue getJid() {
        return jid;
    }

    void setJid(final GroupJidValue jid) {
        this.jid = jid;
    }

    // ------------------------------------------------------------------------------------------------------------ name
    public String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private String description;

    @XmlElement
    private GroupJidValue jid;

    @XmlElement
    private String name;
}
