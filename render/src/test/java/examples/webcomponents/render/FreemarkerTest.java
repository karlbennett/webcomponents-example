package examples.webcomponents.render;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.io.Writer;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class FreemarkerTest {

    private Freemarker freemarker;
    private Configuration configuration;

    @Before
    public void setUp() {
        configuration = mock(Configuration.class);
        freemarker = new Freemarker(configuration);
    }

    @Test
    public void Can_render_a_file() throws IOException, TemplateException {

        final File file = mock(File.class);

        final String fileName = someString();
        final String templateName = fileName + ".ftl";
        final String filePath = someString();
        final String directory = someString();
        final Template template = mock(Template.class);
        final String render = someString();

        // Given
        given(file.getName()).willReturn(templateName);
        given(file.getPath()).willReturn(filePath + ".ftl");
        given(file.getDirectory()).willReturn(directory);
        given(configuration.getTemplate(templateName)).willReturn(template);
        willAnswer((Answer<Void>) invocationOnMock -> {
            final Writer out = invocationOnMock.getArgument(1);
            IOUtils.write(render, out);
            out.flush();
            return null;
        }).given(template).process(eq(null), any(Writer.class));

        // When
        final File actual = freemarker.render(file);

        // Then
        final InOrder order = inOrder(configuration, template);
        then(configuration).should(order).setDirectoryForTemplateLoading(new java.io.File(directory));
        then(configuration).should(order).getTemplate(templateName);
        then(template).should(order).process(eq(null), any(Writer.class));
        assertThat(actual, equalTo(new File(fileName, filePath, directory, render)));
    }
}