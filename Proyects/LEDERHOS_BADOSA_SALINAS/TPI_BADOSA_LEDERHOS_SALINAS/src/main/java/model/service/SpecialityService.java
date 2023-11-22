package model.service;

import java.util.List;
import model.businessLogic.entity.Speciality;

public interface SpecialityService {
    public List<Speciality> getAll();
    public Speciality getById(Long id);
    public void create(Speciality speciality);
    public void delete(Long id);
    public void update(Speciality speciality);

}