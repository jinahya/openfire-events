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
package com.github.jinahya.xmpp.packet;

import org.xmpp.packet.Message;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class MessageValue {

    // -------------------------------------------------------------------------
    public static MessageValue of(final Message object) {
        if (object == null) {
            return null;
        }
        final MessageValue value = new MessageValue();
        value.setBody(object.getBody());
        value.setSubject(object.getSubject());
        value.setThread(object.getThread());
        value.setType(object.getType().name());
        return value;
    }

    // -------------------------------------------------------------------------
    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    // -------------------------------------------------------------------------
    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    // -------------------------------------------------------------------------
    public String getThread() {
        return thread;
    }

    public void setThread(final String thread) {
        this.thread = thread;
    }

    // -------------------------------------------------------------------------
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    // -------------------------------------------------------------------------
    private String body;

    private String subject;

    private String thread;

    private String type;
}
