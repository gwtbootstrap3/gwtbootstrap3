package org.gwtbootstrap3.client.ui.form.error;

public interface HasErrorHandler {

    ErrorHandler getErrorHandler();

    void setErrorHandler(ErrorHandler errorHandler);

    ErrorHandlerType getErrorHandlerType();

    void setErrorHandlerType(ErrorHandlerType errorHandlerType);

}
