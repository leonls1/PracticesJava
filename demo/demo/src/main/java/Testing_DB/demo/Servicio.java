package Testing_DB.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired 
    private repositorio repo;
    
    public void create(Entidad e){
        repo.save(e);
    }
    
    public void delete(Long id){
        repo.deleteById(id);
    }
    
    public void update(Entidad e){
        repo.save(e);
    }
    
    public Entidad getById(Long id){
        return repo.findById(id).orElse(new Entidad());
    }
    
    public List<Entidad> getAll(){
        return repo.findAll();
    }
}
