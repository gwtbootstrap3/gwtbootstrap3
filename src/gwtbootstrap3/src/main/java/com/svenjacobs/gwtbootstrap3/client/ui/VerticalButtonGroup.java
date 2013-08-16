package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractButtonGroup;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Vertical button group
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:VerticalButtonGroup>
 *         <b:Button>Button 1</b:Button>
 *         <b:Button>Button 2</b:Button>
 *         <b:Button>Button 3</b:Button>
 *     </b:VerticalButtonGroup>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see Button
 * @see ButtonGroup
 */
public class VerticalButtonGroup extends AbstractButtonGroup {

    public VerticalButtonGroup() {
        super(Styles.BTN_GROUP_VERTICAL);
    }
}
