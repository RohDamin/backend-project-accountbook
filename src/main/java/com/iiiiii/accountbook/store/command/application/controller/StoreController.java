package com.iiiiii.accountbook.store.command.application.controller;

import com.iiiiii.accountbook.exception.NotValidRequestException;
import com.iiiiii.accountbook.store.command.application.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController("StoreControllerCommand")
@RequestMapping("/stores")
@Slf4j
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/good")
    public ResponseEntity<?> registerGoodStore(@RequestParam("file") MultipartFile file) throws Exception {

        storeService.registerGoodStore(file);

        return ResponseEntity
                .created(URI.create("/stores/search?is-good=true"))
                .build();
    }

    @PutMapping("/good/{storeCode}")
    public ResponseEntity<?> modifyGoodStoreToN(@PathVariable int storeCode) {

        storeService.modifyGoodStoreToN(storeCode);

        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping("/{storeCode}")
    public ResponseEntity<?> removeStore(@PathVariable int storeCode) throws NotValidRequestException {

        storeService.removeStore(storeCode);

        return ResponseEntity
                .noContent()
                .build();
    }
}