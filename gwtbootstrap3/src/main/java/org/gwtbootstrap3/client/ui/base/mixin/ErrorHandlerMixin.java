package org.gwtbootstrap3.client.ui.base.mixin;

import java.util.List;

import org.gwtbootstrap3.client.ui.form.error.DefaultErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.user.client.ui.Widget;

/**
 * Mixin to handle error handler support.
 *
 * @param <T> the type of input widget.
 * @param <V> the type of editor value.
 */
public class ErrorHandlerMixin<T extends Widget & HasEditorErrors<V> & HasErrorHandler, V> implements HasEditorErrors<V>,
        HasErrorHandler {

    private ErrorHandler errorHandler;

    private ErrorHandlerType errorHandlerType = ErrorHandlerType.DEFAULT;

    private Widget inputWidget = null;

    /**
     * Mixin for the {@link ErrorHandler} implementation.
     *
     * @param widget the widget
     */
    public ErrorHandlerMixin(Widget widget) {
        inputWidget = widget;
        errorHandler = new DefaultErrorHandler(inputWidget);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandlerType getErrorHandlerType() {
        return errorHandlerType;
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandlerType = null;
        errorHandler = handler;
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandlerType(ErrorHandlerType type) {
        if (errorHandler != null) {
            errorHandler.cleanup();
        }
        errorHandlerType = type == null ? ErrorHandlerType.DEFAULT : type;
        switch (errorHandlerType) {
        case NONE:
            errorHandler = null;
            break;
        case DEFAULT:
            errorHandler = new DefaultErrorHandler(inputWidget);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        if (errorHandler != null) {
            if (errors == null || errors.isEmpty()) {
                errorHandler.clearErrors();
                return;
            }
            errorHandler.showErrors(errors);
        }
    }

}
