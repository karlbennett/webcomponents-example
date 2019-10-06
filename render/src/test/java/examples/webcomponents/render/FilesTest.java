package examples.webcomponents.render;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static examples.webcomponents.render.IO.toAbsolutePath;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class FilesTest {

    private Files files;

    @Before
    public void setUp() {
        files = new Files();
    }

    @Test
    public void Can_read_a_directory_of_files() throws IOException {

        final String filesPath = toAbsolutePath("files");
        final String name1 = "file-01.txt";
        final String name2 = "file-02.txt";
        final String name3 = "file-03.txt";

        // When
        final List<File> actual = this.files.readAll(filesPath);

        // Then
        assertThat(actual, contains(
            new File(name1, filesPath + "/" + name1, filesPath),
            new File(name2, filesPath + "/" + name2, filesPath),
            new File(name3, filesPath + "/" + name3, filesPath)
        ));
    }
}