package com.svenjacobs.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 Sven Jacobs
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
 * Interface to set the visibility and hidden properties of elements
 * <p/>
 * Example:
 * <p/>
 * hiddenOn="SM MD"
 * visibleOn="SM LG"
 * hiddenOn="LG"
 *
 * @author Joshua Godi
 */
public interface HasResponsiveness {
    /**
     * Sets the devices that the element is visible on
     *
     * @param deviceSizeString space separated list of device sizes
     * @see com.svenjacobs.gwtbootstrap3.client.ui.constants.DeviceSize
     */
    void setVisibleOn(String deviceSizeString);

    /**
     * Sets the devices that the element is hidden on
     *
     * @param deviceSizeString space separated list of device sizes
     * @see com.svenjacobs.gwtbootstrap3.client.ui.constants.DeviceSize
     */
    void setHiddenOn(String deviceSizeString);
}
