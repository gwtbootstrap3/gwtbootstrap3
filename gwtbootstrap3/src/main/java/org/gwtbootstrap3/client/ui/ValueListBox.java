package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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


import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SimpleKeyProvider;

/**
 * Implementation of {@link HasConstrainedValue} based on a
 * {@link com.google.gwt.dom.client.SelectElement}.
 * <p/>
 * A {@link Renderer Renderer<T>} is used to get user-presentable strings to
 * display in the select element.
 *
 * @param <T> the value type
 */
public class ValueListBox<T> extends com.google.gwt.user.client.ui.ValueListBox<T> implements HasName {

    public ValueListBox(final Renderer<T> renderer) {
        this(renderer, new SimpleKeyProvider<T>());
    }

    public ValueListBox(final Renderer<T> renderer, final ProvidesKey<T> keyProvider) {
        super(renderer, keyProvider);
    }

    @Override
    protected void initWidget(final Widget widget) {
        super.initWidget(new ListBox());
    }

	@Override
	public void setName(String name) {
		((ListBox) getWidget()).setName(name);
	}

	@Override
	public String getName() {
		return ((ListBox) getWidget()).getName();
	}
}
