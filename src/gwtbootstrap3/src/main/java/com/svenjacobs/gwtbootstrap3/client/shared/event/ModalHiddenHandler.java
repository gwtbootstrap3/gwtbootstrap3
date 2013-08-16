package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Sven Jacobs
 */
public interface ModalHiddenHandler extends EventHandler {
    void onHidden(final ModalHiddenEvent evt);
}
