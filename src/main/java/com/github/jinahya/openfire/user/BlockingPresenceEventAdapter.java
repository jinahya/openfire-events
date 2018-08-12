package com.github.jinahya.openfire.user;

import com.github.jinahya.openfire.BlockingEventAdapter;
import com.github.jinahya.openfire.Event;
import org.jivesoftware.openfire.session.ClientSession;
import org.jivesoftware.openfire.user.PresenceEventListener;
import org.xmpp.packet.JID;
import org.xmpp.packet.Presence;

import java.util.concurrent.BlockingQueue;

public class BlockingPresenceEventAdapter extends BlockingEventAdapter<PresenceEventPayload>
        implements PresenceEventListener {

    // -----------------------------------------------------------------------------------------------------------------
    public BlockingPresenceEventAdapter(final BlockingQueue<Event<? super PresenceEventPayload>> queue) {
        super(PresenceEventPayload.NAMESPACE, queue);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void availableSession(final ClientSession session, final Presence presence) {
        final boolean offered = offer(PresenceEventIdentifier.AVAILABLE_SESSION,
                                      PresenceEventAvailableSession.of(session, presence));
    }

    @Override
    public void unavailableSession(final ClientSession session, final Presence presence) {
        final boolean offered = offer(PresenceEventIdentifier.UNAVAILABLE_SESSION,
                                      PresenceEventPayloadUnavailableSession.of(session, presence));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void presenceChanged(final ClientSession session, final Presence presence) {
        final boolean offered = offer(PresenceEventIdentifier.PRESENCE_CHANGED,
                                      PresenceEventPayloadPresenceChanged.of(session, presence));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public void subscribedToPresence(final JID subscriberJID, final JID authorizerJID) {
        final boolean offered = offer(PresenceEventIdentifier.SUBSCRIBED_TO_PRESENCE,
                                      PresenceEventSubscribedToPresence.of(subscriberJID, authorizerJID));
    }

    @Override
    public void unsubscribedToPresence(final JID unsubscriberJID, final JID recipientJID) {
        final boolean offered = offer(PresenceEventIdentifier.UNSUBSCRIBED_TO_PRESENCE,
                                      PresenceEventPayloadUnsubscribedToPresence.of(unsubscriberJID, recipientJID));
    }
}
