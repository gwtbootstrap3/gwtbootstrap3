package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * @author Sven Jacobs
 */
public class AlertCloseEvent extends GwtEvent<AlertCloseHandler> {

    private static final Type<AlertCloseHandler> TYPE = new Type<AlertCloseHandler>();

    private final Event nativeEvent;

    public static Type<AlertCloseHandler> getType() {
        return TYPE;
    }

    public AlertCloseEvent(final Event nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<AlertCloseHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final AlertCloseHandler handler) {
        handler.onClose(this);
    }
}
