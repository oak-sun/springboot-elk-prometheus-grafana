package nam.gor.equipmentsservice.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(String id) {
        super(String.format(
                "Equipment with id %s not found",
                id));
    }
}
