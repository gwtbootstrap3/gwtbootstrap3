package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Joshua Godi
 */
public class SlidEvent extends GwtEvent<SlidHandler> {
    private static final Type<SlidHandler> TYPE = new Type<SlidHandler>();
    private final NativeEvent nativeEvent;

    public static Type<SlidHandler> getType() {
        return TYPE;
    }

    public SlidEvent() {
        this(null);
    }

    public SlidEvent(final NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    @Override
    public final Type<SlidHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final SlidHandler handler) {
        handler.onSlid(this);
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