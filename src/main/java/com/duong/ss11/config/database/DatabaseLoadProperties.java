package com.duong.ss11.config.database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseLoadProperties {
    // 1. init đường dẫn đến file cần load
    private static final String FILE_PATH = "D:/Learn/JavaWeb/homeworks/ss11/src/main/resources/database.properties";

    //2. tạo hàm load dữ liệu file từ đường dẫn
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
