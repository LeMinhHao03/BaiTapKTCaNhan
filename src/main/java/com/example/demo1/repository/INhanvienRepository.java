package com.example.demo1.repository;

import com.example.demo1.entity.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INhanvienRepository extends JpaRepository<Nhanvien, String> {
}
