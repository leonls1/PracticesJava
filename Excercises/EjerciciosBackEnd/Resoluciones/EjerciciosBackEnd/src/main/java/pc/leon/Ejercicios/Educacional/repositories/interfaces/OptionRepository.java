package pc.leon.Ejercicios.Educacional.repositories.interfaces;

import pc.leon.Ejercicios.Educacional.entities.Option;

public interface OptionRepository extends Repository<Option, Long>{
    Option findByDescription(String description);
}
