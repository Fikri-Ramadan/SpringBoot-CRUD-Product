package com.fikritech.backend.spring.boot.repository;

import com.fikritech.backend.spring.boot.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
