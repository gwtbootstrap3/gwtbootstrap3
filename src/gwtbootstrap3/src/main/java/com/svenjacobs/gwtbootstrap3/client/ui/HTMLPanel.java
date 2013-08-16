package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.SpyMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.TargetMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Spy;

/**
 * @author Sven Jacobs
 */
public class HTMLPanel extends com.google.gwt.user.client.ui.HTMLPanel implements HasSpy, HasTarget {

    private final SpyMixin spyMixin = new SpyMixin(this);
    private final TargetMixin targetMixin = new TargetMixin(this);

    public HTMLPanel(final String html) {
        super(html);
    }

    public HTMLPanel(final SafeHtml safeHtml) {
        super(safeHtml);
    }

    public HTMLPanel(final String tag, final String html) {
        super(tag, html);
    }

    @Override
    public void setSpy(final Spy spy) {
        spyMixin.setSpy(spy);
    }

    @Override
    public Spy getSpy() {
        return spyMixin.getSpy();
    }

    @Override
    public void setTarget(final String target) {
        targetMixin.setTarget(target);
    }

    @Override
    public String getTarget() {
        return targetMixin.getTarget();
    }
}
