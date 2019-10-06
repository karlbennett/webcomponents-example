package examples.webcomponents.render;

import org.junit.Test;

import static examples.webcomponents.render.IO.toAbsolutePath;
import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ITFreemarker {

    @Test
    public void Can_render_a_template() {

        // Given
        final String fileName = "template-01.txt";
        final String directory = toAbsolutePath("templates");

        // When
        final File actual = new Freemarker().render(
            new File(fileName + ".ftl", format("%s/%s.ftl", directory, fileName), directory, "")
        );

        // Then
        assertThat(actual, equalTo(
            new File(
                fileName,
                format("%s/%s", directory, fileName),
                directory,
                "A variable value: one. Imported text."
            )
        ));
    }
}