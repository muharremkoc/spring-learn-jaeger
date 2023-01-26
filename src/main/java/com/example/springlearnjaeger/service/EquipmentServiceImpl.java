package com.example.springlearnjaeger.service;

import com.example.springlearnjaeger.domain.Equipment;
import com.example.springlearnjaeger.exceptions.UserNotFoundException;
import com.example.springlearnjaeger.model.request.EquipmentRequestDto;
import com.example.springlearnjaeger.repository.EquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{

     Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);

     final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }


    @Override
    public Equipment create(EquipmentRequestDto equipmentRequestDto) {

        Equipment equipment = new Equipment();
        equipment.setEquipmentName(equipmentRequestDto.getEquipmentName());

        equipmentRepository.save(equipment);

        logger.info(String.format("Equipment Saved with Name: %s",equipment.getEquipmentName()));


        return equipment;
    }

    @Override
    public Equipment update(int id, EquipmentRequestDto equipmentRequestDto) throws UserNotFoundException {


        if (!equipmentRepository.existsById(id)) {
            logger.error(String.format("Equipment's not exist with id : %s", id));
        }else{
            Equipment existEquipment=equipmentRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(String.format("User not found. ID: %s", id)));
            logger.info(String.format("Equipment Exist name: %s",existEquipment.getEquipmentName()));
            existEquipment.setEquipmentName(existEquipment.getEquipmentName());
            equipmentRepository.save(existEquipment);
            logger.info(String.format("Equipment New name: %s",existEquipment.getEquipmentName()));
            return existEquipment;
        }

        throw new UserNotFoundException(String.format("Equipment's not exist with id : %s", id));
    }


    @Override
    public Equipment get(int id) throws UserNotFoundException {


        if (!equipmentRepository.existsById(id)) {
            logger.error(String.format("Equipment's not exist with id : %s", id));
        }else{
            return equipmentRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(String.format("User not found. ID: %s", id)));
        }

        throw new UserNotFoundException(String.format("Equipment's not exist with id : %s", id));

    }

    @Override
    public void delete(int id) throws UserNotFoundException {
        if (!equipmentRepository.existsById(id)) {

            logger.error(String.format("Equipment's not exist with id : %s", id));


            throw new UserNotFoundException(String.format("Equipment's not exist with id : %s", id));
        }
        else{
         Equipment existEquipment =   equipmentRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(String.format("User not found. ID: %s", id)));
            logger.info(String.format("Equipment's exist with %s", existEquipment.toString()));

        }

    }

    @Override
    public List<Equipment> getEquipmentList() {
        return equipmentRepository.findAll();
    }
}
