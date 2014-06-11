package org.gwtbootstrap3.client.ui;

import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SimpleKeyProvider;

/**
 * Implementation of {@link HasConstrainedValue} based on a
 * {@link com.google.gwt.dom.client.SelectElement}.
 * <p>
 * A {@link Renderer Renderer<T>} is used to get user-presentable strings to
 * display in the select element.
 * 
 * @param <T>
 *            the value type
 */
public class ValueListBox<T> extends com.google.gwt.user.client.ui.ValueListBox<T> {

	public ValueListBox(Renderer<T> renderer) {
		this(renderer, new SimpleKeyProvider<T>());
	}

	public ValueListBox(Renderer<T> renderer, ProvidesKey<T> keyProvider) {
		super(renderer, keyProvider);
	}
	
	@Override
	protected void initWidget(Widget widget) {
	    super.initWidget(new ListBox());
	}

}
