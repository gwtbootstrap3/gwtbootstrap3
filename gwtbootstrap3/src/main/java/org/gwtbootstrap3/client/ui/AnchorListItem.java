package org.gwtbootstrap3.client.ui;

import org.gwtbootstrap3.client.ui.base.AbstractAnchorListItem;

/**
 * @author Joshua Godi
 */
public class AnchorListItem extends AbstractAnchorListItem implements com.google.gwt.user.client.ui.HasText {

    public AnchorListItem() {
    }

    public AnchorListItem(final String text) {
        setText(text);
    }

    @Override
    public void setText(final String text) {
        anchor.setText(text);
    }

    @Override
    public String getText() {
        return anchor.getText();
    }
}
