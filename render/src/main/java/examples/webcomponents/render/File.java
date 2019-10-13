package examples.webcomponents.render;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class File implements Comparable<File> {

    private final String name;
    private final String path;
    private final String directory;
    private final String content;

    public File(String name, String path, String directory) {
        this(name, path, directory, null);
    }

    public File(String name, String path, String directory, String content) {
        this.name = name;
        this.path = path;
        this.directory = directory;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getDirectory() {
        return directory;
    }

    @Override
    public int compareTo(File file) {
        return getName().compareTo(file.getName());
    }

    public void writeTo(String path) {
        try {
            final Path _path = Paths.get(path);
            Files.createDirectories(_path.getParent());
            Files.write(_path, content.getBytes());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(name, file.name) &&
            Objects.equals(path, file.path) &&
            Objects.equals(directory, file.directory) &&
            Objects.equals(content, file.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, directory, content);
    }
}
