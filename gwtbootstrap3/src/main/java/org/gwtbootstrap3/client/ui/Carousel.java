package org.gwtbootstrap3.client.ui;

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

import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.shared.event.SlidEvent;
import org.gwtbootstrap3.client.shared.event.SlidHandler;
import org.gwtbootstrap3.client.shared.event.SlideEvent;
import org.gwtbootstrap3.client.shared.event.SlideHandler;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class Carousel extends Div {

    // Bootstrap default values: http://getbootstrap.com/javascript/#carousel
    private int interval = 5000;
    private String pause = "hover";
    private boolean wrap = true;

    public Carousel() {
        // Set the default styles
        setStyleName(Styles.CAROUSEL);
        addStyleName(Styles.SLIDE);

        // Set the default attribute
        getElement().setAttribute("data-ride", "carousel");

        // Bind jquery events
        bindJavaScriptEvents(getElement());
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setPause(String pause) {
        this.pause = pause;
    }

    public void setWrap(boolean wrap) {
        this.wrap = wrap;
    }

    /**
     * Causes the carousel to cycle
     */
    public void cycleCarousel() {
        fireMethod(getElement(), "cycle");
    }

    /**
     * Causes the carousel to pause movement
     */
    public void pauseCarousel() {
        fireMethod(getElement(), "pause");
    }

    /**
     * Causes the carousel to jump to that slide
     */
    public void jumpToSlide(int slideNumber) {
        fireMethod(getElement(), slideNumber);
    }

    /**
     * Causes the carousel to go back
     */
    public void goToPrev() {
        fireMethod(getElement(), "prev");
    }

    /**
     * Causes the carousel to go to the next slide
     */
    public void goToNext() {
        fireMethod(getElement(), "next");
    }

    public void addSlideHandler(SlideHandler slideHandler) {
        addHandler(slideHandler, SlideEvent.getType());
    }

    public void addSlidHandler(SlidHandler slidHandler) {
        addHandler(slidHandler, SlidEvent.getType());
    }

    /**
     * Fired when the carousel is starting to change slides
     */
    private void onSlide(final Event evt) {
        fireEvent(new SlideEvent(evt));
    }

    /**
     * Fired when the carousel is finished changing slides
     */
    private void onSlid(final Event evt) {
        fireEvent(new SlidEvent(evt));
    }

    private native void bindJavaScriptEvents(final com.google.gwt.dom.client.Element e) /*-{
        var target = this;
        var $carousel = $wnd.jQuery(e);

        $carousel.on('slide.bs.carousel', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Carousel::onSlide(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $carousel.on('slid.bs.carousel', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Carousel::onSlid(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;

    private native void carousel(final com.google.gwt.dom.client.Element e, final int interval, final String pause, final boolean wrap) /*-{
        $wnd.jQuery(e).carousel({
            interval: interval,
            pause: pause,
            wrap: wrap
        });
    }-*/;

    private native void fireMethod(final com.google.gwt.dom.client.Element e, String method) /*-{
        $wnd.jQuery(e).carousel(method);
    }-*/;

    private native void fireMethod(final com.google.gwt.dom.client.Element e, int slideNumber) /*-{
        $wnd.jQuery(e).carousel(slideNumber);
    }-*/;

    @Override
    protected void onLoad() {
        super.onLoad();

        // Configure the carousel
        carousel(getElement(), interval, pause, wrap);
    }
}
