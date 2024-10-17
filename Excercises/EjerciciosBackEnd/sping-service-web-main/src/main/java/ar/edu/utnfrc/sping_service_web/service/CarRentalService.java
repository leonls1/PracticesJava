package ar.edu.utnfrc.sping_service_web.service;

import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.CarRentalNotFoundException;
import ar.edu.utnfrc.sping_service_web.model.entities.CarRental;
import ar.edu.utnfrc.sping_service_web.repository.CarRentalRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentalService extends ServiceImp<CarRental, Long> {
    private CarRentalRepository repository;

    @Autowired
    public CarRentalService(CarRentalRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(CarRental entity) {
        repository.save(entity);
    }

    @Override
    public CarRental findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CarRentalNotFoundException("There isn't a rent with that id:" + id));
    }

    @Override
    public List<CarRental> findAll() {
        return repository.findAll();
    }

    public Page<CarRental> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public CarRental update(CarRental entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new CarRentalNotFoundException("There isn't a rent with that id:" + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void setRentalToPayed(Long id) {
        CarRental rental = findById(id);
        rental.setPaid(true);
        update(rental);
    }

    public List<CarRental> getUnpaidRents() {
        return repository.findByPaidIsFalse();
    }
}
