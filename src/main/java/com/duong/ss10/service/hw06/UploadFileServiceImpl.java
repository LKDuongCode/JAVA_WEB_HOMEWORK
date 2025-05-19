package com.duong.ss10.service.hw06;

import com.duong.ss10.model.UploadFile;
import com.duong.ss10.repository.hw06.UploadFileRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UploadFileServiceImpl implements UploadFileService{
    private final UploadFileRepo uploadFileRepo;

    public UploadFileServiceImpl(UploadFileRepo uploadFileRepo) {
        this.uploadFileRepo = uploadFileRepo;
    }

    @Override
    public Optional<UploadFile> addFileImage(UploadFile uploadFile) {
        return uploadFileRepo.insertUploadFile(uploadFile);
    }
}
