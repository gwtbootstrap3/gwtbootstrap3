package com.svenjacobs.gwtbootstrap3.client.ui.base.button;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Element;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Button that represents a close ("x") icon, usually used within an {@link com.svenjacobs.gwtbootstrap3.client.ui.Alert}.
 *
 * @author Sven Jacobs
 * @see com.svenjacobs.gwtbootstrap3.client.ui.Alert
 */
public class CloseButton extends AbstractButton {

    public CloseButton() {
        setStyleName(Styles.CLOSE);
        getElement().setInnerHTML("&times;");
    }

    @Override
    protected Element createElement() {
        return Document.get().createPushButtonElement().cast();
    }
}
