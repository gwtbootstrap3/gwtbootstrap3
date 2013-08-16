package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractButtonGroup;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Button group containing multiple buttons.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:ButtonGroup>
 *         <b:Button>Button 1</b:Button>
 *         <b:Button>Button 2</b:Button>
 *         <b:Button>Button 3</b:Button>
 *     </b:ButtonGroup>
 * }</pre>
 * <p/>
 * Is also a container for dropdown buttons:
 * <pre>{@code
 *     <b:ButtonGroup>
 *         <b:Button toggle="DROPDOWN">Dropdown</b:Button>
 *         <b:DropDownMenu>
 *             <b:ListItem>ListItem 1</b:ListItem>
 *             <b:ListItem>ListItem 2</b:ListItem>
 *             <b:ListItem>ListItem 3</b:ListItem>
 *         </b:DropDownMenu>
 *     </b:ButtonGroup>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see Button
 * @see VerticalButtonGroup
 */
public class ButtonGroup extends AbstractButtonGroup {

    public ButtonGroup() {
        super(Styles.BTN_GROUP);
    }
}
