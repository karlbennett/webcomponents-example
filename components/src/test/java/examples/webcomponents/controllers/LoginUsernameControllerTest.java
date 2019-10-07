package examples.webcomponents.controllers;

import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class LoginUsernameControllerTest {

    @Test
    public void Can_render_a_login_user_name() {

        final Authentication authentication = mock(Authentication.class);

        final String username = someString();

        // Given
        given(authentication.getName()).willReturn(username);

        // When
        final ModelAndView actual = new LoginUsernameController().username(authentication);

        // Then
        assertThat(actual.getViewName(), equalTo("login-name"));
        assertThat(actual.getModel(), hasEntry("username", username));
    }

    @Test
    public void Cannot_render_a_login_user_name() {

        // When
        final ModelAndView actual = new LoginUsernameController().username(null);

        // Then
        assertThat(actual.getViewName(), equalTo("login-name"));
        assertThat(actual.getModel(), equalTo(emptyMap()));
    }
}