package com.github.jinahya.openfire.event;

import com.github.jinahya.openfire.OpenfireEventTest;

/**
 * An abstract class for testing subclasses of {@link UserEvent}.
 *
 * @param <T> subclass type parameter
 */
public abstract class UserEventTest<T extends UserEvent> extends OpenfireEventTest<T> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance for testing specified event class.
     *
     * @param eventClass the event class to test.
     */
    public UserEventTest(final Class<T> eventClass) {
        super(eventClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
}
