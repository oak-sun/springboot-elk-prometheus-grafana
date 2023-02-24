package nam.gor.equipmentsservice.model.mapper;

import nam.gor.equipmentsservice.model.Equipment;
import nam.gor.equipmentsservice.model.dto.CreateEquipmentRequest;
import nam.gor.equipmentsservice.model.dto.EquipmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    Equipment toEquipment(CreateEquipmentRequest request);

    EquipmentResponse toEquipmentResponse(Equipment equipment);
}
