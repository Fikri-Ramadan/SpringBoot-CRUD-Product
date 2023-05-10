package com.fikritech.backend.spring.boot.controller;

import com.fikritech.backend.spring.boot.entity.Produk;
import com.fikritech.backend.spring.boot.service.ProdukService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produk")
@RequiredArgsConstructor
@CrossOrigin
public class ProdukController {

    private final ProdukService service;

    @GetMapping
    public ResponseEntity<List<Produk>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Produk> create(@RequestBody Produk request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Produk> updateById(@PathVariable Long id, @RequestBody Produk request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateById(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteById(id));
    }

}
