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

import com.google.gwt.dom.client.Document;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.TargetMixin;
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class CarouselControl extends ComplexWidget implements HasTarget {
    private final TargetMixin<CarouselControl> targetMixin = new TargetMixin<CarouselControl>(this);

    private final Icon icon = new Icon();

    public CarouselControl() {
        setElement(Document.get().createAnchorElement());
        setStyleName(Styles.CAROUSEL_CONTROL);

        add(icon);
    }

    public void setIconType(final IconType iconType) {
        icon.setType(iconType);
    }

    public void setPrev(final boolean prev) {
        getElement().removeAttribute(Attributes.DATA_SLIDE);
        getElement().setAttribute(Attributes.DATA_SLIDE, Carousel.PREV);
        StyleHelper.toggleStyleName(this, prev, Styles.LEFT);
        icon.addStyleName(Styles.ICON_PREV);
    }

    public void setNext(final boolean next) {
        getElement().removeAttribute(Attributes.DATA_SLIDE);
        getElement().setAttribute(Attributes.DATA_SLIDE, Carousel.NEXT);
        StyleHelper.toggleStyleName(this, next, Styles.RIGHT);
        icon.addStyleName(Styles.ICON_NEXT);
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
