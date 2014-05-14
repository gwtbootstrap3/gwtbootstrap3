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
 * @author Sven Jacobs
 */
public interface HasHref {
    // Empty HREF to avoid issues when clicking!
    public static final String EMPTY_HREF = "javascript:;";
    public static final String HREF = "href";

    /**
     * Set's the HREF of the widget
     *
     * @param href String href
     */
    void setHref(String href);

    /**
     * Get the HREF of the widget
     *
     * @return String href
     */
    String getHref();
}
