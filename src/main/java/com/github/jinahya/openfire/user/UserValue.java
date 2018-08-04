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
package com.github.jinahya.openfire.user;

import org.jivesoftware.openfire.user.User;

import java.util.Date;
import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * A value class for {@link User}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class UserValue {

    public static UserValue of(final User object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        final UserValue value = new UserValue();
        value.setCreationDate(object.getCreationDate());
        value.setCreationMillis(
                ofNullable(object.getCreationDate()).map(Date::getTime)
                        .orElse(null));
        value.setEmail(object.getEmail());
        value.setModificationDate(object.getModificationDate());
        value.setModificationMillis(
                ofNullable(object.getModificationDate()).map(Date::getTime)
                        .orElse(null));
        value.setName(object.getName());
        value.setProperties(object.getProperties());
        value.setUsernmae(object.getUsername());
        return value;
    }

    // ------------------------------------------------------------ creationDate
    public Date getCreationDate() {
        return ofNullable(creationDate).map(v -> new Date(v.getTime()))
                .orElse(null);
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = ofNullable(creationDate)
                .map(v -> new Date(v.getTime())).orElse(null);
    }

    // ---------------------------------------------------------- creationMillis
    public Long getCreationMillis() {
        return creationMillis;
    }

    public void setCreationMillis(final Long creationMillis) {
        this.creationMillis = creationMillis;
    }

    // ------------------------------------------------------------------- email
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    // -------------------------------------------------------- modificationDate
    public Date getModificationDate() {
        return ofNullable(modificationDate).map(v -> new Date(v.getTime()))
                .orElse(null);
    }

    public void setModificationDate(final Date modificationDate) {
        this.modificationDate = ofNullable(modificationDate)
                .map(v -> new Date(v.getTime())).orElse(null);
    }

    // ------------------------------------------------------ modificationMillis
    public Long getModificationMillis() {
        return modificationMillis;
    }

    public void setModificationMillis(final Long modificationMillis) {
        this.modificationMillis = modificationMillis;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    // -------------------------------------------------------------- properties
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(final Map<String, String> properties) {
        this.properties = properties;
    }

    // ---------------------------------------------------------------- username
    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(final String usernmae) {
        this.usernmae = usernmae;
    }

    // -------------------------------------------------------------------------
    private Date creationDate;

    private Long creationMillis;

    private String email;

    private Date modificationDate;

    private Long modificationMillis;

    private String name;

    private Map<String, String> properties;

    private String usernmae;
}
