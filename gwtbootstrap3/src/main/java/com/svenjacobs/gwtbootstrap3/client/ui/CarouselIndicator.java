package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class CarouselIndicator extends ComplexWidget {

    public CarouselIndicator() {
        setElement(DOM.createElement("li"));
    }

    public void setDataTarget(String dataTarget) {
        getElement().setAttribute("data-target", dataTarget);
    }

    public void setDataSlideTo(String dataSlideTo) {
        getElement().setAttribute("data-slide-to", dataSlideTo);
    }

    public void setActive(boolean active) {
        StyleHelper.toggleStyleName(this, active, Styles.ACTIVE);
    }
}
