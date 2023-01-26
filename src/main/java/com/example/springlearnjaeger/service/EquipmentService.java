package com.example.springlearnjaeger.service;

import com.example.springlearnjaeger.domain.Equipment;
import com.example.springlearnjaeger.exceptions.UserNotFoundException;
import com.example.springlearnjaeger.model.request.EquipmentRequestDto;

import java.util.List;

public interface EquipmentService {

    Equipment create(EquipmentRequestDto equipmentRequestDto);

    Equipment update(int id,EquipmentRequestDto equipmentRequestDto) throws UserNotFoundException;

    Equipment get(int id) throws UserNotFoundException;

    void delete(int id) throws UserNotFoundException;

    List<Equipment> getEquipmentList();
}
