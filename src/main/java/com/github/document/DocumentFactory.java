package com.github.document;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yan
 */
public class DocumentFactory {
    public static final String DIR = "components";

    public static Map<String, Object> getComponentDocument() {
        return scanComponentDocument(DocumentFactory.class.getResource(DIR).getFile());
    }

    private static Map<String, Object> scanComponentDocument(String folderPath) {
        Map<String, Object> documents = new HashMap<>(16);
        File directory = new File(folderPath);

        if (directory.isDirectory()) {
            File[] filelist = directory.listFiles();
            for (File file : filelist) {
                if (file.isDirectory()) {
                    scanComponentDocument(file.getAbsolutePath());
                } else {
                    if ("document.html".equals(file.getName())) {
                        try {
                            InputStreamReader reader = new InputStreamReader(new FileInputStream(file.getAbsoluteFile()));
                            BufferedReader buffer = new BufferedReader(reader);
                            StringBuilder lineBuffer = new StringBuilder();
                            String line;
                            while ((line = buffer.readLine()) != null) {
                                lineBuffer.append(line);
                            }
                            documents.put(file.getParentFile().getName(), lineBuffer.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return documents;
    }
}
