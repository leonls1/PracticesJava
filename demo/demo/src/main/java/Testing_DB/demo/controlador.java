package Testing_DB.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entidad")
public class controlador {
    
    @Autowired 
    private Servicio service;

    @PostMapping
    public ResponseEntity create(@RequestBody Entidad e){
        return new ResponseEntity("Entidad creada", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity("Entidad borrada", HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity update(@RequestBody Entidad e){
        service.update(e);
        return new ResponseEntity("Entidad actualizada", HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public Entidad getById(@PathVariable("id") Long id){
        return service.getById(id);
    }
    
    @GetMapping("/getAll")
    public List<Entidad> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/saludo")
    public String hii(){
        return "Hello, world";
    }
    
    @GetMapping("/saludo/{persona}")
    public String hii_person(@PathVariable("persona") String persona){
        return "Hello, world" + persona;
     }
}
