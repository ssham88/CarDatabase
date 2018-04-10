package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.car.model.Car;
import com.car.repository.CarRepository;
import com.car.repository.CarSearchRepository;

@RestController
public class CarController {
	@Autowired
	CarRepository carRepository;
	@Autowired
	CarSearchRepository carSearchRepository;
	@RequestMapping("/home")
	public List<Car> home() {
		return carRepository.findAll();
	}
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST ,consumes=MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @RequestMapping(value = "/search/{val}", method = RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Car> search(@PathVariable String val) {
        return (List<Car>)carSearchRepository.searchCars(val);
    }
}
