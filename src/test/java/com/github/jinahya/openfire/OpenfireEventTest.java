/*
 * Copyright 2018 Jin Kwon &lt;onacit at gmail.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

public abstract class OpenfireEventTest<T extends OpenfireEvent> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with given event class.
     *
     * @param eventClass the event class to test
     */
    public OpenfireEventTest(final Class<T> eventClass) {
        super();
        this.eventClass = requireNonNull(eventClass, "eventClass is null");
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
    protected <R> R applyJaxbContext(final Function<JAXBContext, R> contextFunction) throws JAXBException {
        return JaxbContexts.applyJaxbContext(eventClass, contextFunction);
    }

    protected <U, R> R applyJaxbContext(final BiFunction<JAXBContext, U, R> contextFunction,
                                        final Supplier<U> argumentSupplier)
            throws JAXBException {
        return JaxbContexts.applyJaxbContext(eventClass, contextFunction, argumentSupplier);
    }

    protected void acceptJaxbContext(final Consumer<JAXBContext> contextConsumer) throws JAXBException {
        JaxbContexts.acceptJaxbContext(eventClass, contextConsumer);
    }

    protected <U> void acceptJaxbContext(final BiConsumer<JAXBContext, U> contextConsumer,
                                         final Supplier<U> argumentSupplier)
            throws JAXBException {
        JaxbContexts.acceptJaxbContext(eventClass, contextConsumer, argumentSupplier);
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
}
