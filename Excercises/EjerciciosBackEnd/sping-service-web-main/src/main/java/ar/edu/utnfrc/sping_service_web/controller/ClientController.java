package ar.edu.utnfrc.sping_service_web.controller;

import ar.edu.utnfrc.sping_service_web.model.entities.Client;
import ar.edu.utnfrc.sping_service_web.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    //5. ClientController que tiene solo las CRUD operation estandar.
    private final ClientService service;

    @PostMapping("/")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        service.create(client);
        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }

    ;

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);

    }

    @GetMapping("/")
    public ResponseEntity<?> getAllClients() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id,
                                          @RequestBody Client client) {
        client.setId(id);
        return new ResponseEntity<>(service.update(client), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCLientById(@PathVariable Long id) {

        service.deleteById(id);
        return new ResponseEntity<>("client deleted successfully", HttpStatus.ACCEPTED);

    }

}
