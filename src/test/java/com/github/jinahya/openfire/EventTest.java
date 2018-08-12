package com.github.jinahya.openfire;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.function.*;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class EventTest<T extends Event<N, I>, N extends Enum<N>, I extends Enum<I>> {

    public EventTest(final Class<T> eventClass, final Class<N> namespaceClass, final Class<I> identifierClass) {
        super();
        this.eventClass = requireNonNull(eventClass, "eventClass is null");
        this.namespaceClass = requireNonNull(namespaceClass, "namespaceClass is null");
        this.identifierClass = requireNonNull(identifierClass, "identifierClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected <R> R applyJaxbContext(final Function<JAXBContext, R> contextFunction) throws JAXBException {
        if (contextFunction == null) {
            throw new NullPointerException("contextFunction is null");
        }
        final JAXBContext context = JAXBContext.newInstance(eventClass);
        return contextFunction.apply(context);
    }

    protected <U, R> R applyJaxbContext(final BiFunction<JAXBContext, U, R> contextFunction,
                                        final Supplier<U> argumentSupplier)
            throws JAXBException {
        if (argumentSupplier == null) {
            throw new NullPointerException("argumentSupplier is null");
        }
        return applyJaxbContext(c -> contextFunction.apply(c, argumentSupplier.get()));
    }

    protected void acceptJaxbContext(final Consumer<JAXBContext> contextConsumer)
            throws JAXBException {
        if (contextConsumer == null) {
            throw new NullPointerException("contextConsumer is null");
        }
        applyJaxbContext(c -> {
            contextConsumer.accept(c);
            return null;
        });
    }

    protected <U> void acceptJaxbContext(final BiConsumer<JAXBContext, U> contextConsumer,
                                         final Supplier<U> argumentSupplier)
            throws JAXBException {
        if (argumentSupplier == null) {
            throw new NullPointerException("argumentSupplier is null");
        }
        acceptJaxbContext(c -> contextConsumer.accept(c, argumentSupplier.get()));
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected T eventInstance() {
        try {
            final Constructor<T> constructor = eventClass.getConstructor();
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance();
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void printXml() throws JAXBException {
        acceptJaxbContext(c -> {
            try {
                final Marshaller marshaller = c.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(eventInstance(), System.out);
            } catch (final JAXBException jaxbe) {
                fail(jaxbe);
            }
        });
    }

    @Test
    void printJsonJackson() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(System.out, eventInstance());
        System.out.println();
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<T> eventClass;

    protected final Class<N> namespaceClass;

    protected final Class<I> identifierClass;
}
