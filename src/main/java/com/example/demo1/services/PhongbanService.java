package com.example.demo1.services;

import com.example.demo1.entity.PhongBan;
import com.example.demo1.repository.IPhongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongbanService {
    @Autowired
    private IPhongbanRepository phongbanRepository;

    public List<PhongBan> getAllPhongBans(){ return phongbanRepository.findAll(); }
    public PhongBan getPhongBanById(String Ma_Phong) { return phongbanRepository.findById(Ma_Phong).orElse(null); }
    public PhongBan savePhongBan(PhongBan phongban) { return phongbanRepository.save(phongban); }
    public void deletePhongBan(String Ma_Phong) { phongbanRepository.deleteById(Ma_Phong); }
    public void updatePhongBan(PhongBan phongban)
    {
        phongbanRepository.save(phongban);
    }
}
