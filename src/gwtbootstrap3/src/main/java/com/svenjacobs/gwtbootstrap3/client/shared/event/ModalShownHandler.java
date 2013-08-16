package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Sven Jacobs
 */
public interface ModalShownHandler extends EventHandler {
    void onShown(final ModalShownEvent evt);
}
