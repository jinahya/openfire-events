package com.github.jinahya.openfire.container;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum PluginEventIdentifier implements OpenfireEventIdentifier<PluginEventIdentifier> {

    PLUGIN_CREATED,

    PLUGIN_DESTROYED;
}
