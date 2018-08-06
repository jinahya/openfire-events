package com.github.jinahya.openfire.component;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ExternalComponentManagerEventIdentifier
        implements OpenfireEventIdentifier<ExternalComponentManagerEventIdentifier> {

    COMPONENT_ALLOWED;
}
