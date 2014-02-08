package org.gwtbootstrap3.client.ui.base.helper;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * @author Sven Jacobs
 */
public final class SourceCodeHelper {

    /**
     * If source code contains "\n" it will be replaced by a {@code <br>} element and "\s" will be replaced by a whitespace.
     *
     * @param code Unformatted source code
     * @return Formatted source code in HTML for use in {@link org.gwtbootstrap3.client.ui.Pre} or {@link org.gwtbootstrap3.client.ui.Code}
     */
    public static SafeHtml parseCode(final String code) {
        final SafeHtmlBuilder builder = new SafeHtmlBuilder();
        final String[] splitted = code.replaceAll("\\\\s", " ").split("\\\\n\\s?");

        for (final String s : splitted) {
            builder.append(SafeHtmlUtils.fromTrustedString(SafeHtmlUtils.htmlEscapeAllowEntities(s)));
            builder.appendHtmlConstant("<br>");
        }

        return builder.toSafeHtml();
    }

    private SourceCodeHelper() {
    }
}
