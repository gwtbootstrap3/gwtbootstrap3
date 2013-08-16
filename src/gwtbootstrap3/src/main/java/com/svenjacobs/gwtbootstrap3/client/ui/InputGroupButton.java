package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractInputGroupAddon;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Prepends or appends buttons to input fields.
 * <p/>
 * For prepending/appending text see {@link InputGroupAddon}.
 * Needs to be encapsulated in an {@link InputGroup}.
 * <p/>
 * <strong>Note:</strong> This is not a button itself! A {@link Button} needs to be added to this container.
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:InputGroup>
 *         <b:InputGroupButton>
 *             <b:Button>Prepend</b:Button>
 *         </b:InputGroupButton>
 *         <b:TextBox/>
 *         <b:InputGroupButton>
 *             <b:Button>Append</b:Button>
 *         </b:InputGroupButton>
 *     </b:InputGroup>
 * }</pre>
 * <p/>
 * Also see Bootstrap <a href="http://getbootstrap.com/components/#input-groups">documentation</a>.
 *
 * @author Sven Jacobs
 * @see InputGroupAddon
 */
public class InputGroupButton extends AbstractInputGroupAddon {

    public InputGroupButton() {
        super(Styles.INPUT_GROUP_BTN);
    }

    @Override
    public void add(final Widget child) {
        add(child, getElement());
    }
}
