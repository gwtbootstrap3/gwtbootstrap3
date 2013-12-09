package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Joshua Godi
 */
public class ShownEvent extends GwtEvent<ShownHandler> {
    private static final Type<ShownHandler> TYPE = new Type<ShownHandler>();
    private final NativeEvent nativeEvent;

    public static Type<ShownHandler> getType() {
        return TYPE;
    }

    public ShownEvent() {
        this(null);
    }

    public ShownEvent(NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    @Override
    public final Type<ShownHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ShownHandler handler) {
        handler.onShown(this);
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