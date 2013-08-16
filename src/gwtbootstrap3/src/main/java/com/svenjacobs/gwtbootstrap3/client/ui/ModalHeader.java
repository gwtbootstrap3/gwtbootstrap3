package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.base.button.CloseButton;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ButtonDismiss;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see Modal
 */
public class ModalHeader extends FlowPanel implements ModalComponent, IsClosable {

    private final Heading heading = new Heading(4);
    private final CloseButton closeButton = new CloseButton();

    public ModalHeader() {
        setStyleName(Styles.MODAL_HEADER);

        heading.setStyleName(Styles.MODAL_TITLE);
        closeButton.setDismiss(ButtonDismiss.MODAL);

        add(closeButton);
    }

    public void setTitle(final String title) {
        heading.setText(title);

        if (heading.getParent() == null) {
            add(heading);
        }
    }

    @Override
    public void setClosable(final boolean closable) {
        if (closable) {
            insert(closeButton, getElement(), 0, true);
        } else {
            closeButton.removeFromParent();
        }
    }

    @Override
    public boolean isClosable() {
        return closeButton.getParent() != null;
    }
}
