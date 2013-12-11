package com.svenjacobs.gwtbootstrap3.bootbox.client;

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

import com.svenjacobs.gwtbootstrap3.bootbox.client.callback.AlertCallback;
import com.svenjacobs.gwtbootstrap3.bootbox.client.callback.ConfirmCallback;
import com.svenjacobs.gwtbootstrap3.bootbox.client.callback.PromptCallback;

/**
 * Created by kyle on 2013/12/11.
 */
public class Bootbox {
    /**
     * Displays a message in a modal dialog box.
     *
     * @param msg the message to be displayed.
     */
    public static native void alert(String msg) /*-{
        $wnd.bootbox.alert(msg);
    }-*/;

    /**
     * Displays a message in a modal dialog box.
     * With callback handler.
     *
     * @param msg the message to be displayed.
     * @param callback the callback handler.
     */
    public static native void alert(String msg, AlertCallback callback) /*-{
        $wnd.bootbox.alert(msg, function() {
            callback.@com.svenjacobs.gwtbootstrap3.bootbox.client.callback.AlertCallback::callback()();
        });
    }-*/;

    /**
     * Displays a message in a modal dialog box, along with the standard 'OK' and
     * 'Cancel' buttons.
     *
     * @param msg the message to be displayed.
     * @param callback the callback handler.
     */
    public static native void confirm(String msg, ConfirmCallback callback) /*-{
        $wnd.bootbox.confirm(msg, function(result) {
            callback.@com.svenjacobs.gwtbootstrap3.bootbox.client.callback.ConfirmCallback::callback(Z)(result);
        });
    }-*/;

    /**
     * Displays a request for information in a modal dialog box, along with the
     * standard 'OK' and 'Cancel' buttons.
     *
     * @param msg the message to be displayed.
     * @param callback the callback handler.
     */
    public static native void prompt(String msg, PromptCallback callback) /*-{
        $wnd.bootbox.prompt(msg, function(result) {
            callback.@com.svenjacobs.gwtbootstrap3.bootbox.client.callback.PromptCallback::callback(Ljava/lang/String;)(result);
        });
    }-*/;
}
