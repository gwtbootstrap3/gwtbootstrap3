package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Element;
import com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;

/**
 * Button based on {@code <button>} element with different types and sizes.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:Button type="PRIMARY">Save</b:Button>
 *     <b:Button type="DANGER">Delete</b:Button>
 *     <b:Button type="INFO" block="true>I'm a block level button</b:Button>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractToggleButton
 * @see SubmitButton
 */
public class Button extends AbstractToggleButton {

    /**
     * Creates button with DEFAULT type.
     */
    public Button() {
    }

    /**
     * Creates button with specified text
     *
     * @param text Text contents of button
     */
    public Button(final String text) {
        setText(text);
    }

    @Override
    protected Element createElement() {
        return Document.get().createPushButtonElement().cast();
    }
}
