package org.gwtbootstrap3.client.ui.base;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;

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
 * @author Sven Jacobs
 */
public interface HasDataTarget {

    void setDataTargetWidget(Widget widget);

    void setDataTargetWidgets(List<Widget> widget);

    /**
     * Sets the data target for the widget
     *
     * @param dataTarget data target string
     */
    void setDataTarget(String dataTarget);

    /**
     * Gets the data target of the widget
     *
     * @return data target
     */
    String getDataTarget();
}
