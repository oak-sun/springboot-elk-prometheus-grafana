package nam.gor.equipmentsservice.model.dto;

import nam.gor.equipmentsservice.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateEquipmentRequest {

    @Schema(example = "4056666")
    @NotBlank
    private String id;

    @Schema(example = "NQ-P")
    @NotBlank
    private String title;

    @Schema(example = "BIT NQ-P BLUE (P577) S C12 FD 8@250")
    @NotBlank
    private String description;

    @Schema(example = "2017")
    @Positive
    private Short year;

    @Schema(example = "DiamondBits")
    @NotNull
    private Category category;

    @Schema(example = "Nony")
    @NotBlank
    private String project;
}
