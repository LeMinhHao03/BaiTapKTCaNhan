package com.example.demo1.controller;

import com.example.demo1.entity.PhongBan;
import com.example.demo1.services.PhongbanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/PhongBans")
public class PhongBanController {
    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String showAllPhongBans(Model model){
        List<PhongBan> PhongBans = phongbanService.getAllPhongBans();
        model.addAttribute("PhongBans", PhongBans);
        model.addAttribute("Ten_Phong", "PhongBan List");
        return "PhongBan/list";
    }

    @GetMapping("/add")
    public String savePhongBanForm(Model model){
        model.addAttribute("PhongBan", new PhongBan());
        model.addAttribute("PhongBans", phongbanService.getAllPhongBans());
        return "PhongBan/add";
    }


    @PostMapping("/add")
    public String saveCategory(@Valid @ModelAttribute("PhongBan") PhongBan phongban, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("PhongBans", phongbanService.getAllPhongBans());
            return "PhongBan/add";
        }
        phongbanService.savePhongBan(phongban);
        return "redirect:/PhongBans";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("Ma_Phong") String Ma_Phong, Model model){
        PhongBan editPhongban = phongbanService.getPhongBanById(Ma_Phong);
        if(editPhongban!=null){
            model.addAttribute("PhongBan", editPhongban);
            model.addAttribute("PhongBans", phongbanService.getAllPhongBans());
            return "PhongBan/edit";
        } else {
            return "redirect:/PhongBans";
        }
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@Valid @PathVariable("Ma_Phong")String Ma_Phong, @ModelAttribute("PhongBans") PhongBan editPhongban, BindingResult result, Model model){
        // check lỗi
        if (result.hasErrors()){
            model.addAttribute("PhongBans", phongbanService.getAllPhongBans());
            return "PhongBan/add";
        }
        else {
            PhongBan existingPhongban = phongbanService.getPhongBanById(Ma_Phong);
            if (existingPhongban != null){
                existingPhongban.setTen_Phong(editPhongban.getTen_Phong());
                phongbanService.updatePhongBan(existingPhongban);
            }
            return "redirect:/PhongBans";
        }
    }

    @GetMapping ("/delete/{id}")
    public String deletePhongBan(@PathVariable("Ma_Phong") String Ma_Phong)
    {
        PhongBan phongban = phongbanService.getPhongBanById(Ma_Phong);
        phongbanService.deletePhongBan(Ma_Phong);
        return "redirect:/PhongBans";
    }
}
