package com.fikritech.backend.spring.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "produk")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produk {

    @Id
    @GeneratedValue
    private Long id;
    private String nama_produk;
    private String keterangan;
    private long harga;
    private int jumlah;

}
