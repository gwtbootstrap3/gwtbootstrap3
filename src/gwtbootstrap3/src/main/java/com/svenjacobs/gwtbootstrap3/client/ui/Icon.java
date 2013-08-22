package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.IconType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Simple put, an icon.
 *
 * @author Sven Jacobs
 * @see IconType
 */
public class Icon extends Widget implements HasType<IconType> {

    public Icon() {
        setElement(DOM.createSpan());
        setStyleName(Styles.GLYPHICON);
    }

    public Icon(final IconType type) {
        this();
        setType(type);
    }

    @Override
    public void setType(final IconType type) {
        StyleHelper.addUniqueEnumStyleName(this, IconType.class, type);
    }

    @Override
    public IconType getType() {
        return IconType.fromStyleName(getStyleName());
    }
}
