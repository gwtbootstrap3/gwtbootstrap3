package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.constants.Placement;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Trigger;

/**
 * @author Joshua Godi
 */
public interface HasHover {
    void setIsAnimated(boolean isAnimated);

    boolean isAnimated();

    void setIsHtml(boolean isHtml);

    boolean isHtml();

    void setPlacement(Placement placement);

    Placement getPlacement();

    void setTrigger(Trigger trigger);

    Trigger getTrigger();

    void setShowDelayMs(int showDelayMs);

    int getShowDelayMs();

    void setHideDelayMs(int hideDelayMs);

    int getHideDelayMs();

    void setContainer(String container);

    String getContainer();
}
