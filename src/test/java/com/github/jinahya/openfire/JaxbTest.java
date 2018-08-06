package com.github.jinahya.openfire;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class JaxbTest {

    @Test
    void printXmlSchema() throws JAXBException, IOException {
        final JAXBContext context = JAXBContext.newInstance(
                "com.github.jinahya.openfire.event"
                //+ ":"
                //"com.github.jinahya.openfire.user"
        );
        context.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(final String namespaceUri, final String suggestedFileName) throws IOException {
                return new StreamResult(System.out) {
                    @Override
                    public String getSystemId() {
                        return "";
                    }
                };
            }
        });
    }
}
