package com.example.exercice_furniture.service;

import com.example.exercice_furniture.dao.FurnitureRepository;
import com.example.exercice_furniture.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {
    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> findAll(){
        return furnitureRepository.findAll();
    }

    public Furniture addFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    public Furniture findFurnitureById(int id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    public void deleteFurnitureById(int id) {
        furnitureRepository.deleteById(id);
    }
}
