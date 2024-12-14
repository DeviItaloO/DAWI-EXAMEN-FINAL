package pe.edu.I202224460.examen_final.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.I202224460.examen_final.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}
