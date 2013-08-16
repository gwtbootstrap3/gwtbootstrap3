package com.svenjacobs.gwtbootstrap3.client.ui.base;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.svenjacobs.gwtbootstrap3.client.ui.Anchor;
import com.svenjacobs.gwtbootstrap3.client.ui.HasHref;
import com.svenjacobs.gwtbootstrap3.client.ui.HasTargetHistoryToken;

/**
 * Base class for list items that contain an {@link Anchor} link.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractAnchorListItem extends AbstractListItem implements HasHref, HasTargetHistoryToken, HasClickHandlers {

    protected final Anchor anchor;

    protected AbstractAnchorListItem() {
        anchor = new Anchor();
        add(anchor, getElement());
    }

    @Override
    public void setHref(final String href) {
        anchor.setHref(href);
    }

    @Override
    public String getHref() {
        return anchor.getHref();
    }

    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        anchor.setTargetHistoryToken(targetHistoryToken);
    }

    @Override
    public String getTargetHistoryToken() {
        return anchor.getTargetHistoryToken();
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return anchor.addClickHandler(handler);
    }
}
