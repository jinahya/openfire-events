package com.github.jinahya.openfire.user;

import com.github.jinahya.openfire.EventIdentifier;

public enum PresenceEventIdentifier implements EventIdentifier {

    // -----------------------------------------------------------------------------------------------------------------
    AVAILABLE_SESSION,

    UNAVAILABLE_SESSION,

    // -----------------------------------------------------------------------------------------------------------------
    PRESENCE_CHANGED,

    // -----------------------------------------------------------------------------------------------------------------
    SUBSCRIBED_TO_PRESENCE,

    UNSUBSCRIBED_TO_PRESENCE
}
