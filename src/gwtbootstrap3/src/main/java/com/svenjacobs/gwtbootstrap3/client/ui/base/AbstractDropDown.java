package com.svenjacobs.gwtbootstrap3.client.ui.base;

import com.google.gwt.user.client.Element;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 */
public class AbstractDropDown extends ComplexWidget {

    public AbstractDropDown(final Element element) {
        setElement(element);
        setStyleName(Styles.DROPDOWN);
    }
}
