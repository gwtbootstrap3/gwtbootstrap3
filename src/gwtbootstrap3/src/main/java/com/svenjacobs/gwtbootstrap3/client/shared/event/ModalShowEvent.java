package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.ui.Modal;

/**
 * @author Sven Jacobs
 */
public class ModalShowEvent extends GwtEvent<ModalShowHandler> implements ModalEvent {

    private static final Type<ModalShowHandler> TYPE = new Type<ModalShowHandler>();

    private final Modal modal;
    private final Event nativeEvent;

    public static Type<ModalShowHandler> getType() {
        return TYPE;
    }

    public ModalShowEvent(final Modal modal, final Event nativeEvent) {
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
    public Type<ModalShowHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ModalShowHandler handler) {
        handler.onShow(this);
    }
}
