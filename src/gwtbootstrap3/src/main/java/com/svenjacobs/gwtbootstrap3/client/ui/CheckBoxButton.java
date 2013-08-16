package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractLabelButton;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Button representing a checkbox.
 * <p/>
 * Used within a {@link ButtonGroup} that has toggle set to {@code Toogle.BUTTONS}.
 *
 * @author Sven Jacobs
 */
public class CheckBoxButton extends AbstractLabelButton {

    public CheckBoxButton() {
        super(TypeAttrType.CHECKBOX);
    }
}
