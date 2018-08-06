package com.github.jinahya.openfire.user;

import com.github.jinahya.openfire.BlockingEventAdapter;
import org.jivesoftware.openfire.session.ClientSession;
import org.jivesoftware.openfire.user.PresenceEventListener;
import org.xmpp.packet.JID;
import org.xmpp.packet.Presence;

import java.util.concurrent.BlockingQueue;

public class BlockingPresenceEventAdapter extends BlockingEventAdapter<PresenceEvent> implements PresenceEventListener {

    // -----------------------------------------------------------------------------------------------------------------
    public BlockingPresenceEventAdapter(final BlockingQueue<? super PresenceEvent> queue) {
        super(queue);
    }

    @Override
    public void availableSession(final ClientSession session, final Presence presence) {
        final boolean offered = offer(PresenceEventAvailableSession.of(session, presence));
    }

    @Override
    public void unavailableSession(final ClientSession session, final Presence presence) {
        final boolean offered = offer(PresenceEventUnavailableSession.of(session, presence));
    }

    @Override
    public void presenceChanged(final ClientSession session, final Presence presence) {
        final boolean offered = offer(PresenceEventPresenceChanged.of(session, presence));
    }

    @Override
    public void subscribedToPresence(final JID subscriberJID, final JID authorizerJID) {
        final boolean offered = offer(PresenceEventSubscribedToPresence.of(subscriberJID, authorizerJID));
    }

    @Override
    public void unsubscribedToPresence(final JID unsubscriberJID, final JID recipientJID) {
        final boolean offered = offer(PresenceEventUnsubscribedToPresence.of(unsubscriberJID, recipientJID));
    }
}
