package com.fikritech.backend.spring.boot.service;

import com.fikritech.backend.spring.boot.entity.Produk;
import com.fikritech.backend.spring.boot.repository.ProdukRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProdukService {

    private final ProdukRepository repository;

    // TODO : getALl, getById, create, update, delete
    public List<Produk> getAll() {
        return repository.findAll();
    }

    public Produk getById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Product with id " + id + " not found."));
    }

    public Produk create(Produk request) {
        Produk produk = Produk.builder()
                .nama_produk(request.getNama_produk())
                .keterangan(request.getKeterangan())
                .harga(request.getHarga())
                .jumlah(request.getJumlah())
                .build();

        repository.save(produk);

        return produk;
    }

    public Produk updateById(Long id, Produk request) {
        Produk produk = repository.findById(id).orElseThrow(()
                -> new RuntimeException("Product with id " + id + " not found."));

        if (Objects.nonNull(request.getNama_produk())
                && !"".equalsIgnoreCase(request.getNama_produk())) {
            produk.setNama_produk(request.getNama_produk());
        }
        if (Objects.nonNull(request.getKeterangan())
                && !"".equalsIgnoreCase(request.getKeterangan())) {
            produk.setKeterangan(request.getKeterangan());
        }
        produk.setHarga(request.getHarga());
        produk.setJumlah(request.getJumlah());

        repository.save(produk);

        return produk;
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}
