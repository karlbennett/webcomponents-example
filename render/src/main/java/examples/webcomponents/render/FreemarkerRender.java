package examples.webcomponents.render;

import java.io.IOException;

public class FreemarkerRender {

    public static void main(String... args) throws IOException {
        final String source = args[0];
        final String destination = args[1];

        final Files files = new Files();
        final Freemarker freemarker = new Freemarker();

        files.readAll(source).stream().map(freemarker::render).forEach(file -> {
            file.writeTo(destination + "/" + file.getName());
        });
    }
}
