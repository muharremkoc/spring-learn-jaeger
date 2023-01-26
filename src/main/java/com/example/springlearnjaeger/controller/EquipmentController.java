package com.example.springlearnjaeger.controller;

import com.example.springlearnjaeger.domain.Equipment;
import com.example.springlearnjaeger.model.EquipmentRequestDto;
import com.example.springlearnjaeger.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jaeger")
public class EquipmentController {

    final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("")
    public String test(){
        return "Jaeger Test";
    }


    @PostMapping("/equipment")
    public Equipment create(@RequestBody EquipmentRequestDto equipmentRequestDto){
        return equipmentService.create(equipmentRequestDto);
    }

    @PutMapping("/equipment/{id}")
    public Equipment update(@PathVariable("id") int id ,@RequestBody EquipmentRequestDto equipmentRequestDto){
        return equipmentService.update(id,equipmentRequestDto);
    }

    @GetMapping("/equipment/{id}")
    public Equipment get(@PathVariable("id") int id){
        return equipmentService.get(id);
    }

    @DeleteMapping("/equipment/{id}")
    public void delete(@PathVariable("id") int id){
         equipmentService.delete(id);
    }

    @GetMapping("/equipment")
    public List<Equipment> getEquipments(){
        return equipmentService.getEquipmentList();
    }




}
