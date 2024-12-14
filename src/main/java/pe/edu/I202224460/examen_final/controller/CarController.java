package pe.edu.I202224460.examen_final.controller;

import org.hibernate.sql.model.jdbc.OptionalTableUpdateOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.I202224460.examen_final.dto.CarDTO;
import pe.edu.I202224460.examen_final.dto.CarDetailDTO;
import pe.edu.I202224460.examen_final.response.*;
import pe.edu.I202224460.examen_final.service.interfaces.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/listCar")
    public FindCarsResponse findCars(){
        try {
            List<CarDTO> cars = carService.getAllCars();
            if (cars != null && !cars.isEmpty()) {
                return new FindCarsResponse("200", "Success: Carros recuperados", cars);
            }else{
                return new FindCarsResponse("404", "Failed: Carros no encontrados", null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new FindCarsResponse("500", "Error en el servidor", null);
        }
    }

    @GetMapping("/detailCar")
    public FindCarResponse findCarsById(@RequestParam(value = "id", defaultValue = "0") String id){
        try {
            Optional<CarDetailDTO> optional = carService.getCarById(Integer.parseInt(id));
            return optional.map(user ->
                    new FindCarResponse("200", "Success: Carro recuperado", user)
            ).orElse(
                    new FindCarResponse("404", "Failed: Carro no encontrado", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("500", "Error en el servidor", null);
        }
    }

    @PostMapping("/createCar")
    public CreateCarResponse createCar(@RequestBody CarDetailDTO carDetailDTO){
        try {
            if (carService.createCar(carDetailDTO))
                return new CreateCarResponse("201", "Success: Carro creado exitosamente", true);
            else
                return new CreateCarResponse("400", "Failed: Error al crear el carro", false);
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("500", "Error en el servidor", false);
        }
    }

    @PutMapping("/updateCar")
    public UpdateCarResponse updateCar(@RequestBody CarDTO carDTO) {
        try {
            if(carService.updateCar(carDTO))
                return new UpdateCarResponse("200", "Success: Carro actualizado exitosamente", true);
            else
                return new UpdateCarResponse("400", "Failed: Error al actualizar el carro", false);
        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("500", "Error en el servidor", false);
        }
    }

    @DeleteMapping("/deleteCar/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {
        try {
            if (carService.deleteCar(Integer.parseInt(id))) {
                return new DeleteCarResponse("200", "Success: Carro eliminado exitosamente", true);
            } else {
                return new DeleteCarResponse("404", "Failed: Carro no encontrado", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("500", "Error en el servidor", false);
        }
    }

}
