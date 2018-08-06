package com.github.jinahya.openfire.component;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ComponentEventIdentifier implements OpenfireEventIdentifier<ComponentEventIdentifier> {

    COMPONENT_INFO_RECEIVED,
    COMPONENT_REGISTERED,
    COMPONENT_UNREGISTERED;
}
