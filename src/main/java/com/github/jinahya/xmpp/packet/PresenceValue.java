package com.github.jinahya.xmpp.packet;

import org.xmpp.packet.Presence;

public class PresenceValue {

    public static PresenceValue of(final Presence object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final PresenceValue value = new PresenceValue();
        value.setPriority(object.getPriority());
        value.setShow(object.getShow());
        value.setStatus(object.getStatus());
        value.setType(object.getType());
        value.setAvailable(object.isAvailable());
        return value;
    }


    // -----------------------------------------------------------------------------------------------------------------
    public int getPriority() {
        return priority;
    }

    void setPriority(final int priority) {
        this.priority = priority;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public Presence.Show getShow() {
        return show;
    }

    void setShow(final Presence.Show show) {
        this.show = show;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getStatus() {
        return status;
    }

    void setStatus(final String status) {
        this.status = status;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public Presence.Type getType() {
        return type;
    }

    void setType(final Presence.Type type) {
        this.type = type;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean isAvailable() {
        return available;
    }

    void setAvailable(final boolean available) {
        this.available = available;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private int priority;

    private Presence.Show show;

    private String status;

    private Presence.Type type;

    private boolean available;
}
