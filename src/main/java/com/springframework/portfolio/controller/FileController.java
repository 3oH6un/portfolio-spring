package com.springframework.portfolio.controller;

import com.springframework.portfolio.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public String uploadFile(@RequestParam final MultipartFile file) {

        return fileService.uploadFile(file);
    }

    @GetMapping("/{fileName}")
    public byte[] getFile(@PathVariable final String fileName) {

        return fileService.getFile(fileName);
    }
}
