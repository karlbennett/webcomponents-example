package examples.webcomponents.render;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static examples.webcomponents.render.IO.toAbsolutePath;
import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someAlphaString;
import static shiver.me.timbers.data.random.RandomStrings.someString;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest {

    private String name;
    private String path;
    private String directory;
    private String content;
    private File file;

    @Before
    public void setUp() {
        name = someString();
        path = toAbsolutePath("files/file-01.txt");
        directory = toAbsolutePath("files");
        content = someString();
        file = new File(name, path, directory, content);
    }

    @Test
    public void Instantiation_for_coverage() {
        new File(name, path, directory);
    }

    @Test
    public void Can_get_name_path_and_directory() {

        // When
        final String actualName = file.getName();
        final String actualPath = file.getPath();
        final String actualDirectory = file.getDirectory();

        // Then
        assertThat(actualName, is(name));
        assertThat(actualPath, is(path));
        assertThat(actualDirectory, is(directory));
    }

    @Test
    public void Can_compare_a_file() {

        final File otherFile = mock(File.class);

        final String otherName = someString();

        // Given
        given(otherFile.getName()).willReturn(otherName);

        // When
        final int actual = file.compareTo(otherFile);

        // Then
        assertThat(actual, equalTo(name.compareTo(otherName)));
    }

    @Test
    public void Can_write_a_file() {

        // Given
        final String filePath = format("%s/file-%s.txt", toAbsolutePath(""), someAlphaString(5));

        // When
        file.writeTo(filePath);

        // Then
        assertThat(IO.toString(filePath), equalTo(content));
    }

    @Test
    public void Can_write_a_file_a_directory_that_does_not_exist() {

        // Given
        final String filePath = format(
            "%s/file-%s.txt", toAbsolutePath("") + "/this/does/not/exist/yet", someAlphaString(5)
        );

        // When
        file.writeTo(filePath);

        // Then
        assertThat(IO.toString(filePath), equalTo(content));
    }

    @Test
    public void Can_fail_write_a_file() throws IOException {

        final String path = toAbsolutePath("") + "/this/is/a/directory";

        // Given
        Files.createDirectories(Paths.get(path));

        // When
        final IllegalStateException actual = Assertions.catchThrowableOfType(
            () -> file.writeTo(path), IllegalStateException.class
        );

        // Then
        assertThat(actual.getCause(), instanceOf(IOException.class));
    }

    @Test
    public void File_hash_equality() {
        EqualsVerifier.forClass(File.class).usingGetClass().verify();
    }
}