package com.svenjacobs.gwtbootstrap3.client.ui.base;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * Simple text node.
 *
 * @author Sven Jacobs
 */
public class Text extends Widget implements HasText {

    private final com.google.gwt.dom.client.Text text;

    public Text() {
        this("");
    }

    public Text(final String txt) {
        text = Document.get().createTextNode(txt);
        setElement(text.<Element>cast());
    }

    @Override
    public void setText(final String txt) {
        text.setData(txt);
    }

    @Override
    public String getText() {
        return text.getData();
    }
}
