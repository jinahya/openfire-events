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

import java.util.Date;
import java.util.Map;
import static java.util.Optional.ofNullable;
import org.jivesoftware.openfire.user.User;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class UserValue {

    public static UserValue of(final User user) {
        if (user == null) {
            return null;
        }
        final UserValue instance = new UserValue();
        instance.setCreationDate(user.getCreationDate());
        instance.setEmail(user.getEmail());
        instance.setModificationDate(user.getModificationDate());
        instance.setName(user.getName());
        instance.setProperties(user.getProperties());
        instance.setUsernmae(user.getUsername());
        return instance;
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

    private String email;

    private Date modificationDate;

    private String name;

    private Map<String, String> properties;

    private String usernmae;
}
