package nam.gor.equipmentsservice.controller;

import nam.gor.equipmentsservice.model.mapper.EquipmentMapper;
import nam.gor.equipmentsservice.model.dto.CreateEquipmentRequest;
import nam.gor.equipmentsservice.model.dto.EquipmentResponse;
import nam.gor.equipmentsservice.service.EquipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/service/equipments")
public class EquipmentController {
    private final EquipmentService service;
    private final EquipmentMapper mapper;

    @GetMapping
    public List<EquipmentResponse> getEquipments() {
        log.debug("Get all equipments");
        return service
                .getEquipments()
                .stream()
                .map(mapper::toEquipmentResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public EquipmentResponse getEquipment(@PathVariable("id") String id) {
        log.debug("Get equipment {}", kv("id", id));
        if (id.equals("111")) {
            throw new NullPointerException(
                    "It's known that there is a bug with this equipment");
        }
        var equipment = service.validateAndGetEquipment(id);
        return mapper.toEquipmentResponse(equipment);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EquipmentResponse createMovie(@Valid @RequestBody
                                             CreateEquipmentRequest request) {
        log.debug("Equipment created {}",
                kv("id", request.getId()));
        var equipment = mapper.toEquipment(request);
        equipment = service.createEquipment(equipment);
        return mapper.toEquipmentResponse(equipment);
    }

    @DeleteMapping("/{imdb}")
    public String deleteEquipment(@PathVariable("id") String id) {
        log.debug("Equipment deleted {}",
                kv("id", id));
        var equipment = service.validateAndGetEquipment(id);
        service.deleteEquipment(equipment);
        return equipment.getId();
    }
}
