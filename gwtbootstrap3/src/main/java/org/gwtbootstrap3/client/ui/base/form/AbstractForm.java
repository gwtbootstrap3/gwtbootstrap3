package org.gwtbootstrap3.client.ui.base.form;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.impl.FormPanelImpl;
import com.google.gwt.user.client.ui.impl.FormPanelImplHost;

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
 * http://www.apache.org/licenses/LICENSE-2.0
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
 * @author Steven Jardine
 */
public abstract class AbstractForm extends FormElementContainer implements FormPanelImplHost {

    /**
     * Fired when a form has been submitted successfully.
     */
    public static class SubmitCompleteEvent extends GwtEvent<SubmitCompleteHandler> {

        /**
         * The event type.
         */
        private static Type<SubmitCompleteHandler> TYPE;

        /**
         * Handler hook.
         *
         * @return the handler hook
         */
        public static Type<SubmitCompleteHandler> getType() {
            if (TYPE == null) {
                TYPE = new Type<SubmitCompleteHandler>();
            }
            return TYPE;
        }

        private String resultHtml;

        /**
         * Create a submit complete event.
         *
         * @param resultsHtml the results from submitting the form
         */
        protected SubmitCompleteEvent(String resultsHtml) {
            this.resultHtml = resultsHtml;
        }

        @Override
        public final Type<SubmitCompleteHandler> getAssociatedType() {
            return getType();
        }

        /**
         * Gets the result text of the form submission.
         *
         * @return the result html, or <code>null</code> if there was an error
         *         reading it
         * @tip The result html can be <code>null</code> as a result of submitting a
         *      form to a different domain.
         */
        public String getResults() {
            return resultHtml;
        }

        @Override
        protected void dispatch(SubmitCompleteHandler handler) {
            handler.onSubmitComplete(this);
        }
    }

    /**
     * Handler for {@link AbstractForm.SubmitCompleteEvent} events.
     */
    public interface SubmitCompleteHandler extends EventHandler {

        /**
         * Fired when a form has been submitted successfully.
         *
         * @param event the event
         */
        void onSubmitComplete(AbstractForm.SubmitCompleteEvent event);
    }

    /**
     * Fired when the form is submitted.
     */
    public static class SubmitEvent extends GwtEvent<SubmitHandler> {

        /**
         * The event type.
         */
        private static Type<SubmitHandler> TYPE;

        /**
         * Handler hook.
         *
         * @return the handler hook
         */
        public static Type<SubmitHandler> getType() {
            if (TYPE == null) {
                TYPE = new Type<SubmitHandler>();
            }
            return TYPE;
        }

        private boolean canceled = false;

        /**
         * Cancel the form submit. Firing this will prevent a subsequent
         * {@link AbstractForm.SubmitCompleteEvent} from being fired.
         */
        public void cancel() {
            this.canceled = true;
        }

        @Override
        public final Type<AbstractForm.SubmitHandler> getAssociatedType() {
            return getType();
        }

        /**
         * Gets whether this form submit will be canceled.
         *
         * @return <code>true</code> if the form submit will be canceled
         */
        public boolean isCanceled() {
            return canceled;
        }

        @Override
        protected void dispatch(AbstractForm.SubmitHandler handler) {
            handler.onSubmit(this);
        }

        /**
         * This method is used for legacy support and should be removed when
         * {@link SubmitCompleteHandler} is removed.
         *
         * @deprecated Use {@link AbstractForm.SubmitEvent#cancel()} instead
         */
        @Deprecated
        void setCanceled(boolean canceled) {
            this.canceled = canceled;
        }
    }

    /**
     * Handler for {@link AbstractForm.SubmitEvent} events.
     */
    public interface SubmitHandler extends EventHandler {

        /**
         * Fired when the form is submitted.
         *
         * <p>
         * The AbstractForm must <em>not</em> be detached (i.e. removed from its parent
         * or otherwise disconnected from a {@link RootPanel}) until the submission
         * is complete. Otherwise, notification of submission will fail.
         * </p>
         *
         * @param event the event
         */
        void onSubmit(AbstractForm.SubmitEvent event);
    }

    interface IFrameTemplate extends SafeHtmlTemplates {

        static final IFrameTemplate INSTANCE = GWT.create(IFrameTemplate.class);

        @Template("<iframe src=\"javascript:''\" name='{0}' tabindex='-1' title='Form submit helper frame'"
                + "style='position:absolute;width:0;height:0;border:0'>")
        SafeHtml get(String name);
    }

    private static final String FORM = "form";

    private static int formId = 0;

