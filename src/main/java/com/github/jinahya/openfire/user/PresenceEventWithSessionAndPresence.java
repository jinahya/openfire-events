package com.github.jinahya.openfire.user;

import com.github.jinahya.openfire.session.ClientSessionValue;
import com.github.jinahya.xmpp.packet.PresenceValue;
import org.jivesoftware.openfire.session.ClientSession;
import org.xmpp.packet.Presence;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

@XmlTransient
abstract class PresenceEventWithSessionAndPresence extends PresenceEvent {

    static <T extends PresenceEventWithSessionAndPresence> T of(final Supplier<T> supplier, final ClientSession session,
                                                                final Presence presence) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = supplier.get();
        instance.setSession(ofNullable(session).map(ClientSessionValue::of).orElse(null));
        instance.setPresence(ofNullable(presence).map(PresenceValue::of).orElse(null));
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    PresenceEventWithSessionAndPresence(final PresenceEventIdentifier identifier) {
        super(identifier);
    }

    // --------------------------------------------------------------------------------------------------------- session
    public ClientSessionValue getSession() {
        return session;
    }

    void setSession(final ClientSessionValue session) {
        this.session = session;
    }

    // -------------------------------------------------------------------------------------------------------- presence
    public PresenceValue getPresence() {
        return presence;
    }

    void setPresence(final PresenceValue presence) {
        this.presence = presence;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlElement
    private ClientSessionValue session;

    @XmlElement
    private PresenceValue presence;
}
