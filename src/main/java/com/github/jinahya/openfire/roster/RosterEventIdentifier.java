package com.github.jinahya.openfire.roster;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum RosterEventIdentifier implements OpenfireEventIdentifier<RosterEventIdentifier> {

    ADDING_CONTACT,
    CONTACT_ADDED,
    CONTACT_DELETED,
    CONTACT_UPDATED,
    ROSTER_LOADED
}
