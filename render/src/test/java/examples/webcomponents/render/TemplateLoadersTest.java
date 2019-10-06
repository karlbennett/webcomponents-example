package examples.webcomponents.render;

import freemarker.cache.TemplateLoader;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class TemplateLoadersTest {

    @Test
    public void Can_create_a_string_template_loader() throws IOException {

        // Given
        final String templateName = someString();
        final String content = someString();

        // When
        final TemplateLoader actual = new TemplateLoaders().stringLoader(templateName, content);

        // Then
        assertThat(actual.findTemplateSource(templateName), notNullValue());
    }
}