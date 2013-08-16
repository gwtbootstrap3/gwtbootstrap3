package com.svenjacobs.gwtbootstrap3.client.ui.base.helper;

import org.junit.Test;

import static com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper.containsStyle;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sven Jacobs
 */
public class StyleHelperTest {

    @Test
    public void testContainsStyle() {
        final String styleNames = "abc-efg 123 hji-klm";

        assertThat(containsStyle(styleNames, "abc-efg"), is(true));
        assertThat(containsStyle(styleNames, "123"), is(true));
        assertThat(containsStyle(styleNames, "hji-klm"), is(true));
        assertThat(containsStyle(styleNames, "mno"), is(false));
        assertThat(containsStyle(null, "hji-klm"), is(false));
        assertThat(containsStyle(styleNames, null), is(false));
        assertThat(containsStyle("abc", "abc"), is(true));
    }
}
