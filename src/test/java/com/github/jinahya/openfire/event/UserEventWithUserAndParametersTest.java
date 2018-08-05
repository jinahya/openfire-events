package com.github.jinahya.openfire.event;

import com.github.jinahya.openfire.user.UserValues;

abstract class UserEventWithUserAndParametersTest<T extends UserEventWithUserAndParams> extends UserEventTest<T> {

    // -----------------------------------------------------------------------------------------------------------------
    UserEventWithUserAndParametersTest(final Class<T> eventClass) {
        super(eventClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    protected T eventInstance() {
        final T eventInstance = super.eventInstance();
        eventInstance.setUser(UserValues.newRandomInstance());
        {
            eventInstance.getParameters().add(UserEventParameter.of("key1", "value1"));
            eventInstance.getParameters().add(UserEventParameter.of("key1", 1L));
            eventInstance.getParameters().add(UserEventParameter.of("key1", new Object()));
        }
        return eventInstance;
    }
}
