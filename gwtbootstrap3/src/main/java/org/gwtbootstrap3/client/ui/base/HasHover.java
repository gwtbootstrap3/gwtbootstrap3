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

import org.gwtbootstrap3.client.ui.constants.Placement;
import org.gwtbootstrap3.client.ui.constants.Trigger;

/**
 * @author Joshua Godi
 */
public interface HasHover {
    /**
     * Set whether or not to animate the displaying of the hover widget
     *
     * @param isAnimated boolean to animate or not
     */
    void setIsAnimated(boolean isAnimated);

    /**
     * Get whether or not the hover widget will be animated
     *
     * @return boolean true = animated, false = not animated
     */
    boolean isAnimated();

    /**
     * Set to make the hover widget display HTML code
     *
     * @param isHtml boolean to render HTML code or not
     */
    void setIsHtml(boolean isHtml);

    /**
     * Get whether or not the hover widget will render HTML
     *
     * @return boolean true = render HTML, false = don't render HTML
     */
    boolean isHtml();

    /**
     * Sets the placement of the hover component
     *
     * @param placement Placement of the hover component
     */
    void setPlacement(Placement placement);

    /**
     * Get the Placement of the hover component
     *
     * @return Placement of the hover component
     */
    Placement getPlacement();

    /**
     * Set what will trigger the showing of the hover component
     *
     * @param trigger Trigger how the hover component will show
     */
    void setTrigger(Trigger trigger);

    /**
     * Get the hover component's trigger
     *
     * @return Trigger how the hover component will show
     */
    Trigger getTrigger();

    /**
     * Set the delay in MS that the hover component takes to display
     *
     * @param showDelayMs int number of MS to delay the display
     */
    void setShowDelayMs(int showDelayMs);

    /**
     * Get the delay in MS to show the hover component
     *
     * @return int delay in MS
     */
    int getShowDelayMs();

    /**
     * Set the delay in MS that the hover component takes to hide
     *
     * @param hideDelayMs int number of MS to delay the hide
     */
    void setHideDelayMs(int hideDelayMs);

    /**
     * Get the delay in MS to hide the hover component
     *
     * @return int delay in MS
     */
    int getHideDelayMs();

    /**
     * Sets the custom container that the hover's HTML will render in
     *
     * @param container String selector of where to render the hover's HTML code
     */
    void setContainer(String container);

    /**
     * Get where the hover will render it's HTML code
     *
     * @return String selector where the hover renders to
     */
    String getContainer();
}
