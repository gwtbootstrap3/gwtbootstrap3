package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Joshua Godi
 */
public class HiddenEvent extends GwtEvent<HiddenHandler> {
    private static final Type<HiddenHandler> TYPE = new Type<HiddenHandler>();
    private final NativeEvent nativeEvent;

    public static Type<HiddenHandler> getType() {
        return TYPE;
    }

    public HiddenEvent() {
        this(null);
    }

    public HiddenEvent(final NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    @Override
    public final Type<HiddenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final HiddenHandler handler) {
        handler.onHidden(this);
    }

    public final void preventDefault() {
        if (nativeEvent == null) return;
        nativeEvent.preventDefault();
    }

    public final void stopPropagation() {
        if (nativeEvent == null) return;
        nativeEvent.stopPropagation();
    }
}
