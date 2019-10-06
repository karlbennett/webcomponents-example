package examples.webcomponents.render;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static examples.webcomponents.render.IO.readFiles;
import static examples.webcomponents.render.IO.toAbsolutePath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ITFreemarkerRender {

    @Test
    public void Can_render_some_templates() throws IOException {

        // Given
        final String output = "output";

        // When
        FreemarkerRender.main(toAbsolutePath("templates"), toAbsolutePath(output));
        final List<String> files = readFiles(output);

        // Then
        assertThat(files.get(0), equalTo("A variable value: one. Imported text."));
        assertThat(files.get(1), equalTo("A conditional: false. Imported text."));
        assertThat(files.get(2), equalTo("A loop: 1, 2, 3, 4, 5. Imported text."));
    }
}