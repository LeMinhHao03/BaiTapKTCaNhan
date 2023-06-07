package com.example.demo1.controller;

import com.example.demo1.entity.Nhanvien;
import com.example.demo1.services.NhanvienService;
import com.example.demo1.services.PhongbanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanvienController {
    @Autowired
    private NhanvienService nhanvienService;
    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String showAllNhanviens(Model model){
        List<Nhanvien> nhanviens = nhanvienService.getAllNhanviens();
        model.addAttribute("nhanviens", nhanviens);
        //model.addAttribute("title", "Nhanvien List");
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanvienForm(Model model){
        model.addAttribute("nhanvien", new Nhanvien());
        model.addAttribute("PhongBans", phongbanService.getAllPhongBans());
        return "nhanvien/add";
    }


    @PostMapping("/add")
    public String addNhanvien(@Valid @ModelAttribute("nhanvien") Nhanvien nhanvien, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("PhongBans", phongbanService.getAllPhongBans());
            return "nhanvien/add";
        }
        nhanvienService.addNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/edit/{id}")
    public String editNhanvienForm(@PathVariable("Ma_NV") String Ma_NV, Model model){
        Nhanvien editNhanvien = nhanvienService.getNhanvienById(Ma_NV);
        if(editNhanvien!=null){
            model.addAttribute("nhanvien",editNhanvien);
            model.addAttribute("PhongBans",phongbanService.getAllPhongBans());
            return "nhanvien/edit";
        }
        else{
            return "redirect:/nhanviens";
        }
    }
    @PostMapping("/edit/{id}")
    public String edit(@Valid @PathVariable("Ma_NV")String Ma_NV, @ModelAttribute("nhanvien") Nhanvien editNhanvien,BindingResult result, Model model){
        // check lỗi
        if (result.hasErrors()){
            model.addAttribute("PhongBans", phongbanService.getAllPhongBans());
            return "nhanvien/edit";
        }
        else {
            Nhanvien existingNhanvien = nhanvienService.getNhanvienById(Ma_NV);
            if (existingNhanvien != null){
                existingNhanvien.setTen_NV(editNhanvien.getTen_NV());
                existingNhanvien.setPhai(editNhanvien.getPhai());
                existingNhanvien.setNoi_Sinh(editNhanvien.getNoi_Sinh());
                existingNhanvien.setMa_Phong(editNhanvien.getMa_Phong());
                existingNhanvien.setLuong(editNhanvien.getLuong());
                existingNhanvien.setPhongban((editNhanvien.getPhongban()));
                nhanvienService.updateNhanvien(existingNhanvien);
            }
            return "redirect:/nhanviens";
        }
    }

    @GetMapping ("/delete/{id}")
    public String deleteBook(@PathVariable("Ma_NV") String Ma_NV)
    {
//        books.removeIf(book -> book.getId().equals(id));

        Nhanvien nhanvien = nhanvienService.getNhanvienById(Ma_NV);
        nhanvienService.deleteNhanvien(Ma_NV);
        return "redirect:/nhanviens";
    }
}
