package com.example.exercice_furniture.controller;

import com.example.exercice_furniture.entity.CartItem;
import com.example.exercice_furniture.entity.Furniture;
import com.example.exercice_furniture.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FurnitureController {
    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/furnitureList")
    public String furnitureList(Model model) {
        model.addAttribute("furnitures", furnitureService.findAll());
        model.addAttribute("cartItem", new CartItem());
        return "furnitureList";
    }

    @GetMapping("/addFurniture")
    public String addFurniture(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "addFurniture";
    }

    @GetMapping("/addFurniture/{id}")
    public String updateFurniture(Model model, @PathVariable int id) {
        model.addAttribute("furniture", furnitureService.findFurnitureById(id));
        return "addFurniture";
    }

    @PostMapping("/addFurniture")
    public String addFurniture(@ModelAttribute Furniture furniture) {
        furnitureService.addFurniture(furniture);
        return "redirect:/furnitureList";
    }

    @GetMapping("/deleteFurniture/{id}")
    public String deleteFurniture(@PathVariable int id) {
        furnitureService.deleteFurnitureById(id);
        return "redirect:/furnitureList";
    }


}
