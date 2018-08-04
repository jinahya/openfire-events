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

import com.github.jinahya.openfire.xmppserver.ServerStarted;
import com.github.jinahya.openfire.xmppserver.ServerStopping;
import com.github.jinahya.openfire.xmppserver.XmppServerEvent;
import org.jivesoftware.openfire.XMPPServerListener;

import java.util.concurrent.BlockingQueue;

/**
 * An adapter for offering events from {@link XMPPServerListener}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class BlockingXmppServerAdapter
        extends BlockingEventAdapter<XmppServerEvent>
        implements XMPPServerListener {

    // -------------------------------------------------------------------------
    public BlockingXmppServerAdapter(
            final BlockingQueue<? super XmppServerEvent> queue) {
        super(queue);
    }

    // -------------------------------------------------------------------------
    @Override
    public void serverStarted() {
        final boolean offered = offer(new ServerStarted());
    }

    @Override
    public void serverStopping() {
        final boolean offered = offer(new ServerStopping());
    }
}
