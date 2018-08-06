package com.github.jinahya.openfire.event;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum UserEventIdentifier implements OpenfireEventIdentifier<UserEventIdentifier> {

    USER_CREATED,

    USER_DELETING,

    USER_MODIFIED
}
