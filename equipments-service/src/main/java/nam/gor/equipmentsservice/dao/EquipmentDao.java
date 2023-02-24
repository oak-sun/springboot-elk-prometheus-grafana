package nam.gor.equipmentsservice.dao;

import nam.gor.equipmentsservice.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment, String> {
}
