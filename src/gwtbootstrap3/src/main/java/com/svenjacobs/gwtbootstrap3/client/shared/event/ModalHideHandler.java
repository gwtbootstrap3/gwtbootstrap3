package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Sven Jacobs
 */
public interface ModalHideHandler extends EventHandler {
    void onHide(final ModalHideEvent evt);
}
