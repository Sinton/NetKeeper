package com.github.xml;

import com.github.document.DocumentFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.HashMap;

/**
 * @author Yan
 */
public class VueComponentPropFactory {
    public static HashMap<String, HashMap<String, String[]>> COMPONENT_PROP;
    static {
        COMPONENT_PROP = scanComponentProp(VueComponentPropFactory.class.getResource(DocumentFactory.DIR).getPath());
    }

    private static HashMap<String, HashMap<String, String[]>> scanComponentProp(String folderPath) {
        HashMap<String, HashMap<String, String[]>> props = new HashMap<>(16);
        File directory = new File(folderPath);

        if (directory.isDirectory()) {
            File[] filelist = directory.listFiles();
            for (File file : filelist) {
                if (file.isDirectory()) {
                    scanComponentProp(file.getAbsolutePath());
                } else {
                    if ("tag.json".equals(file.getName())) {
                        try {
                            InputStreamReader reader = new InputStreamReader(new FileInputStream(file.getAbsoluteFile()));
                            BufferedReader buffer = new BufferedReader(reader);
                            StringBuilder lineBuffer = new StringBuilder();
                            String line;
                            while ((line = buffer.readLine()) != null) {
                                lineBuffer.append(line);
                            }
                            JsonObject tag = new JsonParser().parse(lineBuffer.toString()).getAsJsonObject();
                            HashMap<String, String[]> attrs = new Gson().fromJson(tag.get("prop"),
                                                                                  new TypeToken<HashMap<String, String[]>>() {}.getType());
                            props.put(tag.getAsJsonObject("tag").getAsString(), attrs);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return props;
    }
}
