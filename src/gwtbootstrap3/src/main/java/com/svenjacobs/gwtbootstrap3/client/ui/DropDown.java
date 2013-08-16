package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractDropDown;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Dropdown parent container.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:DropDown>
 *         <b:Anchor toggle="DROPDOWN">Click to toggle dropdown</b:Anchor>
 *         <b:DropDownMenu>
 *             <b:ListItem>Action 1</b:ListItem>
 *             <b:ListItem>Action 2</b:ListItem>
 *         </b:DropDownMenu>
 *     </b:DropDown>
 * }</pre>
 * @author Sven Jacobs
 * @see DropDownMenu
 */
public class DropDown extends AbstractDropDown {

    public DropDown() {
        super(DOM.createDiv());
        setStyleName(Styles.DROPDOWN);
    }
}
