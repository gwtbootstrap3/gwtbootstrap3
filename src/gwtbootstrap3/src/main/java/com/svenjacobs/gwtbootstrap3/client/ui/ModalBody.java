package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see Modal
 */
public class ModalBody extends FlowPanel implements ModalComponent {

    public ModalBody() {
        setStyleName(Styles.MODAL_BODY);
    }
}
