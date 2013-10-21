package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.uibinder.client.UiConstructor;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class LinkedGroupItemHeading extends Heading {

    @UiConstructor
    public LinkedGroupItemHeading(int size) {
        super(size);
        setStyleName(Styles.LIST_GROUP_ITEM_HEADING);
    }
}
