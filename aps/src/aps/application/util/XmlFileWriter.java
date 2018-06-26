package aps.application.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class XmlFileWriter {

    public static String writeFile(String filePath, String fileContents) {
        String xmlString = "";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContents);
            bufferedWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + filePath + "'");
        } catch (IOException ex) {
            System.out.println("Error writing file '" + filePath + "'");
        }
        return xmlString;
    }
}
