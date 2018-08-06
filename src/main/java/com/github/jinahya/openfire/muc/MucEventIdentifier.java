package com.github.jinahya.openfire.muc;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum MucEventIdentifier implements OpenfireEventIdentifier<MucEventIdentifier> {

    MESSAGE_RECEIVED,
    NICKNAME_CHANGED,
    OCCUPANT_JOINED,
    OCCUPANT_LEFT,
    PRIVATE_MESSAGE_RECEIVED,
    ROOM_CREATED,
    ROOM_DESTROYED,
    ROOM_SUBJECT_CHANGED
    }
