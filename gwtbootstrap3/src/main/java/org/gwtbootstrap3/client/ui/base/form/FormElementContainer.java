package org.gwtbootstrap3.client.ui.base.form;

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

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class for {@link org.gwtbootstrap3.client.ui.Form} related
 * widgets that may contain form input elements.
 * <p/>
 * Input elements styleName is adjusted during
 * {@link #add(com.google.gwt.user.client.ui.Widget)}.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Steven Jardine
 */
public abstract class FormElementContainer extends ComplexPanel implements HasResponsiveness {

    /** {@inheritDoc} */
    @Override
    public void add(final Widget w) {
        if (w instanceof ListBox || w instanceof FileUpload) {
            w.addStyleName(Styles.FORM_CONTROL);
        }
        add(w, (Element) getElement());
    }

    /**
     * Get this forms child input elements with validators.
     *
     * @param widget the widget
     * @return the children with validators
     */
    protected List<HasValidators<?>> getChildrenWithValidators(Widget widget) {
        List<HasValidators<?>> result = new ArrayList<HasValidators<?>>();
        if (widget != null) {
            if (widget instanceof HasValidators<?>) {
                result.add((HasValidators<?>) widget);
            }
            if (widget instanceof HasWidgets) {
                for (Widget child : (HasWidgets) widget) {
                    result.addAll(getChildrenWithValidators(child));
                }
            }
        }
        return result;
    }

    /**
     * Reset the form's child input elements.
     */
    public void reset() {
        for (HasValidators<?> child : getChildrenWithValidators(this)) {
            child.reset();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /**
     * @return true if the child input elements are all valid.
     */
    public boolean validate() {
        return validate(true);
    }

    /**
     * @return true if the child input elements are all valid.
     */
    public boolean validate(boolean show) {
        boolean result = true;
        for (HasValidators<?> child : getChildrenWithValidators(this)) {
            result &= child.validate(show);
        }
        return result;
    }

}
