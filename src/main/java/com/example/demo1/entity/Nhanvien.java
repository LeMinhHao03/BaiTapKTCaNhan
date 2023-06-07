package com.example.demo1.entity;

import com.example.demo1.Validator.annotation.ValidUserId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "NhanVien")
public class Nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Ma_NV;

    @Column(name = "Ten_NV")
    private String Ten_NV;

    @Column(name = "Phai")
    private String Phai;

    @Column(name = "Noi_Sinh")
    private String Noi_Sinh;

    @Column(name = "Ma_Phong")
    private String Ma_Phong;

    @Column(name = "Luong")
    private Long Luong;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongban;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
