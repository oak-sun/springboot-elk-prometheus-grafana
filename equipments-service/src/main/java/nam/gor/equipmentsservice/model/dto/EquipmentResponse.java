package nam.gor.equipmentsservice.model.dto;

public record EquipmentResponse(String id,
                                String title,
                                Short year,
                                String category,
                                String project) {
}
