package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.ui.Modal;

/**
 * @author Sven Jacobs
 */
public class ModalHiddenEvent extends GwtEvent<ModalHiddenHandler> implements ModalEvent {

    private static final Type<ModalHiddenHandler> TYPE = new Type<ModalHiddenHandler>();

    private final Modal modal;
    private final Event nativeEvent;

    public static Type<ModalHiddenHandler> getType() {
        return TYPE;
    }

    public ModalHiddenEvent(final Modal modal, final Event nativeEvent) {
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
    public Type<ModalHiddenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ModalHiddenHandler handler) {
        handler.onHidden(this);
    }
}
