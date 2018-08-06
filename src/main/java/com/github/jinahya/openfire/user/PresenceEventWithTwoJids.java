package com.github.jinahya.openfire.user;

import com.github.jinahya.xmpp.packet.JidValue;
import org.xmpp.packet.JID;

import javax.xml.bind.annotation.XmlTransient;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

@XmlTransient
abstract class PresenceEventWithTwoJids extends PresenceEvent {

    static <T extends PresenceEventWithTwoJids> T of(final Supplier<T> supplier, final JID jid1, final JID jid2) {
        if (supplier == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = supplier.get();
        instance.setJid1(ofNullable(jid1).map(JidValue::of).orElse(null));
        instance.setJid2(ofNullable(jid2).map(JidValue::of).orElse(null));
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    PresenceEventWithTwoJids(final PresenceEventIdentifier identifier) {
        super(identifier);
    }

    // -----------------------------------------------------------------------------------------------------------------
    JidValue getJid1() {
        return jid1;
    }

    void setJid1(final JidValue jid1) {
        this.jid1 = jid1;
    }

    // -----------------------------------------------------------------------------------------------------------------
    JidValue getJid2() {
        return jid2;
    }

    void setJid2(final JidValue jid2) {
        this.jid2 = jid2;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private JidValue jid1;

    private JidValue jid2;
}
