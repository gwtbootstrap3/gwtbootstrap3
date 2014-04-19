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

import org.gwtbootstrap3.client.ui.base.mixin.DataSpyMixin;
import org.gwtbootstrap3.client.ui.base.mixin.DataTargetMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.Spy;

/**
 * @author Sven Jacobs
 */
public class FlowPanel extends com.google.gwt.user.client.ui.FlowPanel implements HasDataSpy, HasId, HasDataTarget {

    private final DataSpyMixin<FlowPanel> spyMixin = new DataSpyMixin<FlowPanel>(this);
    private final IdMixin<FlowPanel> idMixin = new IdMixin<FlowPanel>(this);
    private final DataTargetMixin<FlowPanel> targetMixin = new DataTargetMixin<FlowPanel>(this);

    @Override
    public void setDataSpy(final Spy spy) {
        spyMixin.setDataSpy(spy);
    }

    @Override
    public Spy getDataSpy() {
        return spyMixin.getDataSpy();
    }

    @Override
    public void setDataTarget(final String dataTarget) {
        targetMixin.setDataTarget(dataTarget);
    }

    @Override
    public String getDataTarget() {
        return targetMixin.getDataTarget();
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
