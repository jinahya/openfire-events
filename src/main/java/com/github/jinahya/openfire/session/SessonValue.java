package com.github.jinahya.openfire.session;

import com.github.jinahya.util.LocaleValue;
import com.github.jinahya.xmpp.packet.JidValue;

import java.util.Date;

public class SessonValue {

    private JidValue address;

    private String cipherSuiteName;

    private Date creationDate;

    private String hostAddress;

    private String hostName;

    private LocaleValue language;

    private Date lastActiveDate;

    private long numClientPackets;

    private long numServerPackets;

    private String serverName;

    private int status;

    private String streamId;

    private boolean closed;

    private boolean secure;
}
