package aps.application.util;

import java.io.*;

public class XmlFileReader {
    public static String readFile(String filePath) {
        String xmlString = null;
        try {
            String line;
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                xmlString += line;
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + filePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
        }
        return xmlString;
    }
}
