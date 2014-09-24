package org.gwtbootstrap3.client.ui.impl;

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

import org.gwtbootstrap3.client.ui.SimpleRadioButton;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.ui.SimpleCheckBox;

public class SimpleRadioButtonImplIE8 extends SimpleRadioButtonImpl {
	
	private static class Handler implements ClickHandler, MouseUpHandler, BlurHandler, KeyDownHandler {

		private final SimpleCheckBox simpleRadioButton;
		private Boolean oldValue;
		
		public Handler(SimpleRadioButton simpleRadioButton) {
			this.simpleRadioButton = simpleRadioButton;
		}

		@Override
		public void onClick(ClickEvent event) {
			ValueChangeEvent.fireIfNotEqual(simpleRadioButton, oldValue,
					simpleRadioButton.getValue());
		}

		@Override
		public void onKeyDown(KeyDownEvent event) {
			oldValue = simpleRadioButton.getValue();
		}

		@Override
		public void onBlur(BlurEvent event) {
			oldValue = simpleRadioButton.getValue();
		}

		@Override
		public void onMouseUp(MouseUpEvent event) {
			oldValue = simpleRadioButton.getValue();
		}
		
	}
	
	@Override
	public void ensureDomEventHandlers(SimpleRadioButton simpleRadioButton) {
		Handler handler = new Handler(simpleRadioButton);
		simpleRadioButton.addClickHandler(handler);
		simpleRadioButton.addMouseUpHandler(handler);
		simpleRadioButton.addBlurHandler(handler);
		simpleRadioButton.addKeyDownHandler(handler);
	}
	
}
