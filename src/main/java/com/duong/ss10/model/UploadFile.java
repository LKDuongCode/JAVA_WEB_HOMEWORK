package com.duong.ss10.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile {
    private int id;
    private MultipartFile file;
    private String url;
    private String des;

    public UploadFile(int id, String url, String des) {
        this.id = id;
        this.url = url;
        this.des = des;
    }

    public UploadFile(String url, String des) {
        this.url = url;
        this.des = des;
    }
}
