package com.github.jinahya.openfire.user;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum PresenceEventIdentifier implements OpenfireEventIdentifier<PresenceEventIdentifier> {

    AVAILABLE_SESSION,

    PRESENCE_CHANGED,

    SUBSCRIBED_TO_PRESENCE,

    UNAVAILABLE_SESSION,

    UNSUBSCRIBED_TO_PRESENCE;
}
