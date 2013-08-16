package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractListItem;
import com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Drop down item within a list, e.g. {@link NavTabs}, {@link NavPills} or {@link Navbar}.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:NavTabs>
 *         <b:ListItem active="true">Item 1</b:ListItem>
 *         <b:ListItem>Item 2</b:ListItem>
 *         <b:ListDropDown>
 *             <b:AnchorButton toggle="DROPDOWN">Dropdown</b:AnchorButton>
 *             <b:DropDownMenu>
 *                 <b:ListItem>Dropdown 1</b:ListItem>
 *                 <b:ListItem>Dropdown 2</b:ListItem>
 *                 <b:ListItem>Dropdown 3</b:ListItem>
 *             </b:DropDownMenu>
 *         </b:ListDropDown>
 *         <b:ListItem>Item 3</b:ListItem>
 *     </b:NavTabs>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see NavTabs
 * @see NavPills
 * @see Navbar
 */
public class ListDropDown extends AbstractListItem {

    public ListDropDown() {
        setStyleName(Styles.DROPDOWN);
    }

    @Override
    public void add(final Widget child) {
        if (child instanceof AbstractToggleButton) {
            if (!(child instanceof AnchorButton)) {
                throw new IllegalArgumentException("Only buttons of type AnchorButton can be added to ListDropDown");
            }

            child.setStyleName(Styles.DROPDOWN_TOGGLE);
        }

        add(child, getElement());
    }
}
