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

import com.google.gwt.safehtml.shared.SafeHtml;
import org.gwtbootstrap3.client.ui.base.mixin.SpyMixin;
import org.gwtbootstrap3.client.ui.base.mixin.TargetMixin;
import org.gwtbootstrap3.client.ui.constants.Spy;

/**
 * @author Sven Jacobs
 */
public class HTMLPanel extends com.google.gwt.user.client.ui.HTMLPanel implements HasSpy, HasTarget {

    private final SpyMixin<HTMLPanel> spyMixin = new SpyMixin<HTMLPanel>(this);
    private final TargetMixin<HTMLPanel> targetMixin = new TargetMixin<HTMLPanel>(this);

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
