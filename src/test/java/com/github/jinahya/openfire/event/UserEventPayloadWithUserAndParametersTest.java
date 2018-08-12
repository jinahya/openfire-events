package com.github.jinahya.openfire.event;

abstract class UserEventPayloadWithUserAndParametersTest<T extends UserEventPayloadWithUserAndParams>
        extends UserEventPayloadTest<T> {

    // -----------------------------------------------------------------------------------------------------------------
    UserEventPayloadWithUserAndParametersTest(final Class<T> payloadClass) {
        super(payloadClass);
    }
}
