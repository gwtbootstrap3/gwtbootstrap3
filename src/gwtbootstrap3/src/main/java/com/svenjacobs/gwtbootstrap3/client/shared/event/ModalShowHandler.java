package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Sven Jacobs
 */
public interface ModalShowHandler extends EventHandler {
    void onShow(final ModalShowEvent evt);
}
