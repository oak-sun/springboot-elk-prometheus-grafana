package nam.gor.equipmentsservice.service;

import nam.gor.equipmentsservice.model.exception.EquipmentNotFoundException;
import nam.gor.equipmentsservice.model.Equipment;
import nam.gor.equipmentsservice.dao.EquipmentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentDao dao;
    @Override
    public Equipment validateAndGetEquipment(String id) {
        return dao
                .findById(id)
                .orElseThrow(
                        () -> new EquipmentNotFoundException(id));
    }
    @Override
    public List<Equipment> getEquipments() {
        return dao.findAll();
    }
    @Override
    public Equipment createEquipment(Equipment equipment) {
        return dao.save(equipment);
    }
    @Override
    public void deleteEquipment(Equipment equipment) {
        dao.delete(equipment);
    }
}
