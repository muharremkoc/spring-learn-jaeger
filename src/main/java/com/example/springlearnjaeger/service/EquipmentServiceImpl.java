package com.example.springlearnjaeger.service;

import com.example.springlearnjaeger.domain.Equipment;
import com.example.springlearnjaeger.model.EquipmentRequestDto;
import com.example.springlearnjaeger.repository.EquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{

    private static final Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);

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
    public Equipment update(int id, EquipmentRequestDto equipmentRequestDto) {


        if (!equipmentRepository.existsById(id)) {
            logger.error(String.format("Equipment's not exist with id : %s", id));
        }else{
            Equipment existEquipment=equipmentRepository.findById(id);
            logger.info(String.format("Equipment Exist name: %s",existEquipment.getEquipmentName()));
            existEquipment.setEquipmentName(existEquipment.getEquipmentName());
            equipmentRepository.save(existEquipment);
            logger.info(String.format("Equipment New name: %s",existEquipment.getEquipmentName()));
            return existEquipment;
        }

        throw new NotFoundException(String.format("Equipment's not exist with id : %s", id));
    }


    @Override
    public Equipment get(int id) {


        if (!equipmentRepository.existsById(id)) {
            logger.error(String.format("Equipment's not exist with id : %s", id));
        }else{
            Equipment existEquipment=equipmentRepository.findById(id);
            logger.info(String.format("Equipment's exist with %s", existEquipment.toString()));
            return existEquipment;
        }

        throw new NotFoundException(String.format("Equipment's not exist with id : %s", id));

    }

    @Override
    public void delete(int id) {
        Equipment existEquipment=equipmentRepository.findById(id);

        if (existEquipment == null) {
            logger.error(String.format("Equipment's not exist with id : %s", id));
        }
        equipmentRepository.delete(existEquipment);
        logger.info(String.format("Equipment's deleted with id : %s", id));

    }

    @Override
    public List<Equipment> getEquipmentList() {
        return equipmentRepository.findAll();
    }
}
