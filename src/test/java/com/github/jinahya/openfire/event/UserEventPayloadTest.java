package com.github.jinahya.openfire.event;

import com.github.jinahya.openfire.EventPayloadTest;

/**
 * An abstract class for testing subclasses of {@link UserEventPayload}.
 *
 * @param <T> subclass type parameter
 */
public abstract class UserEventPayloadTest<T extends UserEventPayload> extends EventPayloadTest<T> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance for testing specified payload class.
     *
     * @param payloadClass the payload class to test.
     */
    public UserEventPayloadTest(final Class<T> payloadClass) {
        super(payloadClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
}
