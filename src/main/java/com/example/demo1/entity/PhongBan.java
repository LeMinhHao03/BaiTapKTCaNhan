package com.example.demo1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Ma_Phong;

    @Column(name = "Ten_Phong")
    private String Ten_Phong;

    @OneToMany(mappedBy = "PhongBan", cascade = CascadeType.ALL)
    private List<Nhanvien> nhanviens;
}
