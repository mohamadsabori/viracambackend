package com.viracam.backend.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.stereotype.Service;

/**
 * Created by msabori on 1/23/18.
 */
@Service
public class StorageService {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    public static final Path rootLocation = Paths.get("upload-dir");

    public void store(MultipartFile file, long productId) {
        try {
            if(!Files.exists(Paths.get("upload-dir/" + productId))){
                Files.createDirectory(Paths.get("upload-dir/" + productId));
            }
            if(Files.exists(Paths.get("upload-dir/" + productId + "/" + file.getOriginalFilename()))){
                Files.delete(Paths.get("upload-dir/" + productId + "/" + file.getOriginalFilename()));
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(productId + "/" + file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void store(InputStream file, long productId, String originalFilename) {
        try {
            if(!Files.exists(Paths.get("upload-dir/" + productId))){
                Files.createDirectory(Paths.get("upload-dir/" + productId));
            }
            Files.copy(file, this.rootLocation.resolve(productId + "/" + originalFilename));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            if(!Files.exists(rootLocation)){
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }

    }
}