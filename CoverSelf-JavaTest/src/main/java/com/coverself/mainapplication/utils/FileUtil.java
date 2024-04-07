package com.coverself.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    public static void saveToFile(String content, String filePath) {
        try {
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
