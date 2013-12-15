package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class CarouselSlide extends Div {
    public CarouselSlide() {
        setStyleName(Styles.ITEM);
    }

    public void setActive(boolean active) {
        StyleHelper.toggleStyleName(this, active, Styles.ACTIVE);
    }
}
