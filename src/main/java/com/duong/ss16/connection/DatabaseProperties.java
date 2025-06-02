package com.duong.ss16.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseProperties {

    private static final String FILE_PATH = "D:/Learn/JavaWeb/homeworks/ss16/src/main/resources/database.properties";

    public static Properties load() {
        Properties p = new Properties();
        try (InputStream i = new FileInputStream(FILE_PATH)) {
            p.load(i);
        } catch (Exception e) {
            System.err.println("Lỗi load cấu hình DB" + e.getMessage());
            return null;
        }

        return p;
    }
}
