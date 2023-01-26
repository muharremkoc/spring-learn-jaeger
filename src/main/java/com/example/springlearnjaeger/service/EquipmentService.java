package com.example.springlearnjaeger.service;

import com.example.springlearnjaeger.domain.Equipment;
import com.example.springlearnjaeger.model.EquipmentRequestDto;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    Equipment create(EquipmentRequestDto equipmentRequestDto);

    Equipment update(int id,EquipmentRequestDto equipmentRequestDto);

    Equipment get(int id);

    void delete(int id);

    List<Equipment> getEquipmentList();
}
