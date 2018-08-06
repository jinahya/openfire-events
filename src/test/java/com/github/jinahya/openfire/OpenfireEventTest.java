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

import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public abstract class OpenfireEventTest<T extends OpenfireEvent<I>, I extends Enum<I> & OpenfireEventIdentifier<I>>
        extends EventTest<T, OpenfireEventNamespace, I> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with given event class.
     *
     * @param eventClass the event class to test
     */
    public OpenfireEventTest(final Class<T> eventClass, final Class<I> identifierClass) {
        super(eventClass, OpenfireEventNamespace.class, identifierClass);
    }
}
