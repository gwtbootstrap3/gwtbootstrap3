package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractLabelButton;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Button representing a radio box.
 * <p/>
 * Used within a {@link com.svenjacobs.gwtbootstrap3.client.ui.ButtonGroup} that has toggle set to {@code Toogle.BUTTONS}.
 *
 * @author Sven Jacobs
 */
public class RadioButton extends AbstractLabelButton {

    public RadioButton() {
        super(TypeAttrType.RADIO);
    }
}
