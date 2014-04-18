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
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.base.mixin.TargetMixin;
import org.gwtbootstrap3.client.ui.constants.Attributes;

/**
 * @author Joshua Godi
 */
public class CarouselIndicator extends ComplexWidget implements HasTarget, HasActive {

    private final TargetMixin<CarouselIndicator> targetMixin = new TargetMixin<CarouselIndicator>(this);
    private final ActiveMixin<CarouselIndicator> activeMixin = new ActiveMixin<CarouselIndicator>(this);

    public CarouselIndicator() {
        setElement(Document.get().createLIElement());
    }

    public void setDataSlideTo(final String dataSlideTo) {
        getElement().setAttribute(Attributes.DATA_SLIDE_TO, dataSlideTo);
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
    public void setTarget(final String target) {
        targetMixin.setTarget(target);
    }

    @Override
    public String getTarget() {
        return targetMixin.getTarget();
    }
}
