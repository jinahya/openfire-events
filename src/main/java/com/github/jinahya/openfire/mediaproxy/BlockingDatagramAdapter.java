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
package com.github.jinahya.openfire.mediaproxy;

import com.github.jinahya.openfire.BlockingEventAdapter;
import com.github.jinahya.openfire.mediaproxy.datagram.DatagramEvent;
import org.jivesoftware.openfire.mediaproxy.DatagramListener;

import java.net.DatagramPacket;
import java.util.concurrent.BlockingQueue;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class BlockingDatagramAdapter extends BlockingEventAdapter<DatagramEvent>
        implements DatagramListener {

    // -------------------------------------------------------------------------
    public BlockingDatagramAdapter(
            final BlockingQueue<? super DatagramEvent> queue) {
        super(queue);
    }

    @Override
    public boolean datagramReceived(DatagramPacket dp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
