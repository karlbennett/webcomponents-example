package examples.webcomponents.render;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Files {

    public List<File> readAll(String path) throws IOException {
        return java.nio.file.Files.list(Paths.get(path))
            .filter(java.nio.file.Files::isRegularFile)
            .sorted()
            .map(this::toFile)
            .collect(toList());
    }

    File toFile(Path path) {
        return new File(
            path.getFileName().toString(),
            path.toAbsolutePath().toString(),
            path.getParent().toAbsolutePath().toString()
        );
    }
}
