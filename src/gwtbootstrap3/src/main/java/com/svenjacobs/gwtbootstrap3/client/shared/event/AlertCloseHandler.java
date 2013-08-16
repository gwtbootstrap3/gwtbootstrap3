package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Sven Jacobs
 */
public interface AlertCloseHandler extends EventHandler {
    void onClose(final AlertCloseEvent evt);
}
