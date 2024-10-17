package ar.edu.utnfrc.sping_service_web.service;

import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.ClientNotFoundException;
import ar.edu.utnfrc.sping_service_web.model.entities.CarRentalDetail;
import ar.edu.utnfrc.sping_service_web.model.entities.Client;
import ar.edu.utnfrc.sping_service_web.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService extends ServiceImp<Client, Long> {
    private final ClientRepository repository;

    @Override
    public void create(Client entity) {
        repository.save(entity);
    }

    @Override
    public Client findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("there isn't any client with that id:" + id));
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client update(Client entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (this.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ClientNotFoundException("there isn't any client with that id:" + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public static boolean hasUnpaidRents(Client client) {
        return client.getDetails()
                .stream()
                .anyMatch(rental -> !rental.getCarRental().isPaid());
    }



}
