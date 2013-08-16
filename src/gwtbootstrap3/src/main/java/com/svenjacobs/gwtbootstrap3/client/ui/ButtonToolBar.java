package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Combines multiple button groups.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:ButtonToolBar>
 *         <b:ButtonGroup>
 *             <b:Button>Button 1</b:Button>
 *             <b:Button>Button 2</b:Button>
 *         </b:ButtonGroup>
 *         <b:ButtonGroup>
 *             <b:Button>Button 3</b:Button>
 *             <b:Button>Button 4</b:Button>
 *         </b:ButtonGroup>
 *     </b:ButtonToolBar>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see ButtonGroup
 */
public class ButtonToolBar extends FlowPanel {

    public ButtonToolBar() {
        setStyleName(Styles.BTN_TOOLBAR);
    }
}
