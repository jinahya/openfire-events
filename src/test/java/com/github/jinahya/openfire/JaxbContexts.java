package com.github.jinahya.openfire;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.function.*;

public final class JaxbContexts {

    public static <T extends OpenfireEvent, R> R applyJaxbContext(
            final Class<T> eventClass, final Function<JAXBContext, R> contextFunction)
            throws JAXBException {
        if (eventClass == null) {
            throw new NullPointerException("eventClass is null");
        }
        if (contextFunction == null) {
            throw new NullPointerException("contextFunction is null");
        }
        final JAXBContext context = JAXBContext.newInstance(eventClass.getPackage().getName());
        return contextFunction.apply(context);
    }

    public static <T extends OpenfireEvent, U, R> R applyJaxbContext(
            final Class<T> eventClass, final BiFunction<JAXBContext, U, R> contextFunction,
            final Supplier<U> argumentSupplier)
            throws JAXBException {
        if (argumentSupplier == null) {
            throw new NullPointerException("argumentSupplier is null");
        }
        return applyJaxbContext(eventClass, c -> contextFunction.apply(c, argumentSupplier.get()));
    }

    public static <T extends OpenfireEvent> void acceptJaxbContext(
            final Class<T> eventClass, final Consumer<JAXBContext> contextConsumer)
            throws JAXBException {
        if (contextConsumer == null) {
            throw new NullPointerException("contextConsumer is null");
        }
        applyJaxbContext(eventClass, c -> {
            contextConsumer.accept(c);
            return null;
        });
    }

    public static <T extends OpenfireEvent, U> void acceptJaxbContext(
            final Class<T> eventClass, final BiConsumer<JAXBContext, U> contextConsumer,
            final Supplier<U> argumentSupplier)
            throws JAXBException {
        if (argumentSupplier == null) {
            throw new NullPointerException("argumentSupplier is null");
        }
        acceptJaxbContext(eventClass, c -> contextConsumer.accept(c, argumentSupplier.get()));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private JaxbContexts() {
        super();
    }
}
