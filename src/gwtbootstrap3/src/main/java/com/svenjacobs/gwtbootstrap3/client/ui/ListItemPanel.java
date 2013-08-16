package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractAnchorListItem;

/**
 * A {@code <li>} list item that contains further widgets.
 * <p/>
 * Use it instead of a {@link ListItem} if you for example want to embed a {@link Nav} within a {@code <li>}.
 *
 * @author Sven Jacobs
 * @see ListItem
 */
public class ListItemPanel extends AbstractAnchorListItem {

    @Override
    public void add(final Widget child) {
        add(child, getElement());
    }

    public void setText(final String text) {
        anchor.setText(text);
    }
}
