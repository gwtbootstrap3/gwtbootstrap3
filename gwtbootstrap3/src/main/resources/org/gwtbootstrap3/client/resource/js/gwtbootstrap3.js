/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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

var org = {
    gwtbootstrap3: {
        client: {
            ui: {
                base: {
                    AbstractTooltip: {
                        updateBool: function(dataTarget, e, option, value) {
                            window.jQuery(e).data(dataTarget).options[option] = value;
                        }, // updateBool
                        updateDelay: function(dataTarget, e, showDelay, hideDelay) {
                            window.jQuery(e).data(dataTarget).options['delay'] = {
                                show : showDelay,
                                hide : hideDelay
                            };
                        }, // updateDelay
                        updateString: function(dataTarget, e, option, value) {
                            window.jQuery(e).data(dataTarget).options[option] = value;
                        }, // updateString
                        updateViewport: function(dataTarget, e, selector, padding) {
                            window.jQuery(e).data(dataTarget).options['viewport'] = {
                                selector : selector,
                                padding : padding
                            };
                        } // updateViewport
                    } // AbstractTooltip
                }, // base
                Affix: {
                    internalAffix: function(e, offset) {
                        window.jQuery(e).affix({
                            offset: offset
                        });
                    } // internalAffix
                }, // Affix
                Carousel: {
                    carousel: function(e, interval, pause, wrap) {
                        window.jQuery(e).carousel({
                            interval: interval,
                            pause: pause,
                            wrap: wrap
                        });
                    } // carousel
                }, // Carousel
                ScrollSpy: {
                    init: function(e, target) {
                        window.jQuery(e).scrollspy({
                            target: target
                        });
                    } // init
                } // ScrollSpy
            }, // ui
            GwtBootstrap3EntryPoint: {
                isBootstrapLoaded: function () { return typeof window['jQuery'].fn.emulateTransitionEnd !== 'undefined'; },
                isjQueryLoaded: function () { return (typeof window['jQuery'] !== 'undefined'); }
            } // GwtBootstrap3EntryPoint
        } // client
    } // gwtbootstrap3
} // org;