    private static final FormPanelImpl impl = GWT.create(FormPanelImpl.class);

    private String frameName;

    private Element synthesizedFrame;

    public AbstractForm() {
        this(true);
    }

    public AbstractForm(boolean createIFrame) {
        this(Document.get().createFormElement(), createIFrame);
        getElement().setAttribute(Attributes.ROLE, FORM);
    }

    /**
     * This constructor may be used by subclasses to explicitly use an existing
     * element. This element must be a &lt;form&gt; element.
     * <p>
     * If the createIFrame parameter is set to <code>true</code>, then the
     * wrapped form's target attribute will be set to a hidden iframe. If not,
     * the form's target will be left alone, and the FormSubmitComplete event
     * will not be fired.
     * </p>
     *
     * @param element
     *            the element to be used
     * @param createIFrame
     *            <code>true</code> to create an &lt;iframe&gt; element that
     *            will be targeted by this form
     */
    protected AbstractForm(Element element, boolean createIFrame) {
        setElement(element);
        FormElement.as(element);

        if (createIFrame) {
            assert getTarget() == null || getTarget().trim()
                    .length() == 0 : "Cannot create target iframe if the form's target is already set.";

            // We use the module name as part of the unique ID to ensure that
            // ids are
            // unique across modules.
            frameName = "GWTBootstrap3_AbstractForm_" + GWT.getModuleName() + "_" + (++formId);
            setTarget(frameName);

            sinkEvents(Event.ONLOAD);
        }
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        if (frameName != null) {
            // Create and attach a hidden iframe to the body element.
            createFrame();
            Document.get().getBody().appendChild(synthesizedFrame);
        }
        // Hook up the underlying iframe's onLoad event when attached to the
        // DOM.
        // Making this connection only when attached avoids memory-leak issues.
        // The AbstractForm cannot use the built-in GWT event-handling mechanism
        // because there is no standard onLoad event on iframes that works
        // across
        // browsers.
        impl.hookEvents(synthesizedFrame, getElement(), this);
    }

    @Override
    protected void onDetach() {
        super.onDetach();

        // Unhook the iframe's onLoad when detached.
        impl.unhookEvents(synthesizedFrame, getElement());

        if (synthesizedFrame != null) {
            // And remove it from the document.
            Document.get().getBody().removeChild(synthesizedFrame);
            synthesizedFrame = null;
        }
    }

    @Override
    public boolean onFormSubmit() {
        return onFormSubmitImpl();
    }

    @Override
    public void onFrameLoad() {
        onFrameLoadImpl();
    }

    /**
     * Adds a {@link SubmitCompleteEvent} handler.
     *
     * @param handler
     *            the handler
     * @return the handler registration used to remove the handler
     */
    public HandlerRegistration addSubmitCompleteHandler(SubmitCompleteHandler handler) {
        return addHandler(handler, SubmitCompleteEvent.getType());
    }

    /**
     * Adds a {@link AbstractForm.SubmitEvent} handler.
     *
     * @param handler
     *            the handler
     * @return the handler registration used to remove the handler
     */
    public HandlerRegistration addSubmitHandler(AbstractForm.SubmitHandler handler) {
        return addHandler(handler, AbstractForm.SubmitEvent.getType());
    }

    /**
     * Gets the 'action' associated with this form. This is the URL to which it
     * will be submitted.
     *
     * @return the form's action
     */
    public String getAction() {
        return getFormElement().getAction();
    }

    /**
     * Sets the 'action' associated with this form. This is the URL to which it
     * will be submitted.
     *
     * @param action
     *            the form's action
     */
    public void setAction(final String action) {
        getFormElement().setAction(action);
    }

    /**
     * Sets the 'action' associated with this form. This is the URL to which it
     * will be submitted.
     *
     * @param url
     *            the form's action
     */
    public void setAction(SafeUri url) {
        getFormElement().setAction(url);
    }

    /**
     * Gets the HTTP method used for submitting this form. This should be either
     * {@link #METHOD_GET} or {@link #METHOD_POST}.
     *
     * @return the form's method
     */
    public String getMethod() {
        return getFormElement().getMethod();
    }

    /**
     * Sets the HTTP method used for submitting this form. This should be either
     * {@link #METHOD_GET} or {@link #METHOD_POST}.
     *
     * @param method
     *            the form's method
     */
    public void setMethod(final String method) {
        getFormElement().setMethod(method);
    }

    /**
     * Gets the form's 'target'. This is the name of the {@link NamedFrame} that
     * will receive the results of submission, or <code>null</code> if none has
     * been specified.
     *
     * @return the form's target.
     */
    public String getTarget() {
        return getFormElement().getTarget();
    }

