package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.ui.Modal;

/**
 * @author Sven Jacobs
 */
public interface ModalEvent {
    Modal getModal();

    Event getNativeEvent();
}
