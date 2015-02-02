package org.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * @author Sven Jacobs
 */
public class AlertClosedEvent extends GwtEvent<AlertClosedHandler> {

    private static final Type<AlertClosedHandler> TYPE = new Type<AlertClosedHandler>();

    private final Event nativeEvent;

    public static Type<AlertClosedHandler> getType() {
        return TYPE;
    }

    public AlertClosedEvent(final Event nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<AlertClosedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final AlertClosedHandler handler) {
        handler.onClosed(this);
    }
}
