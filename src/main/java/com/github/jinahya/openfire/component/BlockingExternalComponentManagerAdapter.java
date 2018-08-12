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
package com.github.jinahya.openfire.component;

import com.github.jinahya.openfire.BlockingEventAdapter;
import com.github.jinahya.openfire.Event;
import org.jivesoftware.openfire.component.ExternalComponentConfiguration;
import org.jivesoftware.openfire.component.ExternalComponentManager;
import org.jivesoftware.openfire.component.ExternalComponentManagerListener;
import org.jivesoftware.util.ModificationNotAllowedException;

import java.util.concurrent.BlockingQueue;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class BlockingExternalComponentManagerAdapter extends BlockingEventAdapter<ExternalComponentManagerEventPayload>
        implements ExternalComponentManagerListener {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String NAMESPACE = "OPENFIRE_COMPONENT_EXTERNALCOMPONENTMANAGER";

    // -----------------------------------------------------------------------------------------------------------------
    public BlockingExternalComponentManagerAdapter(
            final BlockingQueue<Event<? super ExternalComponentManagerEventPayload>> queue) {
        super(NAMESPACE, queue);
    }

    // -------------------------------------------------------------------------
    @Override
    public void componentAllowed(final String subdomain, final ExternalComponentConfiguration configuration)
            throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentBlocked(final String subdomain) throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentConfigurationDeleted(final String subdomain) throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentSecretUpdated(final String subdomain, final String newSecret) throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // -------------------------------------------------------------------------
    @Override
    public void defaultSecretChanged(final String newSecret) throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void permissionPolicyChanged(final ExternalComponentManager.PermissionPolicy newPolicy)
            throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void portChanged(final int newPort)
            throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serviceEnabled(final boolean enabled)
            throws ModificationNotAllowedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
