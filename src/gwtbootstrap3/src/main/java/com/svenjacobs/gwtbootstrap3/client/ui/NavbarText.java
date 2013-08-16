package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Pull;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see NavbarLink
 */
public class NavbarText extends HTMLPanel implements HasPull {

    public NavbarText() {
        super("p", "");
        setStyleName(Styles.NAVBAR_TEXT);
    }

    public NavbarText(final String html) {
        this();
        getElement().setInnerHTML(html);
    }

    @Override
    public void setPull(final Pull pull) {
        StyleHelper.addUniqueEnumStyleName(this, Pull.class, pull);
    }

    @Override
    public Pull getPull() {
        return Pull.fromStyleName(getStyleName());
    }

    @Override
    public void add(final Widget child) {
        add(child, getElement());
    }
}
