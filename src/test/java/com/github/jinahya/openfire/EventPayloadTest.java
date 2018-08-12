package com.github.jinahya.openfire;

import static java.util.Objects.requireNonNull;

public abstract class EventPayloadTest<T extends EventPayload> {

    // -----------------------------------------------------------------------------------------------------------------
    public EventPayloadTest(final Class<T> payloadClass) {
        super();
        this.payloadClass = requireNonNull(payloadClass, "payloadClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<T> payloadClass;
}
