package com.github.jinahya.openfire.session;

import com.github.jinahya.openfire.privacy.PrivacyListValue;
import com.github.jinahya.xmpp.packet.PresenceValue;
import org.jivesoftware.openfire.session.ClientSession;
import org.jivesoftware.openfire.user.UserNotFoundException;

import static java.util.Optional.ofNullable;

public class ClientSessionValue {

    public static ClientSessionValue of(final ClientSession object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final ClientSessionValue value = new ClientSessionValue();
        value.setCanFloodOfflineMessages(object.canFloodOfflineMessages());
        value.setActiveList(ofNullable(object.getActiveList()).map(PrivacyListValue::of).orElse(null));
        value.setDefaultList(ofNullable(object.getDefaultList()).map(PrivacyListValue::of).orElse(null));
        value.setPresence(ofNullable(object.getPresence()).map(PresenceValue::of).orElse(null));
        try {
            value.setUsername(object.getUsername());
        } catch (final UserNotFoundException unfe) {
        }
        value.setIncrementConflictCount(object.incrementConflictCount());
        value.setAnonymousUser(object.isAnonymousUser());
        value.setInitialized(object.isInitialized());
        value.setMessageCarbonsEnabled(object.isMessageCarbonsEnabled());
        value.setOfflineFloodsStopped(object.isOfflineFloodStopped());
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean isCanFloodOfflineMessages() {
        return canFloodOfflineMessages;
    }

    void setCanFloodOfflineMessages(final boolean canFloodOfflineMessages) {
        this.canFloodOfflineMessages = canFloodOfflineMessages;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public PrivacyListValue getActiveList() {
        return activeList;
    }

    void setActiveList(final PrivacyListValue activeList) {
        this.activeList = activeList;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public PrivacyListValue getDefaultList() {
        return defaultList;
    }

    void setDefaultList(final PrivacyListValue defaultList) {
        this.defaultList = defaultList;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public PresenceValue getPresence() {
        return presence;
    }

    void setPresence(final PresenceValue presence) {
        this.presence = presence;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getUsername() {
        return username;
    }

    void setUsername(final String username) {
        this.username = username;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public int getIncrementConflictCount() {
        return incrementConflictCount;
    }

    void setIncrementConflictCount(final int incrementConflictCount) {
        this.incrementConflictCount = incrementConflictCount;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean isAnonymousUser() {
        return anonymousUser;
    }

    void setAnonymousUser(final boolean anonymousUser) {
        this.anonymousUser = anonymousUser;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean isInitialized() {
        return initialized;
    }

    void setInitialized(final boolean initialized) {
        this.initialized = initialized;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean isMessageCarbonsEnabled() {
        return messageCarbonsEnabled;
    }

    void setMessageCarbonsEnabled(final boolean messageCarbonsEnabled) {
        this.messageCarbonsEnabled = messageCarbonsEnabled;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean isOfflineFloodsStopped() {
        return offlineFloodsStopped;
    }

    void setOfflineFloodsStopped(final boolean offlineFloodsStopped) {
        this.offlineFloodsStopped = offlineFloodsStopped;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private boolean canFloodOfflineMessages;

    private PrivacyListValue activeList;

    private PrivacyListValue defaultList;

    private PresenceValue presence;

    private String username;

    private int incrementConflictCount;

    private boolean anonymousUser;

    private boolean initialized;

    private boolean messageCarbonsEnabled;

    private boolean offlineFloodsStopped;
}
