package examples.webcomponents.render;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Freemarker {

    private final Configuration configuration;

    public Freemarker() {
        this("2.3.29");
    }

    public Freemarker(String version) {
        this(new Configuration(new Version(version)));
    }

    Freemarker(Configuration configuration) {
        this.configuration = configuration;
    }

    public File render(File file) {
        try {
            configuration.setDirectoryForTemplateLoading(new java.io.File(file.getDirectory()));
            final Template template = configuration.getTemplate(file.getName());
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            template.process(null, new OutputStreamWriter(out));
            return new File(
                file.getName().replaceAll("\\.ftl$", ""),
                file.getPath().replaceAll("\\.ftl$", ""),
                file.getDirectory(),
                new String(out.toByteArray())
            );
        } catch (IOException | TemplateException e) {
            throw new IllegalStateException(e);
        }
    }
}
