package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.ui.Modal;

/**
 * @author Sven Jacobs
 */
public class ModalHideEvent extends GwtEvent<ModalHideHandler> implements ModalEvent {

    private static final Type<ModalHideHandler> TYPE = new Type<ModalHideHandler>();

    private final Modal modal;
    private final Event nativeEvent;

    public static Type<ModalHideHandler> getType() {
        return TYPE;
    }

    public ModalHideEvent(final Modal modal, final Event nativeEvent) {
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
    public Type<ModalHideHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ModalHideHandler handler) {
        handler.onHide(this);
    }
}
