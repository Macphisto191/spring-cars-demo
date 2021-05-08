package springcarsdemo.web.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import springcarsdemo.data.models.Car;
import springcarsdemo.services.CarService;
import springcarsdemo.services.models.CarServiceModel;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView,
                               @ModelAttribute CarServiceModel carServiceModel) {


        modelAndView.setViewName("create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView confirmCreate(ModelAndView modelAndView,
                                      @ModelAttribute CarServiceModel carServiceModel) {
//        Car car = this.modelMapper.map(carServiceModel, Car.class);

        this.carService.save(carServiceModel);

        modelAndView.setViewName("redirect:/all");
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView all(ModelAndView modelAndView) {
        List<CarServiceModel> cars = this.carService.getAllCars();
        modelAndView.addObject("cars", cars);
        modelAndView.setViewName("all");

        return modelAndView;

    }
}
