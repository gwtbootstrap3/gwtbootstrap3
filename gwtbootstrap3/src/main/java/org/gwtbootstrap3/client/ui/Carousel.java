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

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.shared.event.CarouselSlidEvent;
import org.gwtbootstrap3.client.shared.event.CarouselSlidHandler;
import org.gwtbootstrap3.client.shared.event.CarouselSlideEvent;
import org.gwtbootstrap3.client.shared.event.CarouselSlideHandler;
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class Carousel extends Div {
    public static final String HOVER = "hover";
    public static final String CAROUSEL = "carousel";
    public static final String CYCLE = "cycle";
    public static final String PAUSE = "pause";
    public static final String PREV = "prev";
    public static final String NEXT = "next";

    // Bootstrap default values: http://getbootstrap.com/javascript/#carousel
    private int interval = 5000;
    private String pause = HOVER;
    private boolean wrap = true;

    public Carousel() {
        // Set the default styles
        setStyleName(Styles.CAROUSEL);
        addStyleName(Styles.SLIDE);

        // Set the default attribute
        getElement().setAttribute(Attributes.DATA_RIDE, CAROUSEL);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind jquery events
        bindJavaScriptEvents(getElement());

        // Configure the carousel
        carousel(getElement(), interval, pause, wrap);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind events
        unbindJavaScriptEvents(getElement());
    }

    public void setInterval(final int interval) {
        this.interval = interval;
    }

    public void setPause(final String pause) {
        this.pause = pause;
    }

    public void setWrap(final boolean wrap) {
        this.wrap = wrap;
    }

    /**
     * Causes the carousel to cycle
     */
    public void cycleCarousel() {
        fireMethod(getElement(), CYCLE);
    }

    /**
     * Causes the carousel to pause movement
     */
    public void pauseCarousel() {
        fireMethod(getElement(), PAUSE);
    }

    /**
     * Causes the carousel to jump to that slide
     */
    public void jumpToSlide(final int slideNumber) {
        fireMethod(getElement(), slideNumber);
    }

    /**
     * Causes the carousel to go back
     */
    public void goToPrev() {
        fireMethod(getElement(), PREV);
    }

    /**
     * Causes the carousel to go to the next slide
     */
    public void goToNext() {
        fireMethod(getElement(), NEXT);
    }

    public HandlerRegistration addSlideHandler(final CarouselSlideHandler carouselSlideHandler) {
        return addHandler(carouselSlideHandler, CarouselSlideEvent.getType());
    }

    public HandlerRegistration addSlidHandler(final CarouselSlidHandler slidHandler) {
        return addHandler(slidHandler, CarouselSlidEvent.getType());
    }

    /**
     * Fired when the carousel is starting to change slides
     */
    private void onSlide(final Event evt) {
        fireEvent(new CarouselSlideEvent(this, evt));
    }

    /**
     * Fired when the carousel is finished changing slides
     */
    private void onSlid(final Event evt) {
        fireEvent(new CarouselSlidEvent(this, evt));
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

    private native void unbindJavaScriptEvents(final com.google.gwt.dom.client.Element e) /*-{
        $wnd.jQuery(e).off('slide.bs.carousel');
        $wnd.jQuery(e).off('slid.bs.carousel');
    }-*/;

    private native void carousel(final com.google.gwt.dom.client.Element e, final int interval, final String pause,
                                 final boolean wrap) /*-{
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
}
