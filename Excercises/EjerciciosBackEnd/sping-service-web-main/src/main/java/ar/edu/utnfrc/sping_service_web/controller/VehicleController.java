package ar.edu.utnfrc.sping_service_web.controller;

import ar.edu.utnfrc.sping_service_web.model.entities.Vehicle;
import ar.edu.utnfrc.sping_service_web.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService service;

    //2. Agregar un nuevo vehículo
    @PostMapping("/")
    public ResponseEntity<?> createVehicle() {
        return new ResponseEntity<>("vehicle created", HttpStatus.OK);
    }

    //3. Obtener un vehículo por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> findVehicleById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    //1. Listado de vehículos disponibles (todos los datos)
    @GetMapping("/")
    public ResponseEntity<?> findAllVehiclesPaged(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Page<Vehicle> vehicles = service.findAllByPage(page, size);
        if (!vehicles.isEmpty()) {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No vehicles to show", HttpStatus.NO_CONTENT);
        }

    }

    @PutMapping("/")
    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(service.update(vehicle), HttpStatus.OK);
    }

    // 3. Dar de baja un vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Vehicle successfully deleted", HttpStatus.OK);
    }

    //4. Actualizar millaje del uso del vehículo
    @PatchMapping("/{id}/{miles}")
    public ResponseEntity<?> updateVehicleMiles(@PathVariable Long id,
                                                @PathVariable int miles){
        return new ResponseEntity<>(service.updateMiles(id, miles), HttpStatus.OK);
    }
}
