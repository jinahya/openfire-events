package com.github.jinahya.openfire.privacy;

import com.github.jinahya.xmpp.packet.JidValue;
import org.jivesoftware.openfire.privacy.PrivacyList;

import static java.util.Optional.ofNullable;

public class PrivacyListValue {

    public static PrivacyListValue of(final PrivacyList object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final PrivacyListValue value = new PrivacyListValue();
        value.setName(object.getName());
        value.setUserJid(ofNullable(object.getUserJID()).map(JidValue::of).orElse(null));
        value.setDefault(object.isDefault());
        return null;
    }

    // ------------------------------------------------------------------------------------------------------------ name
    public String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public JidValue getUserJid() {
        return userJid;
    }

    void setUserJid(final JidValue userJid) {
        this.userJid = userJid;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean isDefault() {
        return default_;
    }

    void setDefault(final boolean default_) {
        this.default_ = default_;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String name;

    private JidValue userJid;

    private boolean default_;
}
