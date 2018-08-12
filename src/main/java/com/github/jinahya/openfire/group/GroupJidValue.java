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

import com.github.jinahya.xmpp.packet.JidValue;
import org.jivesoftware.openfire.group.GroupJID;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class GroupJidValue extends JidValue {

    // -----------------------------------------------------------------------------------------------------------------
    static GroupJidValue of(final GroupJID object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final GroupJidValue value = of(GroupJidValue::new, object);
        value.setGroupName(object.getGroupName());
        return value;
    }

    // -------------------------------------------------------------------------
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private String groupName;
}
