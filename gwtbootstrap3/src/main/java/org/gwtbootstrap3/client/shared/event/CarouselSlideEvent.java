package org.gwtbootstrap3.client.shared.event;

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

import org.gwtbootstrap3.client.ui.Carousel;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * @author Joshua Godi
 */
public class CarouselSlideEvent extends GwtEvent<CarouselSlideHandler> implements CarouselEvent {

    private static final Type<CarouselSlideHandler> TYPE = new Type<CarouselSlideHandler>();

    private final Carousel carousel;
    private final Event nativeEvent;

    public static Type<CarouselSlideHandler> getType() {
        return TYPE;
    }

    public CarouselSlideEvent(final Carousel carousel, final Event nativeEvent) {
        this.carousel = carousel;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public Carousel getCarousel() {
        return carousel;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<CarouselSlideHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final CarouselSlideHandler handler) {
        handler.onSlide(this);
    }
}
