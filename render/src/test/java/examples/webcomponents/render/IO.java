package examples.webcomponents.render;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class IO {

    private static final PathMatchingResourcePatternResolver RESOLVER = new PathMatchingResourcePatternResolver();

    public static String toAbsolutePath(String path) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(path);
        try {
            return Paths.get(url.toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    public static List<String> readFiles(String path) {
        try {
            return Arrays.stream(RESOLVER.getResources(path + "/*")).map(IO::toString).collect(toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String toString(Resource resource) {
        try {
            return IOUtils.toString(resource.getInputStream(), "UTF-8");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String toString(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
