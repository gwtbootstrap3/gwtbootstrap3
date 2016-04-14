package org.gwtbootstrap3.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2016 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * Base class for list items.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.ListItem
 * @see org.gwtbootstrap3.client.ui.AnchorListItem
 * @see org.gwtbootstrap3.client.ui.ListDropDown
 */
public abstract class AbstractListItem extends ComplexWidget implements HasEnabled, HasPull, HasActive,
        HasResponsiveness, HasId {

    private final ActiveMixin<AbstractListItem> activeMixin = new ActiveMixin<AbstractListItem>(this);
    private final PullMixin<AbstractListItem> pullMixin = new PullMixin<AbstractListItem>(this);
    private final IdMixin<AbstractListItem> idMixin = new IdMixin<AbstractListItem>(this);
    private final EnabledMixin<AbstractListItem> enabledMixin = new EnabledMixin<AbstractListItem>(this);

    protected AbstractListItem() {
        setElement(Document.get().createLIElement());
    }

    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return !StyleHelper.containsStyle(getStyleName(), Styles.DISABLED);
    }

    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }

    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
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
