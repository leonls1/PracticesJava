package model.service;


import java.util.List;
import model.businessLogic.entity.Speciality;
import model.persistence.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class SpecialityImp implements SpecialityService{
    @Autowired
    private SpecialityRepository repo;


    @Override
    public List<Speciality> getAll() {
        List<Speciality> list = repo.findAll();
        return  list;
    }

    @Override
    public Speciality getById(Long id) {
        return repo.findById(id).
                orElseThrow();
    }

    @Override
    public void create(Speciality speciality) {
        repo.save(speciality);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Speciality speciality) {

    }
}