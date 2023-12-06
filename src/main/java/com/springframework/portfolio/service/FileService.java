package com.springframework.portfolio.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
public class FileService {

    @Value("${UploadPath}")
    private String uploadPath;

    public String uploadFile(MultipartFile image) {

        String originalFileName = image.getOriginalFilename();
        String uuid = String.valueOf(UUID.randomUUID());
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String savedFileName = uuid + extension;
        String fileUploadPath = String.valueOf(Paths.get(uploadPath, savedFileName).toString());

        try {
            // 파일 저장 (write to disk)
            File uploadFile = new File(fileUploadPath);
            image.transferTo(uploadFile);
            return savedFileName;

        } catch (IOException e) {
            // 예외 처리는 따로 해주는 게 좋습니다.
            throw new RuntimeException(e);
        }
    }

    public byte[] getFile(String imgName) {

        String fileUploadPath = String.valueOf(Paths.get(uploadPath, imgName));

        File uploadedFile = new File(fileUploadPath);

        if (!uploadedFile.exists()) {
            throw new RuntimeException();
        }

        try {
            // 이미지 파일을 byte[]로 변환 후 반환
            return Files.readAllBytes(uploadedFile.toPath());
        } catch (IOException e) {
            // 예외 처리는 따로 해주는 게 좋습니다.
            throw new RuntimeException(e);
        }
    }

    public void deleteFile(String filePath) {

        File deleteFile = new File(filePath);

        if (deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제했습니다.");
        } else {
            log.error("파일이 존재하지 않습니다.");
        }
    }
}
