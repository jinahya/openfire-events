package com.github.jinahya.openfire.muc;

import com.github.jinahya.openfire.EventIdentifier;

public enum MucEventIdentifier implements EventIdentifier {

    MESSAGE_RECEIVED,

    // -----------------------------------------------------------------------------------------------------------------
    NICKNAME_CHANGED,

    // -----------------------------------------------------------------------------------------------------------------
    OCCUPANT_JOINED,

    OCCUPANT_LEFT,

    // -----------------------------------------------------------------------------------------------------------------
    PRIVATE_MESSAGE_RECEIVED,

    // -----------------------------------------------------------------------------------------------------------------
    ROOM_CREATED,

    ROOM_DESTROYED,

    ROOM_SUBJECT_CHANGED
}
