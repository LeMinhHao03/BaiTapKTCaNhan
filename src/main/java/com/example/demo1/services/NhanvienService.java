package com.example.demo1.services;

import com.example.demo1.entity.Nhanvien;
import com.example.demo1.repository.INhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanvienService {
    @Autowired
    private INhanvienRepository nhanvienRepository;

    public List<Nhanvien> getAllNhanviens()
    {
        return nhanvienRepository.findAll();
    }

    public Nhanvien getNhanvienById(String Ma_NV)
    {
        return nhanvienRepository.findById(Ma_NV).orElse(null);
    }

    public void addNhanvien(Nhanvien nhanvien)
    {
        nhanvienRepository.save(nhanvien);
    }

    public void deleteNhanvien(String Ma_NV)
    {
        nhanvienRepository.deleteById(Ma_NV);
    }

    public void updateNhanvien(Nhanvien nhanvien)
    {
        nhanvienRepository.save(nhanvien);
    }
}
