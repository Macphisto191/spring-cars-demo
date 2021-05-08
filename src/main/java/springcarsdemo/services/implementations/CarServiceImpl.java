package springcarsdemo.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springcarsdemo.data.models.Car;
import springcarsdemo.data.repositories.CarRepository;
import springcarsdemo.services.CarService;
import springcarsdemo.services.models.CarServiceModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CarServiceModel save(CarServiceModel carServiceModel) {
       this.carRepository.saveAndFlush(this.modelMapper
       .map(carServiceModel, Car.class));

        return carServiceModel;
    }

    @Override
    public List<CarServiceModel> getAllCars() {
        return this.carRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CarServiceModel.class))
                .collect(Collectors.toList());
    }
}