    /**
     * Gets the encoding used for submitting this form. This should be either
     * {@link #ENCODING_MULTIPART} or {@link #ENCODING_URLENCODED}.
     *
     * @return the form's encoding
     */
    public String getEncoding() {
        return impl.getEncoding(getElement());
    }

    /**
     * Sets the encoding used for submitting this form. This should be either
     * {@link #ENCODING_MULTIPART} or {@link #ENCODING_URLENCODED}.
     *
     * @param encodingType
     *            the form's encoding
     */
    public void setEncoding(String encodingType) {
        impl.setEncoding(getElement(), encodingType);
    }

    /**
     * Submits form
     */
    public void submit() {
        // Fire the onSubmit event, because javascript's form.submit() does not
        // fire the built-in onsubmit event.
        if (!fireSubmitEvent()) {
            return;
        }
        impl.submit(getElement(), synthesizedFrame);
    }

    /**
     * Resets form
     */
    public void reset() {
        impl.reset(getElement());
        for (HasValidators<?> child : getChildrenWithValidators(this)) {
            child.reset();
        }
    }

    private void createFrame() {
        // Attach a hidden IFrame to the form. This is the target iframe to
        // which the form will be submitted. We have to create the iframe using
        // innerHTML, because setting an iframe's 'name' property dynamically
        // doesn't work on most browsers.
        Element dummy = Document.get().createDivElement();
        dummy.setInnerSafeHtml(IFrameTemplate.INSTANCE.get(frameName));

        synthesizedFrame = dummy.getFirstChildElement();
    }

    /**
     * Fire a {@link AbstractForm.SubmitEvent}.
     *
     * @return true to continue, false if canceled
     */
    private boolean fireSubmitEvent() {
        AbstractForm.SubmitEvent event = new AbstractForm.SubmitEvent();
        fireEvent(event);
        return !event.isCanceled();
    }

    FormElement getFormElement() {
        return FormElement.as(getElement());
    }

    /**
     * Returns true if the form is submitted, false if canceled.
     */
    private boolean onFormSubmitImpl() {
        return fireSubmitEvent();
    }

    private void onFrameLoadImpl() {
        // Fire onComplete events in a deferred command. This is necessary
        // because clients that detach the form panel when submission is
        // complete can cause some browsers (i.e. Mozilla) to go into an
        // 'infinite loading' state. See issue 916.
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            @Override
            public void execute() {
                fireEvent(new SubmitCompleteEvent(impl.getContents(synthesizedFrame)));
            }
        });
    }

    private void setTarget(String target) {
        getFormElement().setTarget(target);
    }

    /**
     * @return true if the child input elements are all valid.
     */
    public boolean validate() {
        return validate(true);
    }

    /**
     * @return true if the child input elements are all valid.
     */
    public boolean validate(boolean show) {
        boolean result = true;
        for (HasValidators<?> child : getChildrenWithValidators(this)) {
            result &= child.validate(show);
        }
        return result;
    }

    /**
     * Get this forms child input elements with validators.
     *
     * @param widget the widget
     * @return the children with validators
     */
    protected List<HasValidators<?>> getChildrenWithValidators(Widget widget) {
        List<HasValidators<?>> result = new ArrayList<HasValidators<?>>();
        if (widget != null) {
            if (widget instanceof HasValidators<?>) {
                result.add((HasValidators<?>) widget);
            }
            if (widget instanceof HasOneWidget) {
                result.addAll(getChildrenWithValidators(((HasOneWidget) widget).getWidget()));
            }
            if (widget instanceof HasWidgets) {
                for (Widget child : (HasWidgets) widget) {
                    result.addAll(getChildrenWithValidators(child));
                }
            }
        }
        return result;
    }

    private HandlerRegistration submitOnEnterRegistration = null;

    public void setSubmitOnEnter(boolean submitOnEnter) {
        if (submitOnEnter) {
            if (submitOnEnterRegistration == null)
                submitOnEnterRegistration = addDomHandler(new KeyPressHandler() {
                    @Override
                    public void onKeyPress(KeyPressEvent event) {
                        if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
                            if (validate()) {
                                fireSubmitEvent();
                            }
                        }
                    }
                }, KeyPressEvent.getType());
        } else if (submitOnEnterRegistration != null) {
            submitOnEnterRegistration.removeHandler();
            submitOnEnterRegistration = null;
        }
    }

    public boolean isSubmitOnEnter() {
        return submitOnEnterRegistration != null;
    }

}
