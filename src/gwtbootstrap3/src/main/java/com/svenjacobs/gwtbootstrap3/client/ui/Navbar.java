package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.NavbarType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see NavbarBrand
 * @see NavbarNav
 * @see NavbarForm
 * @see NavbarText
 */
public class Navbar extends FlowPanel implements HasType<NavbarType> {

    public Navbar() {
        setStyleName(Styles.NAVBAR);
    }

    @Override
    public void setType(final NavbarType type) {
        StyleHelper.addUniqueEnumStyleName(this, NavbarType.class, type);
    }

    @Override
    public NavbarType getType() {
        return NavbarType.fromStyleName(getStyleName());
    }
}
