package com.duong.ss05.utils;

import java.io.InputStream;
import java.util.Properties;

import java.io.FileInputStream;


public class DatabaseConfig {
    private static final String FILE_PATH = "D:/Learn/JavaWeb/ss05_hw/src/main/resources/database.properties";

    public static Properties load() {
        Properties p = new Properties();

        try (InputStream i = new FileInputStream(FILE_PATH)) {
            p.load(i);
        } catch (Exception e) {
            System.err.println("Lỗi đọc file cấu hình: " + e.getMessage());
            return null;
        }

        return p;
    }
}
