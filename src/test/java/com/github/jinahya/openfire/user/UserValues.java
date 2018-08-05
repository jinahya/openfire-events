package com.github.jinahya.openfire.user;

import java.util.Date;

public final class UserValues {

    public static UserValue newRandomInstance() {
        final UserValue instance = new UserValue();
        instance.setCreationDate(new Date());
        instance.setCreationMillis(instance.getCreationDate().getTime());
        instance.setEmail("user@example.com");
        instance.setModificationDate(new Date());
        instance.setModificationMillis(instance.getModificationDate().getTime());
        instance.setName("name");
        instance.setUsername("username");
        {
            instance.getProperties().add(UserValueProperty.of("key1", "value1"));
            instance.getProperties().add(UserValueProperty.of("key2", "value1"));
            instance.getProperties().add(UserValueProperty.of("key3", null));
        }
        return instance;
    }

    private UserValues() {
        super();
    }
}
