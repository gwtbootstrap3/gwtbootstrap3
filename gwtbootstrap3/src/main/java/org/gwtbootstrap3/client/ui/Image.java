package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.base.HasPull;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.ImageType;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeUri;

/**
 * @author Joshua Godi
 */
public class Image extends com.google.gwt.user.client.ui.Image implements HasType<ImageType>, HasResponsiveness,
        HasPull {

    private final PullMixin<Image> pullMixin = new PullMixin<Image>(this);

    public Image() {
        super();
        setStyleName("");
    }

    public Image(final ImageResource resource) {
        super(resource);
        setStyleName("");
    }

    public Image(final SafeUri url, final int left, final int top, final int width, final int height) {
        super(url, left, top, width, height);
        setStyleName("");
    }

    public Image(final SafeUri url) {
        super(url);
        setStyleName("");
    }

    public Image(final String url, final int left, final int top, final int width, final int height) {
        super(url, left, top, width, height);
        setStyleName("");
    }

    public Image(final String url) {
        super(url);
        setStyleName("");
    }

    @Override
    public void setType(final ImageType type) {
        StyleHelper.addEnumStyleName(this, type);
    }

    @Override
    public ImageType getType() {
        return ImageType.fromStyleName(getStyleName());
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    public void setResponsive(final boolean responsive) {
        StyleHelper.toggleStyleName(this, responsive, Styles.IMG_RESPONSIVE);
    }

    public void setAsMediaObject(final boolean asMediaObject) {
        StyleHelper.toggleStyleName(this, asMediaObject, Styles.MEDIA_OBJECT);
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
