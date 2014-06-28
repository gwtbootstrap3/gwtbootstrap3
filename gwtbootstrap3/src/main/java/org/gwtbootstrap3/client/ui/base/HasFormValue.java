package org.gwtbootstrap3.client.ui.base;

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

/**
 * Interface for Widgets that can be put into a {@link org.gwtbootstrap3.client.ui.Form} and can have a form value,
 * which is the "value" attribute of the element that is passed to the form's receiver on submit.
 * <p/>
 * Not to be confused with {@link com.google.gwt.user.client.ui.HasValue}.
 *
 * @author Sven Jacobs
 */
public interface HasFormValue {

    String getFormValue();

    void setFormValue(final String value);
}
