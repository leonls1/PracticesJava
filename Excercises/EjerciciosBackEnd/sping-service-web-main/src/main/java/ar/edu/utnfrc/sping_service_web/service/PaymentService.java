package ar.edu.utnfrc.sping_service_web.service;

import ar.edu.utnfrc.sping_service_web.model.entities.Payment;
import ar.edu.utnfrc.sping_service_web.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService extends ServiceImp<Payment, Long>{
    private final PaymentRepository repository;

    @Override
    public void create(Payment entity) {
        repository.save(entity);
    }

    @Override
    public Payment findById(Long aLong) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return List.of();
    }

    @Override
    public Payment update(Payment entity) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }
}
