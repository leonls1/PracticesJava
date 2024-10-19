package ar.edu.utn.frc.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.utn.frc.entities.Composer;

public class ComposerService {

    //mapa de los compositores compuesto por el nombre como clave y el valor como una entidad asociada
    private Map<String, Composer> composers;

    public ComposerService() {
        composers = new HashMap<>();
    }

    public Set<Composer> getOrCreateComposers(String names) {
        Set<Composer> result = new HashSet<>();
        String[] composerNames = names.split("[,&]");
        for (String composerName : composerNames) {
            //verifica si el compositor actual del ciclo se encuntra ya en el hashmap
            if (composers.containsKey(composerName)) {
                //si ya se encuentra en el mapa al resultado le agrega este compositor buscandolo solamente
                result.add(composers.get(composerName));
            } else {
                //si aun no existe entonces se instancia uno nuevo
                Composer newComposer = new Composer(composerName);
                //aca se lo agrega al mapita cosa de tenerlo registrado
                composers.put(composerName, newComposer);
                //aca agrega al compositor nuevo tambien al resultado
                result.add(newComposer);
            }
        }
        return result;
    }

}
