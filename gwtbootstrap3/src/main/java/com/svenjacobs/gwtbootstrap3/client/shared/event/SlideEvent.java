package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Joshua Godi
 */
public class SlideEvent extends GwtEvent<SlideHandler> {
    private static final Type<SlideHandler> TYPE = new Type<SlideHandler>();
    private final NativeEvent nativeEvent;

    public static Type<SlideHandler> getType() {
        return TYPE;
    }

    public SlideEvent() {
        this(null);
    }

    public SlideEvent(final NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    @Override
    public final Type<SlideHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final SlideHandler handler) {
        handler.onSlide(this);
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
