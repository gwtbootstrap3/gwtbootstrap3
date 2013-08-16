package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasHTML;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;

/**
 * @author Sven Jacobs
 */
public class Paragraph extends AbstractTextWidget implements HasHTML {

    public Paragraph() {
        super(DOM.createElement("p"));
    }

    @Override
    public String getHTML() {
        return getElement().getInnerHTML();
    }

    @Override
    public void setHTML(final String html) {
        getElement().setInnerHTML(html);
    }
}
