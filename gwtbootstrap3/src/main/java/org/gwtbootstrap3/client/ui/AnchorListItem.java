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

import org.gwtbootstrap3.client.ui.base.AbstractAnchorListItem;

/**
 * @author Joshua Godi
 */
public class AnchorListItem extends AbstractAnchorListItem implements com.google.gwt.user.client.ui.HasText {

	public AnchorListItem() {
	}

	public AnchorListItem(final String text) {
		setText(text);
	}

	@Override
	public void setText(final String text) {
		anchor.setText(text);
	}

	@Override
	public String getText() {
		return anchor.getText();
	}

}
