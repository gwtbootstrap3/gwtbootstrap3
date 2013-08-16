package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see Modal
 */
public class ModalFooter extends FlowPanel implements ModalComponent {

    public ModalFooter() {
        setStyleName(Styles.MODAL_FOOTER);
    }
}
