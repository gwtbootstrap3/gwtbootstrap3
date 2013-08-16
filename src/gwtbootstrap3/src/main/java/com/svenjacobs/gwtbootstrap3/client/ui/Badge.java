package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Pull;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Badge for highlighting new or unread items.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:Badge>42</b:Badge>
 * }</pre>
 *
 * @author Sven Jacobs
 */
public class Badge extends AbstractTextWidget implements HasPull {

    private final PullMixin pullMixin = new PullMixin(this);

    public Badge() {
        super(DOM.createSpan());
        setStyleName(Styles.BADGE);
    }

    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }
}
