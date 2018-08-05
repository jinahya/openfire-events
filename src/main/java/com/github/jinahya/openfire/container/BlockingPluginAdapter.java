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
package com.github.jinahya.openfire.container;

import com.github.jinahya.openfire.BlockingEventAdapter;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginListener;

import java.util.concurrent.BlockingQueue;

public class BlockingPluginAdapter extends BlockingEventAdapter<PluginEvent> implements PluginListener {

    // -----------------------------------------------------------------------------------------------------------------
    public BlockingPluginAdapter(final BlockingQueue<? super PluginEvent> queue) {
        super(queue);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void pluginCreated(final String name, final Plugin plugin) {
        final boolean offered = offer(PluginEventPluginCreated.of(name));
    }

    @Override
    public void pluginDestroyed(final String name, final Plugin plugin) {
        final boolean offered = offer(PluginEventPluginDestroyed.of(name));
    }
}
