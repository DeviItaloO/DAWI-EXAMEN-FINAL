package pe.edu.I202224460.examen_final.service.interfaces;

import pe.edu.I202224460.examen_final.dto.CarDTO;
import pe.edu.I202224460.examen_final.dto.CarDetailDTO;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDTO> getAllCars() throws Exception;
    Optional<CarDetailDTO> getCarById(int id) throws Exception;
    boolean createCar(CarDetailDTO carDetailDTO) throws Exception;
    boolean updateCar(CarDTO carDTO) throws Exception;
    boolean deleteCar(int id) throws Exception;
}
