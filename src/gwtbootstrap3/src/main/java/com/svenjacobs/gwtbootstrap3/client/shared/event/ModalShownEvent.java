package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.ui.Modal;

/**
 * @author Sven Jacobs
 */
public class ModalShownEvent extends GwtEvent<ModalShownHandler> implements ModalEvent {

    private static final Type<ModalShownHandler> TYPE = new Type<ModalShownHandler>();

    private final Modal modal;
    private final Event nativeEvent;

    public static Type<ModalShownHandler> getType() {
        return TYPE;
    }

    public ModalShownEvent(final Modal modal, final Event nativeEvent) {
        this.modal = modal;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public Modal getModal() {
        return modal;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<ModalShownHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ModalShownHandler handler) {
        handler.onShown(this);
    }
}
