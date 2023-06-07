package com.example.demo1.repository;

import com.example.demo1.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhongbanRepository extends JpaRepository<PhongBan, String> {
}
