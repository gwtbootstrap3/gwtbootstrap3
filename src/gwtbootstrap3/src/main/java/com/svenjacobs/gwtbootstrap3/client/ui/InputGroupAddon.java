package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.HasText;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractInputGroupAddon;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Prepends or appends texts to input fields.
 * <p/>
 * For prepending/appending {@link Button} see {@link InputGroupButton}.
 * Needs to be encapsulated in an {@link InputGroup}.
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:InputGroup>
 *         <b:InputGroupAddon>Prepend something</b:InputGroupAddon>
 *         <b:TextBox/>
 *         <b:InputGroupAddon>Append something</b:InputGroupAddon>
 *     </b:InputGroup>
 * }</pre>
 * <p/>
 * Also see Bootstrap <a href="http://getbootstrap.com/components/#input-groups">documentation</a>.
 *
 * @author Sven Jacobs
 * @see InputGroup
 * @see InputGroupButton
 */
public class InputGroupAddon extends AbstractInputGroupAddon implements HasText {

    public InputGroupAddon() {
        super(Styles.INPUT_GROUP_ADDON);
    }

    @Override
    public String getText() {
        return getElement().getInnerText();
    }

    @Override
    public void setText(final String text) {
        getElement().setInnerText(text);
    }
}
