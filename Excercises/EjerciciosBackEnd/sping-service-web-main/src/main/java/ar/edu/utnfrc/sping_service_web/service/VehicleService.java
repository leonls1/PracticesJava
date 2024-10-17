package ar.edu.utnfrc.sping_service_web.service;

import ar.edu.utnfrc.sping_service_web.model.entities.Vehicle;
import ar.edu.utnfrc.sping_service_web.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.VehicleNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService extends ServiceImp<Vehicle, Long> {
    private final VehicleRepository repository;
    private String notFoundVehicleMessage = "There isn't a vehicle with that id:";


    @Override
    public void create(Vehicle entity) {
        repository.save(entity);
    }

    @Override
    public Vehicle findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(notFoundVehicleMessage + id));

    }

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Page<Vehicle> findAllByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Vehicle update(Vehicle entity) {
        if (existsById(entity.getId())) {
            repository.save(entity);
        } else {
            throw new VehicleNotFoundException(notFoundVehicleMessage + entity.getId());
        }
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        if (existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new VehicleNotFoundException(notFoundVehicleMessage + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Vehicle updateMiles(Long id, int miles) {
        Vehicle vehicle = findById(id);
        vehicle.setTotalMiles(miles);
        return update(vehicle);
    }

}
