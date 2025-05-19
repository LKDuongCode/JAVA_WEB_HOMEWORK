package com.duong.ss10.service.hw06;

import com.duong.ss10.model.UploadFile;
import com.duong.ss10.repository.hw06.UploadFileRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UploadFileService {
    Optional<UploadFile> addFileImage (UploadFile uploadFile);
}
