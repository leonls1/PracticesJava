package ar.edu.utnfrc.sping_service_web.controller;

import ar.edu.utnfrc.sping_service_web.model.entities.ClientCompany;
import ar.edu.utnfrc.sping_service_web.service.ClientCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/client-company")
@RestController
public class ClientCompanyController {
    private final ClientCompanyService service;

    //4. ClientCompanyController que tiene los siguientes endpoints:
    //   1. Agregar una nueva empresa
    @PostMapping("/")
    public ResponseEntity<?> createCompany(@RequestBody ClientCompany company) {
        service.create(company);
        return new ResponseEntity<>("company created", HttpStatus.OK);
    }

    //   2. Dar de baja una empresa (eso quita todos los empleados), solo si no tiene alquileres impagos
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("company successfully deleted", HttpStatus.OK);
    }

    //   3. Obtener una empresa por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    //   4. Asociar un empleado a una empresa
    @PatchMapping("/{companyId}/{clientId}")
    public ResponseEntity<?> associateEmployeeToACompany(@PathVariable Long companyId,
                                                         @PathVariable Long clientId) {
        service.associateClientToToACompany(companyId, clientId);
        return new ResponseEntity<>("Client successfully associated", HttpStatus.OK);
    }
}
