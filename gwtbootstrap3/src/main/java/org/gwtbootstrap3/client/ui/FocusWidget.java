package org.gwtbootstrap3.client.ui;

import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasPull;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Styles;
import com.google.gwt.dom.client.Element;

public abstract class FocusWidget extends com.google.gwt.user.client.ui.FocusWidget implements HasResponsiveness,
        HasId, HasPull {

    private final IdMixin<FocusWidget> idMixin = new IdMixin<FocusWidget>(this);
    private final PullMixin<FocusWidget> pullMixin = new PullMixin<FocusWidget>(this);

    public FocusWidget(Element elem) {
        super(elem);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            removeStyleName(Styles.DISABLED);
        } else {
            addStyleName(Styles.DISABLED);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return idMixin.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }

}
