package com.example.estate.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ViewController {

    @GetMapping("/")
    public ResponseEntity<byte[]> index() {
        try {
            Resource resource = new ClassPathResource("static/index.html");

            if (resource.exists()) {
                byte[] content = Files.readAllBytes(resource.getFile().toPath());
                return ResponseEntity.ok().body(content);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error reading the index.html file.".getBytes());
        }
    }
}
