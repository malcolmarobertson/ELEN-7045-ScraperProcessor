package aps.application.util;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XmlFileWriterTest {

    String fileContents;
    String filePath;
    Path path;

    @Before
    public void init() {
        fileContents = "Hello World";
        filePath = "src/resources/scrape/writer-test.txt";
    }

    @Test
    public void writeFile() {
        path = Paths.get(filePath);
        XmlFileWriter.writeFile(filePath, fileContents);

        assertTrue(Files.exists(path));
        assertTrue(Files.isRegularFile(path));
        assertFalse(Files.isDirectory(path));
    }
}