package com.duong.ss10.repository.hw06;

import com.duong.ss10.model.UploadFile;

import java.util.Optional;

public interface UploadFileRepo {
    Optional<UploadFile> insertUploadFile (UploadFile uploadFile);
}
