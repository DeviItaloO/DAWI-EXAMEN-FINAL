package pe.edu.I202224460.examen_final.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.I202224460.examen_final.dto.CarDTO;
import pe.edu.I202224460.examen_final.dto.CarDetailDTO;
import pe.edu.I202224460.examen_final.entity.Car;
import pe.edu.I202224460.examen_final.repository.CarRepository;
import pe.edu.I202224460.examen_final.service.interfaces.CarService;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDTO> getAllCars() throws Exception {
        List<CarDTO> cars = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add( new CarDTO(
                    car.getCarId(),
                    car.getModel(),
                    car.getYear(),
                    car.getMileage(),
                    car.getColor()
                    )
            );
        });
        return cars;
    }

    @Override
    public Optional<CarDetailDTO> getCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDTO(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()
        ));
    }

    @Override
    public boolean createCar(CarDetailDTO carDetailDTO) throws Exception {
        Optional<Car> optional = carRepository.findById(carDetailDTO.carId());
        if (optional.isEmpty()){
            Car car = new Car();
            //car.setCarId(carDetailDTO.carId());
            car.setMake(carDetailDTO.make());
            car.setModel(carDetailDTO.model());
            car.setYear(carDetailDTO.year());
            car.setVin(carDetailDTO.vin());
            car.setLicensePlate(carDetailDTO.licensePlate());
            car.setOwnerName(carDetailDTO.ownerName());
            car.setOwnerContact(carDetailDTO.ownerContact());
            car.setPurchaseDate(carDetailDTO.purchaseDate());
            car.setMileage(carDetailDTO.mileage());
            car.setEngineType(carDetailDTO.engineType());
            car.setColor(carDetailDTO.color());
            car.setInsuranceCompany(carDetailDTO.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailDTO.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetailDTO.registrationExpirationDate());
            car.setServiceDueDate(carDetailDTO.serviceDueDate());
            carRepository.save(car);
            return true;
        }else
            return false;
    }

    @Override
    public boolean updateCar(CarDTO carDTO) throws Exception {
        Optional<Car> optional = carRepository.findById(carDTO.carId());
        return optional.map( car -> {
            car.setModel(carDTO.model());
            car.setYear(carDTO.year());
            car.setMileage(carDTO.mileage());
            car.setColor(carDTO.color());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCar(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map( car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }
}
