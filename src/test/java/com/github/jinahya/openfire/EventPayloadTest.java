package com.github.jinahya.openfire;

import java.lang.reflect.Constructor;

import static java.util.Objects.requireNonNull;

public abstract class EventPayloadTest<T extends EventPayload> {

    // -----------------------------------------------------------------------------------------------------------------
    public EventPayloadTest(final Class<T> payloadClass) {
        super();
        this.payloadClass = requireNonNull(payloadClass, "payloadClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected T payloadInstance() {
        try {
            final Constructor<T> constructor = payloadClass.getDeclaredConstructor();
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance();
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<T> payloadClass;
}
