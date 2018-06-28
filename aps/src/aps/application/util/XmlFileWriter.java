package aps.application.util;

import java.io.*;
import java.nio.file.Files;

public class XmlFileWriter {

    public static String writeFile(String filePath, String fileContents) {
        String xmlString = "";
        File file = new File(filePath);

        try {
            FileWriter fileWriter = new FileWriter(file);
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
