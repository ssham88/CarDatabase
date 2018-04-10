package com.car.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.car.model.Car;

public interface CarRepository extends MongoRepository<Car,String>{

}
