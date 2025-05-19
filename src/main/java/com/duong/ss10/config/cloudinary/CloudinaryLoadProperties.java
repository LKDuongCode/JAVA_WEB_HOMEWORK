package com.duong.ss10.config.cloudinary;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CloudinaryLoadProperties {
    private static final String FILE_PATH = "D:/Learn/JavaWeb/ss10/src/main/resources/application.properties";

    public static Properties load() {
        Properties p = new Properties();
        try (InputStream i = new FileInputStream(FILE_PATH)) {
            p.load(i);
        } catch (Exception e) {
            System.err.println("Lỗi load Cloudinary config: " + e.getMessage());
            return null;
        }
        return p;
    }
}
