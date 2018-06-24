package aps.application.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class XmlFileReaderTest {

    @Test
    public void readFile() {
        assertTrue(XmlFileReader.readFile("src/resources/scrape/telkom-scrape.xml").contains("www.telkom.co.za"));
    }
}