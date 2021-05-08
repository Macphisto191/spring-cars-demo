package springcarsdemo.services;

import springcarsdemo.services.models.CarServiceModel;

import java.util.List;

public interface CarService {

    CarServiceModel save (CarServiceModel carServiceModel);

    List<CarServiceModel> getAllCars ();
}
