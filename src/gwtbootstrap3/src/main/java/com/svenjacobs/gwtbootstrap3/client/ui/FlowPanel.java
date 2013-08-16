package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.SpyMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.TargetMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Spy;

/**
 * @author Sven Jacobs
 */
public class FlowPanel extends com.google.gwt.user.client.ui.FlowPanel implements HasSpy, HasId, HasTarget {

    private final SpyMixin spyMixin = new SpyMixin(this);
    private final IdMixin idMixin = new IdMixin(this);
    private final TargetMixin targetMixin = new TargetMixin(this);

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

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }
}
