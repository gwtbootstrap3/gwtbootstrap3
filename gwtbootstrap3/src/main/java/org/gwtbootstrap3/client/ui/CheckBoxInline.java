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

import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;

/**
 * An inline check box widget.
 * 
 * <p>
 * <h3>Built-in Bidi Text Support</h3>
 * This widget is capable of automatically adjusting its direction according to
 * its content. This feature is controlled by {@link #setDirectionEstimator} or
 * passing a DirectionEstimator parameter to the constructor, and is off by
 * default.
 * </p>
 */
public class CheckBoxInline extends CheckBox {

	/**
	 * Creates a check box with no label.
	 */
	public CheckBoxInline() {
		super(DOM.createInputCheck(), true);
		setStyleName(Styles.CHECKBOX_INLINE);
	}

	/**
	 * Creates a check box with the specified text label.
	 * 
	 * @param label
	 *            the check box's label
	 */
	public CheckBoxInline(SafeHtml label) {
		this(label.asString(), true);
	}

	/**
	 * Creates a check box with the specified text label.
	 * 
	 * @param label
	 *            the check box's label
	 * @param dir
	 *            the text's direction. Note that {@code DEFAULT} means
	 *            direction should be inherited from the widget's parent
	 *            element.
	 */
	public CheckBoxInline(SafeHtml label, Direction dir) {
		this();
		setHTML(label, dir);
	}

	/**
	 * Creates a check box with the specified text label.
	 * 
	 * @param label
	 *            the check box's label
	 * @param directionEstimator
	 *            A DirectionEstimator object used for automatic direction
	 *            adjustment. For convenience,
	 *            {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
	 */
	public CheckBoxInline(SafeHtml label, DirectionEstimator directionEstimator) {
		this();
		setDirectionEstimator(directionEstimator);
		setHTML(label);
	}

	/**
	 * Creates a check box with the specified text label.
	 * 
	 * @param label
	 *            the check box's label
	 */
	public CheckBoxInline(String label) {
		this();
		setText(label);
	}

	/**
	 * Creates a check box with the specified text label.
	 * 
	 * @param label
	 *            the check box's label
	 * @param dir
	 *            the text's direction. Note that {@code DEFAULT} means
	 *            direction should be inherited from the widget's parent
	 *            element.
	 */
	public CheckBoxInline(String label, Direction dir) {
		this();
		setText(label, dir);
	}

	/**
	 * Creates a label with the specified text and a default direction
	 * estimator.
	 * 
	 * @param label
	 *            the check box's label
	 * @param directionEstimator
	 *            A DirectionEstimator object used for automatic direction
	 *            adjustment. For convenience,
	 *            {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
	 */
	public CheckBoxInline(String label, DirectionEstimator directionEstimator) {
		this();
		setDirectionEstimator(directionEstimator);
		setText(label);
	}

	/**
	 * Creates a check box with the specified text label.
	 * 
	 * @param label
	 *            the check box's label
	 * @param asHTML
	 *            <code>true</code> to treat the specified label as html
	 */
	public CheckBoxInline(String label, boolean asHTML) {
		this();
		if (asHTML) {
			setHTML(label);
		} else {
			setText(label);
		}
	}

}
