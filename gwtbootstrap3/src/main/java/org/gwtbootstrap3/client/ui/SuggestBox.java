package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2015 GwtBootstrap3
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

import java.util.Collection;
import java.util.List;

import org.gwtbootstrap3.client.ui.base.HasAutoComplete;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasPlaceholder;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.ValueBoxBase;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.HasBlankValidator;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;
import org.gwtbootstrap3.client.ui.form.validator.ValidationChangedEvent.ValidationChangedHandler;
import org.gwtbootstrap3.client.ui.form.validator.Validator;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Wrapper for a {@link com.google.gwt.user.client.ui.SuggestBox}.<br/>
 * <br/>
 * The default style is inherited from the {@link Styles#DROPDOWN_MENU}. Styling of the suggestions items need
 * a bit of css in order to be pleasing to the eye.
 * 
 * <pre>
 * {@code
 * .dropdown-menu .item {
 *     padding: 5px;
 * }
 *  
 * .dropdown-menu .item-selected {
 *     background-color: #eee;
 * }
 * 
 * }
 * </pre>
 * 
 * @author Steven Jardine
 */
public class SuggestBox extends com.google.gwt.user.client.ui.SuggestBox implements HasId, HasResponsiveness, HasPlaceholder,
        HasAutoComplete, HasSize<InputSize>, HasEditorErrors<String>, HasErrorHandler, HasValidators<String>,
        HasBlankValidator<String> {

    static class CustomSuggestionDisplay extends DefaultSuggestionDisplay {

        private ResizeHandler popupResizeHandler = null;

        public CustomSuggestionDisplay() {
            super();
            final PopupPanel popup = getPopupPanel();
            popup.setStyleName(Styles.DROPDOWN_MENU);
            popup.getElement().getStyle().setDisplay(Display.BLOCK);
        }

        /**
         * Resize the popup panel to the size of the suggestBox and place it below the SuggestBox. This is not
         * ideal but works better in a mobile environment.
         *
         * @param box the box the SuggestBox.
         */
        private void resizePopup(final com.google.gwt.user.client.ui.SuggestBox box) {
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                @Override
                public void execute() {
                    PopupPanel panel = getPopupPanel();
                    if (box.isAttached())
                    {
                      Element e = box.getElement();
                      panel.setWidth((e.getAbsoluteRight() - e.getAbsoluteLeft() - 2) + Unit.PX.getType());
                      panel.setPopupPosition(e.getAbsoluteLeft(), e.getAbsoluteBottom());
                    }
                    else
                    {
                      panel.hide();
                    }  
                }
            });
        }

        /** {@inheritDoc} */
        @Override
        protected void showSuggestions(final com.google.gwt.user.client.ui.SuggestBox suggestBox,
                final Collection<? extends Suggestion> suggestions, final boolean isDisplayStringHTML,
                final boolean isAutoSelectEnabled, final SuggestionCallback callback) {
            super.showSuggestions(suggestBox, suggestions, isDisplayStringHTML, isAutoSelectEnabled, callback);
            resizePopup(suggestBox);
            if (popupResizeHandler == null) {
                popupResizeHandler = new ResizeHandler() {
                    private Timer timer = new Timer() {
                        public void run() {
                            resizePopup(suggestBox);
                        }
                    };

                    @Override
                    public void onResize(ResizeEvent event) {
                        timer.schedule(250);
                    }
                };
                Window.addResizeHandler(popupResizeHandler);
            }
            // Try and set the z-index of the popup to the same as the SuggestBox.
            if (!suggestBox.getElement().getStyle().getZIndex().equals("")) {
                try {
                    getPopupPanel().getElement().getStyle()
                            .setZIndex(Integer.valueOf(suggestBox.getElement().getStyle().getZIndex()));
                } catch (Exception e) {
                    // Do nothing. We tried....
                }
            }
        }
    }

    private final EnabledMixin<SuggestBox> enabledMixin = new EnabledMixin<SuggestBox>(this);

    private final ErrorHandlerMixin<String> errorHandlerMixin = new ErrorHandlerMixin<String>(this);

    private final IdMixin<SuggestBox> idMixin = new IdMixin<SuggestBox>(this);

    private final BlankValidatorMixin<SuggestBox, String> validatorMixin = new BlankValidatorMixin<SuggestBox, String>(this,
        errorHandlerMixin.getErrorHandler());

    /**
     * Constructor for {@link SuggestBox}. Creates a {@link MultiWordSuggestOracle} and {@link TextBox} to use
     * with this {@link SuggestBox}.
     */
    public SuggestBox() {
        this(new MultiWordSuggestOracle());
    }

    /**
     * Constructor for {@link SuggestBox}. Creates a {@link TextBox} to use with this {@link SuggestBox}.
     *
     * @param oracle the oracle for this <code>SuggestBox</code>
     */
    public SuggestBox(SuggestOracle oracle) {
        this(oracle, new TextBox());
    }

    /**
     * Constructor for {@link SuggestBox}. The text box will be removed from it's current location and wrapped
     * by the {@link SuggestBox}.
     *
     * @param oracle supplies suggestions based upon the current contents of the text widget
     * @param box the text widget
     */
    public SuggestBox(SuggestOracle oracle, ValueBoxBase<String> box) {
        this(oracle, box, new CustomSuggestionDisplay());
    }

    /**
     * Constructor for {@link SuggestBox}. The text box will be removed from it's current location and wrapped
     * by the {@link SuggestBox}.
     *
     * @param oracle supplies suggestions based upon the current contents of the text widget
     * @param box the text widget
     * @param suggestDisplay the class used to display suggestions
     */
    public SuggestBox(SuggestOracle oracle, ValueBoxBase<String> box, SuggestionDisplay suggestDisplay) {
        super(oracle, box, suggestDisplay);
        setStyleName(Styles.FORM_CONTROL);
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addValidationChangedHandler(ValidationChangedHandler handler) {
        return validatorMixin.addValidationChangedHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public void addValidator(Validator<String> validator) {
        validatorMixin.addValidator(validator);
    }

    /** {@inheritDoc} */
    @Override
    public boolean getAllowBlank() {
        return validatorMixin.getAllowBlank();
    }

    /** {@inheritDoc} */
    @Override
    public String getAutoComplete() {
        return getElement().getAttribute(AUTO_COMPLETE);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandler getErrorHandler() {
        return errorHandlerMixin.getErrorHandler();
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandlerType getErrorHandlerType() {
        return errorHandlerMixin.getErrorHandlerType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return idMixin.getId();
    }

    /** {@inheritDoc} */
    @Override
    public String getPlaceholder() {
        return getElement().getAttribute(PLACEHOLDER);
    }

    /** {@inheritDoc} */
    @Override
    public InputSize getSize() {
        return InputSize.fromStyleName(getStyleName());
    }

    @Override
    public boolean getValidateOnBlur() {
        return validatorMixin.getValidateOnBlur();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        // Try and set the z-index.
        Integer zIndex = null;
        Widget widget = this;
        while (zIndex == null && widget != null) {
            if (!widget.getElement().getStyle().getZIndex().equals("")) {
                try {
                    zIndex = Integer.valueOf(widget.getElement().getStyle().getZIndex());
                    zIndex += 10;
                } catch (Exception e) {
                    zIndex = null;
                }
            }
            widget = widget.getParent();
        }
        if (zIndex != null) {
            getElement().getStyle().setZIndex(zIndex);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean removeValidator(Validator<String> validator) {
        return validatorMixin.removeValidator(validator);
    }

    @Override
    public void reset() {
        validatorMixin.reset();
    }

    @Override
    public void setAllowBlank(boolean allowBlank) {
        validatorMixin.setAllowBlank(allowBlank);
    }

    /** {@inheritDoc} */
    @Override
    public void setAutoComplete(final boolean autoComplete) {
        getElement().setAttribute(AUTO_COMPLETE, autoComplete ? ON : OFF);
    }

    /** {@inheritDoc} */
    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandlerMixin.setErrorHandler(handler);
        validatorMixin.setErrorHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandlerType(ErrorHandlerType type) {
        errorHandlerMixin.setErrorHandlerType(type);
    }

    /** {@inheritDoc} */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    /** {@inheritDoc} */
    @Override
    public void setPlaceholder(final String placeHolder) {
        getElement().setAttribute(PLACEHOLDER, placeHolder != null ? placeHolder : "");
    }

    /** {@inheritDoc} */
    @Override
    public void setSize(final InputSize size) {
        StyleHelper.addUniqueEnumStyleName(this, InputSize.class, size);
    }

    @Override
    public void setValidateOnBlur(boolean validateOnBlur) {
        validatorMixin.setValidateOnBlur(validateOnBlur);
    }

    @Override
    public void setValidators(@SuppressWarnings("unchecked") Validator<String>... validators) {
        validatorMixin.setValidators(validators);
    }

    /** {@inheritDoc} */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate() {
        return validatorMixin.validate();
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate(boolean show) {
        return validatorMixin.validate(show);
    }

}
