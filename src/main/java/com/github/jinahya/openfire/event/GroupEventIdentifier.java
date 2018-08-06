package com.github.jinahya.openfire.event;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum GroupEventIdentifier implements OpenfireEventIdentifier<GroupEventIdentifier> {

    ADMIN_ADDED,

    ADMIN_REMOVED,

    GROUP_CREATED,

    GROUP_DELETING,

    GROUP_MODIFIED,

    GROUP_REMOIVED,

    MEMBER_ADDED,

    MEMBER_REMOVED;
}
