package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Element;

/**
 * A {@link Button} with {@code type="submit"}.
 *
 * @author Sven Jacobs
 * @see Button
 */
public class SubmitButton extends Button {

    @Override
    protected Element createElement() {
        return Document.get().createSubmitButtonElement().cast();
    }
}
