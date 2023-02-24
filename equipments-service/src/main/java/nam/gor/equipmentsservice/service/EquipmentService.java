package nam.gor.equipmentsservice.service;

import nam.gor.equipmentsservice.model.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment validateAndGetEquipment(String id);
    List<Equipment> getEquipments();
    Equipment createEquipment(Equipment equipment);
    void deleteEquipment(Equipment equipment);
}
